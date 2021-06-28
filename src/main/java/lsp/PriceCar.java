package lsp;

/**
 * @author Mikhail Pushkarev
 * @since 28.06.2021
 * @version 2.2
 *
 * В классе я показываю нарушение инварианта,
 * то есть я создал локальную переменную и в конструкторе проверяю если
 * цена меньше 1000 то исключение
 * такого быть не должно и в методе так же проверяю
 * во внутреннем классе  я указал только цикл
 * этим я произвер нарушение LSP
 */
public class PriceCar {

    private int price;

    public PriceCar(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("Error the Argument");
        }
        this.price = price;
    }

    public void pr(int auto) {
        if (auto < 1000) {
            throw new IllegalArgumentException("Error the Argument");
        } else {
            price = auto;
        }
    }

    public static class Auto {

        public void au(int res) {
            for (int i = 0; i < res; i++) {
                res = i + i;
            }
        }
    }
}
