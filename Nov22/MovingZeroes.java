class MovingZeroes {
    public static void moveZeroes(int[] nums) {
        int k = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 4, 0, 5 };
        moveZeroes(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}