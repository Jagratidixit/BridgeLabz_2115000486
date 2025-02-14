import java.util.*;

public class QuickSort {
    public static void sort(int[] arr, int si, int ei) {
        if (si >= ei) return;
        int pi = partition(arr, si, ei);
        sort(arr, si, pi - 1);
        sort(arr, pi + 1, ei);
    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei], pi = si;
        for (int i = si; i < ei; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pi];
                arr[pi] = temp;
                pi++;
            }
        }
        int temp = arr[pi];
        arr[pi] = arr[ei];
        arr[ei] = temp;
        return pi;
    }

    public static void main(String[] args) {
        int[] productPrices = {450, 200, 300, 150, 500, 250};
        sort(productPrices, 0, productPrices.length - 1);
        System.out.println(Arrays.toString(productPrices));
    }
}
