import java.util.*;

public class SearchComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void measureSearchTimes(int N) {
        //random used coz datasize is more
        Random rand = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = rand.nextInt(N);

        int target = arr[rand.nextInt(N)];

        long start = System.nanoTime();
        linearSearch(arr, target);
        long linearTime = System.nanoTime() - start;

        Arrays.sort(arr);

        start = System.nanoTime();
        binarySearch(arr, target);
        long binaryTime = System.nanoTime() - start;

        System.out.println("Dataset Size: " + N);
        System.out.println("Linear Search Time: " + linearTime + " ns");
        System.out.println("Binary Search Time: " + binaryTime + " ns");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        for (int size : datasetSizes) measureSearchTimes(size);
    }
}
