package Nov24;

import java.util.ArrayList;
import java.util.List;

public class PrefixDivBy5 {
    public static List<Boolean> prefixDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int val = 0;

        for (int n : nums) {
            val = ((val << 1) + n) % 5;
            result.add(val == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        int val = 5;
        System.out.println((val >> 1) + 1);
    }
}
