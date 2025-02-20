import java.util.*;

public class SetEquality {
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
	//The equals() method in Java checks whether two sets contain the same elements, regardless of order.

        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.print("Enter number of elements in Set1: ");
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }
    }
}
