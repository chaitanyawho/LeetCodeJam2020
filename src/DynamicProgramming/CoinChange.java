package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] sub = new int[amount+1];
        Arrays.fill(sub, Integer.MAX_VALUE);
        int W = amount;
        sub[0] = 0;
        for(int i = 1;i<amount+1;i++){
            for(int j = 0;j<coins.length;j++){
                if(i>=coins[j])
                    sub[i] = Math.min(sub[i], 1 + sub[i-coins[j]]);
            }
        }
        return sub[amount] > amount ? -1 : sub[amount];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[]{1, 2, 5, 10}, 12));
    }

}
