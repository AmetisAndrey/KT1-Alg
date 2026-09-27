import java.util.*;

public class LongestTwoTypes {
    public static int totalFruit(int[] items) {
        if (items == null || items.length == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < items.length; right++) {
            count.put(items[right], count.getOrDefault(items[right], 0) + 1);

            while (count.size() > 2) {
                int lv = items[left];
                count.put(lv, count.get(lv) - 1);
                if (count.get(lv) == 0) count.remove(lv);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
    }
}