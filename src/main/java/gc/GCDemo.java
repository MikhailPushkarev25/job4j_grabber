package gc;

/**
 * @author Mikhail Pushkarev
 * @since 11.06.2021
 * @version 2.1.1
 *
 * В этой программе демонстрирую пример работы сборщика мусора
 * я создал переменные и записываю в них пямять в килобайтах
 * и в мегабатах
 * далее создаю обьект рантайм для вызова метода gc()
 * создаю метод info() в нем создаю общую память,
 * память которая осталась, и максимальную память
 * в методе main вызыыаю метод info
 * создаю цикл из 1000 обьектов
 * добавляю ебьект Person c параметрами
 * и вызываю сборщик мусора когда наша программа отработает и
 * поймет что обьекты больше не нужны, то сборщик мусора
 * удалит обьекты и освободит нам память
 */
public class GCDemo {

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

        public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environmet state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
        info();
        for (int i = 0; i < 1000; i++) {
            new Person(i, "N" + i);
        }
        info();
    }
}
