package serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Json {
    public static void main(String[] args) {
        JSONObject jsonWork = new JSONObject("{\"programmer\":\"Developer\"}");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("PHP");
        JSONArray jsonNums = new JSONArray(list);

        final User user = new User("Mikhail", "Pushkarev", 25, new Work("Java"), 1, 2, 3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", user.getName());
        jsonObject.put("surname", user.getSurname());
        jsonObject.put("age", user.getAge());
        jsonObject.put("work", jsonWork);
        jsonObject.put("num", jsonNums);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(user).toString());
    }
}
