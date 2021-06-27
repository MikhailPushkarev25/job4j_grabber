package ocp;

/**
 * @author Mikhail Pushkarev
 * @since 27.06.2021
 * @version 2.2
 *
 * В классе привел пример нарушения OCP
 * нам нужно вывести числа в двойном размере,
 * и нужно вывести числа в обратном порядке и только четные
 * в этом примере нужно писать методы нарушать правило,
 * что бы этого не случилось нужно использовать гибкость наследования
 */
public class Expected {

    private int res;

    public Expected(int res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "Expected{" + "res=" + res + '}';
    }

    private static class ResDemo extends Expected {

        public ResDemo(int res) {
            super(res);
        }

        public int sum() {
            int j = 0;
            for (int i = 0; i < 10; i++) {
                j = i * i;
            }
            return j;
        }
    }
}
