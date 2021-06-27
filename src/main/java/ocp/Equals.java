package ocp;

/**
 * @author Mikhail Pushkarev
 * @since 27.02.2021
 * @version 2.2
 *
 * В классе я привел пример нарушения OCP, так как если нам нужно будет
 * проветить строки на равенство или не равенство, то нам придеться добавить еще
 * методы, это получается изменение, изменение влияет на ошибки
 * для этого нужно применить более гибкий алгоритм для расширения.
 */
public class Equals {

    private static class EqualsLine {

        public String line(String one, String two) {
            return one.length() > two.length() ? one : two;
        }
    }
}
