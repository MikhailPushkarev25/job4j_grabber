package lsp;

/**
 * @author Mikhail Pushkarev
 * @since 28.06.2021
 * @version 2.2
 *
 * В классе я показываю пример постусловия,
 * то есть у нас в первом классе обьявлен массив
 * я проверяю массив равен ли нулю иначе исключение
 * прохожу по массиву и умножаю
 * далее в условии проверяю если результат меньше 10
 * то прибавляю число 30
 * в подкласе я обьвляю в методе только цикл.
 * Тем самым показывая нарушение LSP
 */
public class Account {

    public int sum(int[] j) {
        int res = 0;
        if (j.length == 0) {
            throw new IllegalArgumentException("Not argument");
        }
        for (int i = 0; i < j.length; i++) {
            res = i * i;
        }

        if (res <= 10) {
            res += 30;
        }
        return res;
    }

    public static class Acc extends Account {
        public int sum(int[] j) {
            int res = 0;
            for (int i = 0; i < j.length; i++) {
                res = i * i;
            }
            return res;
        }

    }
}
