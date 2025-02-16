import java.util.*;

public class SearchProblems {

    // Linear Search 
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        // Create a boolean array of size n+2 (we need indices 1 to n+1)
        boolean[] visited = new boolean[n + 2];

        // Mark each positive integer in the array that is <= n+1
        for (int num : arr) {
            if (num > 0 && num < visited.length) {
                visited[num] = true;
            }
        }

        // The first index (starting from 1) which is not marked is the missing positive integer.
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        
        // This return is just a fallback.
        return n + 1;
    }

    // Binary Search 
    public static int binarySearch(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Target not found
        return -1;
    }
    
    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1, 5, 6};
        int target = 5;
        
        //linear search
        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingPositive);
        
        //  Binary search
        // Since binary search works on sorted arrays, we sort the array first.
        int[] sortedArr = arr.clone(); // Clone to avoid modifying the original array
        Arrays.sort(sortedArr);
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
        
        int targetIndex = binarySearch(sortedArr, target);
        if (targetIndex != -1) {
            System.out.println("Target " + target + " found at index (in sorted array): " + targetIndex);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
