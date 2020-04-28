import annotation.ClassInstanceInject;
import annotationProcessors.AnnotationClassInstanceInject;
import annotationProcessors.AnnotationRandomIntInjectProcessor;

public class TestClass {


    // Свой чуть более простой аналог @Autowired Spring'а
    @ClassInstanceInject(inject = RandomGenerator.class)
    public static Object object;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        //Процессоры для аннотаций,
        // было написано в рамках понимания Reflection. In real life будет предзагружено.
        AnnotationRandomIntInjectProcessor.processRandomIntInject(RandomGenerator.class);
        AnnotationClassInstanceInject.processClassInstanceInject(TestClass.class);

        //Тест работы аннотации @RandomInject ( она применяется к полям в классе RandomGenerator)
        System.out.println(RandomGenerator.randomNumber);
        System.out.println(RandomGenerator.randomNumber2);

        //Выведет RandomGenerator, т.е Inject прошёл отлично
        System.out.println(object.getClass().getSimpleName());

        //ну и проверяем, что при кастинге также все работает, т.к мы заинджектили нужный объект
        RandomGenerator randomGenerator = (RandomGenerator) object;
        System.out.println(randomGenerator.randomNumber);

    }


}