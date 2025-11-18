import java.util.PriorityQueue;

public class RelativeRanks {
    public static String[] getRanks(int[] scores) {
        int n = scores.length;
        String[] result = new String[n];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[] { scores[i], i });
        }
        int rank = 1;
        while (!maxHeap.isEmpty()) {
            int[] currPair = maxHeap.poll();
            int originalIndx = currPair[1];

            if (rank == 1) {
                result[originalIndx] = "Gold Medal";
            } else if (rank == 2) {
                result[originalIndx] = "Silver Medal";
            } else if (rank == 3) {
                result[originalIndx] = "Bronze Medal";
            } else {
                result[originalIndx] = String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        String[] ans = getRanks(arr);
        for (String s : ans) {
            System.out.print(s +" ");
        }
    }
}
