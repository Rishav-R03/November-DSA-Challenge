package Nov12;

public class MinOps2Make1 {
    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int minOperations(int[] nums) {
        // find size of nums
        int n = nums.length;
        // initialize the required variables
        int finalGCD = 1;
        int min_length = n;
        int numOnes = 0;
        // check ones
        for (int x : nums) {
            if (x == 1) {
                numOnes++;
            }

            finalGCD = findGCD(finalGCD, x);
        }
        // handle case when we have a solution with 1
        if (numOnes > 0) {
            return n - numOnes;
        }
        // handle edge case
        if (finalGCD > 1) {
            return -1;
        }

        // find min length

        for (int i = 0; i < n; i++) {
            int curGcd = 0;
            for (int j = i; j < n; j++) {
                curGcd = findGCD(curGcd, nums[j]);
                if (curGcd == 1) {
                    min_length = Math.min(min_length, j - i + 1);
                }
            }
        }
        return min_length + n - 2;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 3, 4 };
        int ans = minOperations(arr);
        System.out.println(ans);
    }
}
