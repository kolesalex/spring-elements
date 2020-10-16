package xyz.kolesa.spring.elements.bpp.sqlautowire;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ResourceUtils;

import lombok.SneakyThrows;

@Component
public class SqlAutowireAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static final String SQL_QUERY_DIRECTORY = "sql/";

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            SqlAutowire annotation = field.getAnnotation(SqlAutowire.class);
            if(annotation != null){
                String content = getQueryFromResource(annotation);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, content);
            }
        }
        return bean;
    }

    private String getQueryFromResource(SqlAutowire annotation) throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + SQL_QUERY_DIRECTORY + annotation.value());
        String content = new String(Files.readAllBytes(file.toPath()));
        return content;
    }

    /**
     * For changes into class itself
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
