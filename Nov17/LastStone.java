import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {
    public int lastStoneWeight(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // offer the stones in heap;
        for (int n : nums) {
            maxHeap.offer(n);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (y > x) {
                maxHeap.offer(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
