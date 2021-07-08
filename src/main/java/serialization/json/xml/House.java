package serialization.json.xml;

import java.util.Arrays;

public class House {

    private boolean rsl;
    private int num;
    private String street;
    private Concat concat;
    private int[] cell;

    public House(boolean rsl, int num, String street, Concat concat, int... cell) {
        this.rsl = rsl;
        this.num = num;
        this.street = street;
        this.concat = concat;
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "House{"
                + "rsl=" + rsl
                + ", num=" + num
                + ", street='" + street + '\''
                + ", concat=" + concat
                + ", cell=" + Arrays.toString(cell)
                + '}';
    }
}
