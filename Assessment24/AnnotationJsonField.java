import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    String username;

    User(String username) {
        this.username = username;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("JohnDoe");
        Map<String, String> jsonMap = new HashMap<>();
        for (Field field : User.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                jsonMap.put(field.getAnnotation(JsonField.class).name(), (String) field.get(user));
            }
        }
        System.out.println(jsonMap);
    }
}
