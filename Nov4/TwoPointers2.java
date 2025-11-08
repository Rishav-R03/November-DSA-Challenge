class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int l = 0;
        int r = size - 1;

        while (l < r) {
            int curSum = numbers[l] + numbers[r];
            if (curSum > target) {
                r--;
            } else if (curSum < target) {
                l++;
            } else {
                return new int[] { l + 1, r + 1 };
            }
        }
        return new int[] {};
    }

    public void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}

public class TwoPointers2 {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] numbers = { 1, 2, 3, 4, 5 };
        int target = 5;
        int arr[] = obj.twoSum(numbers, target);
        obj.printArray(arr);
    }
}