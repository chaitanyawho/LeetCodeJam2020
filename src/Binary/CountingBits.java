package Binary;

public class CountingBits {
    public int[] countBits(int num) {
        //DP solution: bits[0] = 0, bits[1] = 1, for every even i in bits[i]--> bits[i/2] & odd-->bits[i-1] + 1
        int[] bits = new int[num+1];
        bits[0] = 0;
        if(num>0)    bits[1] = 1;
        for(int i = 2; i <= num ; i++){
            if(i%2==0)
                bits[i] = bits[i/2];
            else
                bits[i] = 1 + bits[i-1];
        }
        return bits;
    }
}
