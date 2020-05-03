package Binary;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int one = 0;
        int bitmask = 1;
        for(int i = 0 ; i < 32 ; i++){
            if((n & bitmask) != 0)
                one++;
            bitmask<<=1;
        }
        return one;

    }
    public int hammingWeightBITM(int n) {
        int one = 0;
        //the idea is to AND n and n-1, every iteration of the loop occurs when a '1' bit is encountered
        while (n > 0) {
            one++;
            n = n & (n - 1);
        }
        return one;
    }
}
