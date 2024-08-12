import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Uaaaaa"));
        t1.start();

        Predicate<Integer> pre = (i) -> i > 3;

        System.out.println(pre.test(10));
    }
}
