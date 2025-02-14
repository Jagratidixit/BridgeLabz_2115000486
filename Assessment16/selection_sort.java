public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1, 4, 3};
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
