import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    User(String username) {
        if (username.length() > 10) throw new IllegalArgumentException("Username too long!");
        this.username = username;
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("ShortName");
        System.out.println("User created: " + user.username);
    }
}
