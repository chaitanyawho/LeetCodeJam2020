//Solution for Combination sum 4 : https://leetcode.com/problems/combination-sum-iv/
package DynamicProgramming;

public class CombinationSum4{
    public int combinationSum(int[] nums, int target) {
        int[] arr = new int[target + 1];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    arr[i] += arr[i - nums[j]];
                }
            }
        }
        return arr[target];
    }
}
    
