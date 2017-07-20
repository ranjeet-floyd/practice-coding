package future.fry.practice.random;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author ranjeet
 */
public class JavaReflection {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

        //without reflection
        JavaReflection withoutRef = new JavaReflection();
        withoutRef.sayHello("without reflection");

        //with reflection
        Object withReflection = Class.forName("future.fry.practice.random.JavaReflection")
                .newInstance();

        ((JavaReflection) withReflection).sayHello("with reflection");

        Object alternateWithRef = JavaReflection.class.newInstance();
        ((JavaReflection) alternateWithRef).sayHello("with alt reflection");

        //method invokation
        Method m = withoutRef.getClass().getDeclaredMethod("sayHello", new Class<?>[0]);
        m.invoke(withoutRef);
    }

    public void sayHello(String name) {
        System.out.println("hello : " + name);
    }

    public void sayHello() {
        System.out.println("hello");
    }
}
