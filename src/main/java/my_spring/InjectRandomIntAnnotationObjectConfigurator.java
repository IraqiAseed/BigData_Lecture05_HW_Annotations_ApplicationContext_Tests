package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;


public class InjectRandomIntAnnotationObjectConfigurator implements my_spring.ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            my_spring.InjectRandomInt annotation = field.getAnnotation(my_spring.InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int value = RandomUtil.getNumberBetween(min, max);
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }
}
