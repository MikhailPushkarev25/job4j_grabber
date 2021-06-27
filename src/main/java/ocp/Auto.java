package ocp;

/**
 * @author Mikhail Pushkarev
 * @since 27.06.2021
 * @version 2.2
 *
 * В классе привожу пример нарушения OCP
 * нам нужно узнать скорость автобуса,
 * нам пришла задачать узнать скорость самолета к примеру
 * я уже не смогу наследовать самолет так как в классе находится информация о авто
 */
public class Auto {

    private interface Car {

      void speed();
    }

    private static class Bus implements Car {

        @Override
        public void speed() {
            System.out.println("50 km");
        }
    }
}
