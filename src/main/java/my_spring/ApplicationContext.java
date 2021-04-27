package my_spring;


import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    public static Map<Class,Class> cache = new HashMap<>();
    ObjectFactory objFactory = new ObjectFactory();

    public ApplicationContext() { }

    public Object getObject(Class type) {
        Object obj = null;
        Annotation[] annotations = type.getAnnotations();

        if(annotations != null)
        {
            for (Annotation annotation : annotations)
            {
                if( annotation instanceof Singleton)
                {
                    if(cache.containsKey(type))
                    {
                        return cache.get(type);
                    }
                    else
                    {
                         obj =  objFactory.getInstance().createObject(type);
                        cache.put(type, obj.getClass());
                        return obj;
                    }
                }
            }
        }


        return objFactory.getInstance().createObject(type);


        //todo finish this
        // context should cache all objects, which class marked by @my_spring.Singleton
        // in case object is not singleton, or still not present in cache
        // use my_spring.ObjectFactory to create

    }
}
