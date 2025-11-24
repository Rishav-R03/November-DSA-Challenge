package Nov24;

public class ZeroFilledArray {
    public static long zeroFilled(int[] arr) {
        long z = 0, r = 0;

        for (int n : arr) {
            z = (n == 0) ? z + 1 : 0;
            r += z;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilled(new int[] { 1, 3, 0, 0, 2, 0, 0, 4 }));
    }
}
