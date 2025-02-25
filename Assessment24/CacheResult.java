import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveService {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int computeSquare(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for: " + num);
            return cache.get(num);
        }
        System.out.println("Computing result for: " + num);
        int result = num * num;
        cache.put(num, result);
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();
        System.out.println(service.computeSquare(5));
        System.out.println(service.computeSquare(5)); // Cached result
        System.out.println(service.computeSquare(10));
        System.out.println(service.computeSquare(10)); // Cached result
    }
}
