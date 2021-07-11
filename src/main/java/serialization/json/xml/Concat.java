package serialization.json.xml;

public class Concat {

    private String address;

    public Concat() {

    }

    public Concat(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Concat{"
                + "address='" + address + '\''
                + '}';
    }
}
