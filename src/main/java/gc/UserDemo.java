package gc;
import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;
public class UserDemo {

    private final static long KB = 1000;
    private final static long MB = KB * KB;
    private static final Runtime RUNTIME = Runtime.getRuntime();

    public static void info() {
        final long totalMemory = RUNTIME.totalMemory();
        final long freeMemory = RUNTIME.freeMemory();
        final long maxMemory = RUNTIME.maxMemory();
        System.out.println("=== Starts RUNTIME ===");
        System.out.printf("Total %d%n", totalMemory / MB);
        System.out.printf("Free %d%n", freeMemory / MB);
        System.out.printf("Max %d%n", maxMemory / MB);

    }

    public static void disableWarning() {
        System.err.close();
        System.setErr(System.out);
    }

    @SuppressWarnings("checkstyle:WhitespaceAfter")
    public static void main(String[] args) {
        disableWarning();
        System.out.println(sizeOf(new User()));
        System.out.println(sizeOf(new User("Mikhail",12)));
        info();
        for (int i = 0; i < 1000; i++) {
            new User("Mikhail" + i, i);

        }
        System.gc();
        info();
    }
    /**
     Пользователь объекта
     Поля: int age, String name
     Размер в памяти пользователя: 16 байт (заголовок) + 8 байт
     (размер int с учетом выравнивания) + 48 байт (размер строки с минимум 1 символом)
     Итого: 72 байта.

     Определяем размер кучи с помощью Xmx, Xms

     все новые обьекты при создании попадают в ячейку eden
     они будут заполнять до тех пор пока не будет заполнен eden
     если  у обекта нет действующих ссылок то они автомотически удаляются
     сборщиком мусора
     Объекты, у которых есть ссылки попадают в survivor space из eden
     survivor space делиться на две части. Между этими частями происходит перемещения объектов
     при этом растет их «возраст» (age). Сам процесс, перемещения объектов из различных
     частей survivor space и увеличения их возраста называется «взрослением» (aging).
     Объекты, которые достигли определенного возраста попадают
     в old generation. Этот процесс называется «продвижением» promotion.
     Когда old generation заполняется производиться major GC
     */
}
