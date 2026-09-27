public class MaxArea {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        long maxArea = 0;

        while (left < right) {
            long h = Math.min(height[left], height[right]);
            long w = right - left;
            maxArea = Math.max(maxArea, h * w);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return (int) maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
    }
}