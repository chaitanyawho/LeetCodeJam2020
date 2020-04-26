package DynamicProgramming;

public class ClimbingStairs {
    public int climbStairs(int n){
        //memo[]: soln for memo[i], memo[i] = memo[i-1]+memo[i-2]
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3;i<n+1;i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];

    }

}
