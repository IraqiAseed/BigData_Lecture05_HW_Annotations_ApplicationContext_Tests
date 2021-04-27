package my_junit;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class TestRunner {

    @SneakyThrows
    public void runAllTestsOfClass(String className) {

        Class<?> aClass = Class.forName(className);
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Set<Method> beforeMethods = getAllBeforeMethods(declaredMethods);
        runTestMethod(aClass, declaredMethods, beforeMethods);
    }


    @SneakyThrows
    private void runTestMethod(Class<?> aClass, Method[] declaredMethods, Set<Method> beforeMethods) {
        for(Method method : declaredMethods)
        {
            if(  method.getName().startsWith("test")  )
            {
                Object testObj = aClass.getDeclaredConstructor().newInstance();
                for (Method beforeMethod : beforeMethods) {
                    beforeMethod.invoke(testObj);
                }
                method.invoke(testObj);
            }
        }
    }

    private Set<Method> getAllBeforeMethods(Method[] declaredMethods) {
        Set<Method> beforeMethods = new HashSet<>();

        for(Method method : declaredMethods)
        {
            RunBeforeEachTest annotation = method.getAnnotation(RunBeforeEachTest.class);
            if(annotation != null)
            {
                beforeMethods.add(method);
            }

        }
        return beforeMethods;
    }
}
