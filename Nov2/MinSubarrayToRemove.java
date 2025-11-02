package Nov2;

import java.util.HashMap;
import java.util.Map;

public class MinSubarrayToRemove {
    public int minSubarray(int[] nums, int p) {
        long n = nums.length;
        long arrSum = 0;

        for (int num : nums) {
            arrSum += num;
        }
        if (arrSum % p == 0)
            return 0;

        int requiredRem = (int) (arrSum % p);

        Map<Integer, Integer> rem = new HashMap<>();

        rem.put(0, -1);

        arrSum = 0;

        int res = nums.length;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
            int curRem = (int) (arrSum % p);

            int searchFor = curRem - requiredRem;
            if (searchFor < 0)
                searchFor += p;
            if (rem.containsKey(searchFor))
                res = Math.min(i - rem.get(searchFor), res);
            rem.put(curRem, i);
        }
        return (res == n) ? -1 : res;
    }

}
