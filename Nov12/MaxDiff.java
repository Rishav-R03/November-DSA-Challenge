package Nov12;

public class MaxDiff {
    public static void main(String[] args) {
        int n = 4;
        int[] nums = { 7, 1, 5, 4 };
        int maxDif = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    maxDif = Math.max(maxDif, nums[j] - nums[i]);
                }
            }
        }
        System.out.println(maxDif);
    }
}
