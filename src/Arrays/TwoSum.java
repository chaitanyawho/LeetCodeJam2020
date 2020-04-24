package Arrays;
import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> repeated = new HashMap<Integer, Integer>();
        int k = 0;
        for(Integer i: nums){
            if(hm.containsKey(i)) repeated.put(i, k);
            else hm.put(i, k);//update position to last index where i occurs if i is repeated
            k++;

        }
        for(Integer i : hm.keySet()){
            if( target-i == i && repeated.containsKey(i)) return new int[]{hm.get(i), repeated.get(i)};
            else if(hm.containsKey(target-i) && target-i != i){
               return new int[]{hm.get(i), hm.get(target-i)};

            }
        }
        return new int[]{0,0};
    }
    public static void main(String args[]){
        TwoSum ts = new TwoSum();
        int input[] = {1, 3, 5, 7, 9, 9, -2, -4, -6};
        System.out.println("Result: "+ts.twoSum(input, 18)[0] + " " + ts.twoSum(input, 18)[1]);

    }
}