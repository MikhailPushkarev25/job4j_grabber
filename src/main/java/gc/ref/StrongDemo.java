package gc.ref;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 1. Strong Reference
 */

public class StrongDemo {
    public static void main(String[] args) throws InterruptedException {
        //example1();
        //example2();
        example3();
    }

    /**
     * В первом методе, мы создаем объект и далее их за'null'яем.
     * Вызываем сборщик мусора и ждем некоторое время.
     * Объекты удаляются, т.к. ссылки на них null
     * <p>
     * Во втором методе, мы создаем объекты вместе с вложенными.
     * Удаляя внешние объекты как в примере выше
     * удаляются и вложенные, не смотря на то что они не null.
     * <p>
     * Проблема данного типа ссылок является то,
     * что если в программе есть неиспользуемые ссылки на созданные
     * объекты, то они не будут удалены
     */

    private static void example1() throws InterruptedException {
        Object[] object = new Object[100];
        for (int i = 0; i < 100; i++) {
            object[i] = new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            };

        }

        for (int i = 0; i < 100; i++) {
            object[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

    private static void example2() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            Object object = new Object() {
                private Object innerObject = new Object() {
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println("Remove inner object!");
                    }
                };
            };
            objects[i] = object;
        }
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * что приведет к утечке памяти,
     * что в свою очередь может привести к ошибке OutOfMemoryException -
     * ситуации когда программе не хватает выделенной памяти.
     *
     * К примеру такой код явно приведет к этой ошибке.
     * Чтобы быстрее ее увидеть можно выставить аргументы -Xmx4m -Xms4m
     */

    private static void example3() {
        List<String> strings = new ArrayList<>();
        while (true) {
            strings.add(String.valueOf(System.currentTimeMillis()));
        }
    }
}
