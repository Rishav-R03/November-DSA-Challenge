import java.util.PriorityQueue;

public class KthLargest {
    private final int K;
    private final PriorityQueue<Integer> minHeap;

    public KthLargest(int K, int[] nums) {
        this.K = K;
        this.minHeap = new PriorityQueue<>();

        for (int n : nums) {
            add(n);
        }
    }

    private int add(int n) {
        minHeap.add(n);

        if (minHeap.size() > K) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
