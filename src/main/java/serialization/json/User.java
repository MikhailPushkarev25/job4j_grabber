package serialization.json;

import java.util.Arrays;

public class User {

    private String name;
    private String surname;
    private int age;
    private Work work;
    private int[] num;

    public User(String name, String surname, int age, Work work, int... num) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.work = work;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Work getWork() {
        return work;
    }

    public int[] getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", work=" + work
                + ", num=" + Arrays.toString(num)
                + '}';
    }
}
