import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestClass {
    public static void start(Class tested){
        Method[] methods = tested.getDeclaredMethods();


        Method runnedFirst=null;
        Method runnedLast=null;
        List<Method> testMeths = new ArrayList<>();
        for (Method m :methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if(runnedFirst==null){
                    runnedFirst=m;
                }else{
                    throw new RuntimeException("Только 1 метод @BeforeSuite");
                }
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (runnedLast == null) {
                    runnedLast = m;
                } else {
                    throw new RuntimeException("Только 1 метод @BeforeSuite");

                }
            }
            if (m.isAnnotationPresent(Test.class)){
                testMeths.add(m);
            }

        }
        testMeths.sort((o1,o2) -> {
            int first = o1.getAnnotation(Test.class).priority();
            int second = o2.getAnnotation(Test.class).priority();
            return second-first;
        });


        try {
            if (runnedFirst != null) {
                runnedFirst.invoke(null);
            }
            for (Method m:testMeths) {
                System.out.println("Запущен тест с приоритетом "+m.getAnnotation(Test.class).priority());
                m.invoke(null);
            }
            if (runnedLast != null) {
                runnedLast.invoke(null);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



    }
}
