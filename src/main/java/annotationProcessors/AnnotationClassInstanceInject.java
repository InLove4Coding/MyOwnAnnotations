package annotationProcessors;


import annotation.ClassInstanceInject;

import java.lang.reflect.Field;

public class AnnotationClassInstanceInject {


    public static void processClassInstanceInject(Class<?> inputClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Field[] fields = inputClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotation(ClassInstanceInject.class) != null) {
                Object newInstance = field.getAnnotation(ClassInstanceInject.class).inject().newInstance();
                field.setAccessible(true);
                field.set(newInstance, newInstance);

            }
        }


    }
}
