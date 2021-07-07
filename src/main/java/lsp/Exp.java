package lsp;

/**
 * @author Mikhail Pushkarev
 * @since 28.06.2021
 * @version 2.2
 *
 * в классе привожу пример нарушения LSP
 * принцип предусловия, когда происходит усиление в подкласе
 * это не допустимо, принцип Лескова будет нарушен
 */
public class Exp {

    private String name;

    public Exp(String name) {
        this.name = name;
    }

    public void eq(String n) {

        if (name.equals(n)) {
            System.out.println("true");
        }
    }

    class Res extends Exp {

        public Res(String name) {
            super(name);
        }

        public void eq(String n) {
            if (n == null) {
                throw new IllegalArgumentException("Not argument");
            }

            if (name.equals("Mikhail")) {
                System.out.println("true");

            }

            if (name.equals(n)) {
                System.out.println("Enter");
            }
        }
    }
}
