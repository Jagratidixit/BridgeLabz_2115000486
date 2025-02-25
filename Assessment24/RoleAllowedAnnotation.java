import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    void adminTask() {
        System.out.println("Admin task executed");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        String userRole = "USER"; // Change to "ADMIN" to allow access
        Method method = SecureService.class.getMethod("adminTask");
        RoleAllowed role = method.getAnnotation(RoleAllowed.class);
        if (role.value().equals(userRole)) {
            new SecureService().adminTask();
        } else {
            System.out.println("Access Denied!");
        }
    }
}
