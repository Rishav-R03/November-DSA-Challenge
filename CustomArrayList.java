
public class CustomArrayList implements CustomList {
    private int[] array;
    private int count;

    public CustomArrayList(int size) {
        array = new int[size];
    }

    @Override
    public void add(int s) {
        if (array.length == count) {
            int newArr[] = new int[2 * count];
            for (int i = 0; i < count; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[count++] = s;
    }

    @Override
    public void remove() {
        int ori = array.length;
        if (array.length > 0) {
            int[] newArr = new int[ori - 1];
            System.arraycopy(array, 0, newArr, 0, ori - 1);
            array = newArr;
        }
    }

    @Override
    public int get(int i) {
        return array[i];
    }

    @Override
    public void set(int ind, int val) {
        array[ind] = val;
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
