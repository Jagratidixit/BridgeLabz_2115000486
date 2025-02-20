 import java.util.*;

public class RotateList {
    public static List<Integer> rotate(List<Integer> list, int k) {
        int n = list.size();
        k %= n;//elements same after few rotation,also k not exceed size
        Collections.rotate(list, -k);// -k to rotate left,positive for right
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter rotation value: ");
        int k = sc.nextInt();

        System.out.println(rotate(list, k));
    }
}
