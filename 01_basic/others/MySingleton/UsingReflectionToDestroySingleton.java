// src: https://blog.seotory.com/post/2016/03/java-singleton-pattern

package MySingleton;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Constructor;

public class UsingReflectionToDestroySingleton {
    public static void main(String[] args) {
        InitializationOnDemandHolderIdiom instance = InitializationOnDemandHolderIdiom.getInstance();
        InitializationOnDemandHolderIdiom instance2 = null;

        try {
            Constructor[] constructors = InitializationOnDemandHolderIdiom.class.getDeclaredConstructors();
            for ( Constructor constructor : constructors ) {
                constructor.setAccessible(true);
                instance2 = (InitializationOnDemandHolderIdiom) constructor.newInstance();
            }
        } catch (Exception e) {

        }

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
