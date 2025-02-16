public class PeakElementFinder {
    public static int peakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // For the first element, we consider it a peak if it's greater than or equal to its right neighbor.
            // For the last element, we consider it a peak if it's greater than or equal to its left neighbor.
            if((mid == 0) && (arr[mid] > arr[mid + 1])){
                return mid;
            }
            if((mid == arr.length - 1) && (arr[mid] > arr[mid -1])){
                return mid;
            }
            if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
                return mid;
            }
            
            else if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else { 
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        
        int peakIndex = peakElement(arr);
        if (peakIndex != -1) {
            System.out.println("A peak element is: " + arr[peakIndex] + " at index: " + peakIndex);
        } else {
            System.out.println("No peak element found.");
        }
    }
}
