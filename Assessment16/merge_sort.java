import java.util.*;

public class MergeSortRecursive {
    public static int[] merge(int[] arr, int si, int ei) {
        if (si == ei) {
            return new int[]{arr[si]};
        }
        int mid = (si + ei) / 2;
        int[] left = merge(arr, si, mid);
        int[] right = merge(arr, mid + 1, ei);
        return mergeSortedArrays(left, right);
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length, i = 0, j = 0, k = 0;
        int[] ans = new int[n + m];
        while (i < n && j < m) {
            ans[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        while (i < n) ans[k++] = arr1[i++];
        while (j < m) ans[k++] = arr2[j++];
        return ans;
    }

    public static void main(String[] args) {
        int[] bookPrices = {450, 200, 300, 150, 500, 250};
        int[] sortedPrices = merge(bookPrices, 0, bookPrices.length - 1);
        System.out.println(Arrays.toString(sortedPrices));
    }
}
