package Nov13;

public class Moving1ToEnd {
    public static int moveOne(String s) {
        int ans = 0;
        int i = 0;
        int countOne = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                ans += countOne;
            } else {
                countOne++;
            }
            i++;
        }
        return ans;
    }
}
