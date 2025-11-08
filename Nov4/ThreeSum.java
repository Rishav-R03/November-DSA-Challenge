import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int s = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < s; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = s - 1;

            while (l < r) {
                int curSum = arr[i] + arr[l] + arr[r];
                if (curSum == 0) {
                    List<Integer> row = new ArrayList<>();
                    row.add(arr[i]);
                    row.add(arr[l]);
                    row.add(arr[r]);
                    ans.add(row);
                    l++;
                    r--;

                    // Skip duplicates for left pointer
                    while (l < r && arr[l] == arr[l - 1]) {
                        l++;
                    }
                    // Skip duplicates for right pointer
                    while (l < r && arr[r] == arr[r + 1]) {
                        r--;
                    }

                } else if (curSum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSumSolution sol = new ThreeSumSolution();

        int[] arr = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> ans = sol.threeSum(arr);
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> row = ans.get(i);
            System.out.print("[");
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));
                if (j < row.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}