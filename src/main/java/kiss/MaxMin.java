package kiss;

import java.util.Comparator;
import java.util.List;;

/**
 * @author Mikhail Pushkarev
 * @since 25.06.2021
 * @version 2.2
 * В классе я два метода для поиска максимально и минимального числа по критерию
 * и использовал третий метод для исключения копипаста, в методе прохожу по
 * листу с числами и спомощью компаратора нахожу максимально и минимальное число
 */
public class MaxMin {

    public <T> T finBy(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (int i = 0; i < value.size(); i++) {
            rsl = comparator.compare(rsl, value.get(i)) > 0 ? rsl : value.get(i);
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return finBy(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return finBy(value, comparator.reversed());
    }
}
