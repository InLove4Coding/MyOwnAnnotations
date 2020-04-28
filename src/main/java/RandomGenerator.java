import annotation.RandomIntInject;

public class RandomGenerator {

    // Эта аннотация каждый раз инжектит рандомной число
    // Пределы этого числа можно регулировать параметрами аннтоации
    @RandomIntInject(min = 1, max=10 )
    static int randomNumber;

    @RandomIntInject(min = 100, max=1000 )
    static int randomNumber2;
}
