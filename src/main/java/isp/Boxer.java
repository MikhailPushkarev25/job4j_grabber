package isp;

/**
 * @author Mikhail Pushkarev
 * @since 30.06.2021
 * @version 2.2
 *
 * Нам нужен метод бокс для указания достижений
 * я нарушил isp
 */
public class Boxer implements Sport {

    @Override
    public void football() {

    }

    @Override
    public void basketball() {

    }

    @Override
    public void box() {
        System.out.println("KMS");
    }

    @Override
    public void walking() {

    }
}
