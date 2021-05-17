import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\cosmi\\IdeaProjects\\Lab12Test\\out\\production\\Lab12Test");
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{file.toURL()}, ClassLoader.getSystemClassLoader());
            Class<?> testClass = urlClassLoader.loadClass("SocialNetwork.Person");
            System.out.println("Package: " + testClass.getPackageName());
            for (Field field : testClass.getDeclaredFields()) {
                System.out.println("Field: " + field.getName());
                System.out.println(field);
            }
            for (Method method : testClass.getDeclaredMethods()){
                System.out.println("Method: " + method.getName());
                System.out.println(method);
                if (method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0 && Modifier.isStatic(method.getModifiers())){
                    method.invoke(null);
                }
            }
        } catch (MalformedURLException | ClassNotFoundException | InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}
