package Nov16;

import java.util.HashSet;
import java.util.Set;

public class SubstrWithOnes {
    // bruteforce
    public static int onesBrute(String s) {
        int n = s.length();
        int ans = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(chars[j]);

                if (set.contains('1') && set.size() == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // better approach sw
    public static int onesOptimized(String s) {
        int n = s.length();
        int total = 0, cnt = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt = 0;
            }
            total = (total + cnt);
        }
        return total;
    }

    public static void main(String[] args) {
        String s = "0110111";
        int ans = onesBrute(s);
        int ans2 = onesOptimized(s);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
