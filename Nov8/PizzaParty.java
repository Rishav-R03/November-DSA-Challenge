import java.util.HashMap;
import java.util.Map;

public class PizzaParty {
    public static int maxSize(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int max_len = Integer.MIN_VALUE;
        if (k <= 1) {
            return 0;
        }
        final int max_freq = k - 1;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while (map.size() > max_freq) {
                int left_element = arr[l];

                map.put(left_element, map.getOrDefault(left_element, 0) - 1);
                if (map.get(left_element) == 0) {
                    map.remove(left_element);
                }
            }
            l++;
            max_len = Math.max(max_len, i - l + 1);
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 1 };
        int ans = maxSize(5, 3, arr);
        System.out.println(ans);
    }
}
