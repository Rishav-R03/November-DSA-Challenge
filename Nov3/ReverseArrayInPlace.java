package Nov3;

public class ReverseArrayInPlace {
    public static void reverseInPlace(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 5, 4, 3, 2, 1 };
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
        reverseInPlace(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
