package serialization.json;

import java.util.Arrays;

public class Person {

    private boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statues;

    public Person(boolean sex, int age, Contact contact, String... statues) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statues = statues;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statues=" + Arrays.toString(statues)
                + '}';
    }
}
