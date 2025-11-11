package Nov11;

import java.util.HashMap;

public class HouseRobber {
    public static int recursiveMethod(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        return Math.max(helper(0, houses), helper(1, houses));
    }

    private static int helper(int i, int[] houses) {
        int maxLoot = 0;
        if (i >= houses.length) {
            return 0;
        }
        maxLoot = houses[i] + helper(i + 2, houses);
        return maxLoot;
    }

    public static int memoizationMethod(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> memo = new HashMap<>();
        return memoHelper(0, houses, memo);
    }

    private static int memoHelper(int i, int[] houses, HashMap<Integer, Integer> map) {
        int maxLoot = 0;
        if (i >= houses.length) {
            return 0;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int ifLooted = houses[i] + memoHelper(i + 2, houses, map);
        int ifSkipped = memoHelper(i + 1, houses, map);

        maxLoot = Math.max(ifLooted, ifSkipped);
        map.put(i, maxLoot);
        return maxLoot;
    }

    public static int topDown(int[] houses) {
        int n = houses.length;
        if (houses.length == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = houses[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(houses[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[houses.length];
    }

    public static void main(String[] args) {
        int[] houses = { 6, 7, 1, 3, 8, 2, 4 };
        int ans = recursiveMethod(houses);
        System.out.println(ans);
        int ansMemo = memoizationMethod(houses);
        System.out.println(ansMemo);
        int ansTab = topDown(houses);
        System.out.println(ansTab);
    }
}
