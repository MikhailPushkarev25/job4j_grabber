package concurrent;

public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );

        another.run();
        System.out.println(Thread.currentThread().getName());
    }
}
