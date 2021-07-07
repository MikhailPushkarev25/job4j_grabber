package srp;

/**
 * @author Mikhail Pushkarev
 * @since 26.06.2021
 * @version 2.2
 */
public class Find implements Calc {

    @Override
    public double circle(double p) {
        return p * p * Math.PI;
    }

    @Override
    public double triangle(double p, double a) {
        return (p * a) / 2;
    }

    public void print() {
        System.out.println("Площадь круга равна: " + circle(3));
        System.out.println("Площадь треугольника равна: " + triangle(4, 2));
    }

    public static void main(String[] args) {
        new Find().print();
    }
}
