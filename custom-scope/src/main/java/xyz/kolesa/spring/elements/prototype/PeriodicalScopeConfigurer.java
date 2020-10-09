package xyz.kolesa.spring.elements.prototype;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;



public class PeriodicalScopeConfigurer implements Scope {

    private Map<String, Pair<LocalTime,Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        if(map.containsKey(name)){
            if(isOutdatedBean(name)) {
                map.put(name, Pair.of(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(name, Pair.of(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(name).getRight();
    }

    private boolean isOutdatedBean(String name) {
        return LocalTime.now().isAfter(map.get(name).getLeft().plus(3, ChronoUnit.SECONDS));
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
