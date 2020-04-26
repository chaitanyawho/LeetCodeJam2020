package Binary;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        //SUM: a^b, CARRY: a&b, add sum with carry << 1 at each step
        int sum = 0, carry = 0;

        while(b!=0){
            carry = a&b;
            sum = a^b;
            a = sum;
            b = carry << 1;
        }
        return sum;
    }
}
