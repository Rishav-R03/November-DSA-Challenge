import java.util.*;

class FourSumSolution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int s = arr.length;

        for (int i = 0; i < s; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for (int j = 0; j < s; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int l = j + 1;
                int r = s - 1;

                while (l < r) {
                    long curSum = (long) arr[i] + arr[j] + arr[l] + arr[r];

                    if (curSum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[l], arr[r]));
                        l++;
                        r--;

                        while (l < r && arr[l] == arr[l - 1]) {
                            l++;
                        }
                        while (l < r && arr[r] == arr[r + 1]) {
                            r--;
                        }
                    } else if (curSum > target) {
                        r--;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}

public class FourSum {
    
}
