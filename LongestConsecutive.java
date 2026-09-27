import java.util.*;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int maxLen = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int cur = n;
                int len = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{}));
    }
}