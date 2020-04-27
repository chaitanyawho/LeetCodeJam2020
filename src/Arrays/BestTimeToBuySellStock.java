package Arrays;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices){
        //get max pairwise difference such that first number is less than second
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i : prices){
            if(i<minPrice) minPrice = i;
            if(i-minPrice > maxProfit) maxProfit = i-minPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock o = new BestTimeToBuySellStock();
        System.out.println(o.maxProfit(new int[]{7, 1, 5, 3, 8, 6}));
    }
}
