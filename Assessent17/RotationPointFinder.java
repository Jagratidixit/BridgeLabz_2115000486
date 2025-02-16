//log(n) complexity
public class RotationPointFinder {
    public static int findRotationPointIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If middle element is greater than the rightmost element,
            // then the smallest element must be to the right of mid.
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the smallest element is at mid or to the left of mid.
                right = mid;
            }
        }
        
        // When left equals right, we've found the smallest element.
        return left;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        
        int index = findRotationPointIndex(arr);
        System.out.println("The rotation point (smallest element) is at index: " + index);
        System.out.println("The smallest element is: " + arr[index]);
    }
}
