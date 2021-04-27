package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;


public class InjectAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = my_spring.ObjectFactory.getInstance().createObject(field.getType());
                field.set(t,object);
            }
        }
    }
}
