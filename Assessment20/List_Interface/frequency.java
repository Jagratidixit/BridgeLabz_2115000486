import java.util.*;

public class Frequency {
    public static Map<String, Integer> frequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        System.out.print("Enter the number of elements in list: ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        System.out.println(frequency(list));
    }
}
