import java.util.*;

public class MinWindow {
    public static String minWindow(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) return "";

        int[] need = new int[128];
        for (char c : target.toCharArray()) need[c]++;

        int required = 0;
        for (int v : need) if (v > 0) required++;

        int[] have = new int[128];
        int formed = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < source.length(); right++) {
            char c = source.charAt(right);
            have[c]++;
            if (need[c] > 0 && have[c] == need[c]) formed++;

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char lc = source.charAt(left);
                have[lc]--;
                if (need[lc] > 0 && have[lc] < need[lc]) formed--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : source.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("AAABBC", "AABC"));
    }
}