package Nov11;

public class Ones_And_Zeroes {
    public static int findMaxSubset(String[] str, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String st : str) {
            int zeroes = 0, ones = 0;
            for (char c : st.toCharArray()) {
                if (c == '0') {
                    zeroes++;
                } else {
                    ones++;
                }

                for (int i = m; i >= zeroes; i--) {
                    for (int j = n; j >= ones; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = { "10", "0001", "111001", "1", "0" };
        int i = findMaxSubset(strs, 5, 3);
        System.out.println("Ans " + i);
    }
}