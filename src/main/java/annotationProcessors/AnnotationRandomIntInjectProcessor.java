package annotationProcessors;

import annotation.RandomIntInject;

import java.lang.reflect.Field;
import java.util.Random;

public class AnnotationRandomIntInjectProcessor {


    public static void processRandomIntInject(Class<?> inputClass) throws NoSuchFieldException, IllegalAccessException {



        Field[] fields = inputClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(RandomIntInject.class) != null) {
                Random random = new Random();
                int min = field.getAnnotation(RandomIntInject.class).min();
                int max = field.getAnnotation(RandomIntInject.class).max();
                field.setAccessible(true);
                field.set(RandomIntInject.class, min + random.nextInt(max - min));
            }
        }
    }
}
