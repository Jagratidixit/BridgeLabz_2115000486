import java.util.*;
class ZeroSumSubarrays {
    public static int findZeroSumSubarrays(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;

        for (int num : arr) {
            sum += num;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println(findZeroSumSubarrays(arr));
    }
}
