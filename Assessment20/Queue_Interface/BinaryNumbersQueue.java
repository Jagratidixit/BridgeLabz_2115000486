import java.util.*;

public class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String binary = queue.poll();
            result.add(binary);
            queue.add(binary + "0");
            queue.add(binary + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        System.out.println(generateBinaryNumbers(n));
    }
}
