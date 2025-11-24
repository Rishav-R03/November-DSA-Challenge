package Nov24;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[arr.length];
        int suffix[] = new int[arr.length];
        int answer[] = new int[arr.length];

        // 1. Find prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }
        // 2. Find the suffix array
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }
        // 3. Find the product
        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] * suffix[i];
        }
        return answer;
    }

    // Better approach
    public int[] betterApproach(int[] arr) {
        int ans[] = new int[arr.length];
        int l = 1, r = 1;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = l;
            l *= arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= arr[i];
        }
        return ans;
    }

}
