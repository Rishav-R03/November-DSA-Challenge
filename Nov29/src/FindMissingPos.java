import java.util.HashSet;
import java.util.Set;

public class FindMissingPos {
    public static int firstMissing(int [] nums){
        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        for(int i = 1;i< nums.length + 1;i++){
            if(!hashSet.contains(i)){
                return i;
            }
        }
        return -1;
    }

    static void main(String [] args){
        int ans = firstMissing(new int[] {7,8,9,11,12});
        System.out.println("First missing number is: "+ans);
    }
}
