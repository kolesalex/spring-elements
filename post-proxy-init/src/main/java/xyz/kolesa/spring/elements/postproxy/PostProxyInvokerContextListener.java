package xyz.kolesa.spring.elements.postproxy;

import java.lang.reflect.Method;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private final ConfigurableListableBeanFactory configurableListableBeanFactory;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            //Factory should be used to find original class instead of proxy
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();

            Class<?> originalClass = Class.forName(beanClassName);
            Method[] methods = originalClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PostProxy.class)) {
                    Object bean = context.getBean(name);
                    Class<?> proxyClass = bean.getClass();
                    Method currentMethod = proxyClass.getMethod(method.getName(), method.getParameterTypes());
                    currentMethod.invoke(bean);
                }
            }
        }
    }
}
