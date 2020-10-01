//Solution for jump-game : https://leetcode.com/problems/jump-game/
package DynamicProgramming;

public class CanJump {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int prev = len - 2;
        for (int i = len - 1; i >= 0; i++) {
            if (i - prev >= 0 && prev >= 0) {
                prev--;
            }
        }
        if(prev == 0) return true;
        return false;
    }
}