package serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserDemo {

    public static void main(String[] args) {
        final User user = new User("Mikhail", "Pushkarev", 25, new Work("Java"), 1, 2, 3);

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(user));

        final String userJson =
                "{"
                        + "\"name\":\"Mikhail\","
                        + "\"surname\":\"Pushkarev\","
                        + "\"age\":25,"
                        + "\"work\":"
                        + "{"
                        + "\"programmer\":\"Java\""
                        + "},"
                        + "\"num\":"
                        + "[1, 2, 3]"
                        + "}";
        final User userGson = gson.fromJson(userJson, User.class);
        System.out.println(userGson);

    }
}
