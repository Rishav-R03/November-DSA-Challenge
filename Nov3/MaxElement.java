package Nov3;

public class MaxElement {
    public static int getMax(int[] arr) {
        int maxEle = arr[0];
        for (int a : arr) {
            if (maxEle < a) {
                maxEle = a;
            }
        }
        return maxEle;
    }

    public static void main(String[] args) {
        int [] arr = {2,4,15,6};
        int ans = getMax(arr);
        System.out.println(ans);
    }
}
