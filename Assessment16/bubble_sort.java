import java.util.*;
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int turn= 0; turn < n-1;turn++) {
            boolean swapped = false;
            for (int j = 0; j < n - turn-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; //to break unnecessary iteration if already sorted array aage ya //pehle se.
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) marks[i] = sc.nextInt();
        bubbleSort(marks);
        for (int mark : marks) System.out.print(mark + " ");
    }
}
