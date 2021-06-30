package lsp;

public class Auto {

    private String mark;
    private int number;

    public Auto(String mark, int number) {
        this.mark = mark;
        this.number = number;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Auto{"
                + "mark='" + mark + '\''
                + ", number=" + number
                + '}';
    }
}
