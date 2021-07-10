package serialization.json;

import org.json.JSONObject;
import org.json.JSONPropertyIgnore;

public class A {
    private B b;

    @JSONPropertyIgnore
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getHello() {
        return "Hello";
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);

        System.out.println(new JSONObject(b));
    }
}
