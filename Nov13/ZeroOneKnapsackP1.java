package Nov13;

public class ZeroOneKnapsackP1 {
    // recursive method
    public int recursiveMethod(int[] profit, int[] wei, int w, int n) {
        // base case
        if (profit.length != wei.length || profit.length == 0 || wei.length == 0 || w == 0) {
            return 0;
        }
        // choice diagram
        int pick = 0;
        if (wei[n - 1] <= w) {
            pick = profit[n - 1] + recursiveMethod(profit, wei, w - wei[n - 1], n - 1);
        }
        int notPick = recursiveMethod(profit, wei, w, n - 1);

        return Math.max(pick, notPick);
    }

    static void main(String[] args) {
        
    }
}
