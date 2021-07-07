package serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDemo {

    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");

        final Gson json = new GsonBuilder().create();
        System.out.println(json.toJson(person));

        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Person personMod = json.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
