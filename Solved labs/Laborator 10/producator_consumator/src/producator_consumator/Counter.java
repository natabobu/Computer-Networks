package producator_consumator;

public class Counter {

    private static long value = 0;

    public Counter() {
    }

    public static long next() {
        return value++;
    }
}
