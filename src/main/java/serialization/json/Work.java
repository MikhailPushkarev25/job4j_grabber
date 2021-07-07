package serialization.json;

public class Work {

    private String programmer;

    public Work(String programmer) {
        this.programmer = programmer;
    }

    @Override
    public String toString() {
        return "Work{"
                + "programmer='" + programmer + '\''
                + '}';
    }
}
