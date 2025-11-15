package Nov15;

public class CountNumOfSubstrings {
    public int getCount(String s) {
        int ans = 0, n = s.length();
        char chars[] = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int ones = 0, zeros = 0;
            for (int j = i; j < n; j++) {
                if (chars[j] == '0') {
                    zeros++;
                } else {
                    ones++;
                }
                if (ones >= (zeros * zeros)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
