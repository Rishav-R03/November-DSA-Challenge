package Nov24;

public class BestTimeToBuySell2 {
    public int method(int[] arr) {

        int n = arr.length;
        if (n == 0 || n <= 1) {
            return 0;
        }
        int totalProfit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                totalProfit += arr[i] + arr[i - 1];
            }
        }
        return totalProfit;
    }
}
