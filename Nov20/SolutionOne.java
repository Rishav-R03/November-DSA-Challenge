package Nov20;

public class SolutionOne {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int[] ans = plusOne(arr);
        for (int n : ans) {
            System.out.print(n + " ");
        }
    }
}