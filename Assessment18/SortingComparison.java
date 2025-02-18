import java.util.*;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int[] mergeSort(int[] arr, int si, int ei) {
        if (si == ei) {
            int[] bs = new int[1];
            bs[0] = arr[si];
            return bs;
        }
        int mid = (si + ei) / 2;
        int[] fa = mergeSort(arr, si, mid);
        int[] sa = mergeSort(arr, mid + 1, ei);
        return mergeTwoSortedArrays(fa, sa);
    }

    public static int[] mergeTwoSortedArrays(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        int ans[] = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) ans[k++] = arr1[i++];
            else ans[k++] = arr2[j++];
        }
        while (i < m) ans[k++] = arr1[i++];
        while (j < n) ans[k++] = arr2[j++];
        return ans;
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) return;
        int pi = partition(arr, si, ei);
        quickSort(arr, si, pi - 1);
        quickSort(arr, pi + 1, ei);
    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int pi = si;
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

    public static void measureSortTimes(int N) {
        Random rand = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) 
        arr[i] = rand.nextInt(N);
        
        //creating copy coz here sorting done to bubble sort kar dega
        //fir baaki kaise sort karenge.
        int[] arrCopy1 = Arrays.copyOf(arr, N);
        int[] arrCopy2 = Arrays.copyOf(arr, N);

        long start = System.nanoTime();
        bubbleSort(arr);
        long bubbleTime = System.nanoTime() - start;

        start = System.nanoTime();
        mergeSort(arrCopy1, 0, N - 1);
        long mergeTime = System.nanoTime() - start;

        start = System.nanoTime();
        quickSort(arrCopy2, 0, N - 1);
        long quickTime = System.nanoTime() - start;

        System.out.println("Dataset Size: " + N);
        System.out.println("Bubble Sort Time: " + bubbleTime + " ns");
        System.out.println("Merge Sort Time: " + mergeTime + " ns");
        System.out.println("Quick Sort Time: " + quickTime + " ns");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 100000};
        for (int size : datasetSizes) measureSortTimes(size);
    }
}
