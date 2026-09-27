import java.util.*;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);
        long sum = 0;
        int count = 0;

        for (int n : nums) {
            sum += n;
            count += prefixCount.getOrDefault(sum - k, 0);
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}