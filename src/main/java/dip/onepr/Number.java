package dip.onepr;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mikhail Pushkarev
 * @since 02.07.2021
 * @version 2.2
 *
 * В этом классе я показываю два нарушения DIP
 * первое это зависимость от поле в функциях
 * второе это уловить исключение при значении 0
 * для этого нужно использовать Logger
 * а в первом случае нужно что бы детали зависели от абстркации
 */
public class Number {
    public Set<Integer> set = new HashSet<>();

    public boolean num(int i) {
        if (set.isEmpty()) {
            System.out.println("Error " + i);
        }
        return set.add(i);
    }

    public void get() {
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        Number number = new Number();
        number.num(1);
        number.num(1);
        number.num(2);
        number.num(3);
        number.num(3);
        number.num(4);
        number.get();
    }
}
