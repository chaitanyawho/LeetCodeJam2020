class Stairs {
    public int climbStairs(int n) {
             if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];// sum of gettig to i s-1 and i-2 as you can take twosteps or one
        }
        return dp[n];
        
    }
     Stairs c = new Stairs();
     int a =9;
     int res=c.climbStairs(a);
     System.out.println(res);
}