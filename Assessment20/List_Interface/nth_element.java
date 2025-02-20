 import java.util.*;

public class NthFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        ListIterator<String> first = list.listIterator();
        ListIterator<String> second = list.listIterator();

        for (int i = 0; i < n; i++) {
            //first.hasNext() is a method from the Iterator interface in Java. It 
  //checks whether there is another element available in the list to iterate over.                                     
            if (!first.hasNext()) return "N is too large";
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        System.out.println(findNthFromEnd(list, N));
    }
}
