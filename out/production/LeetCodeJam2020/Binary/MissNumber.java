class MissNumber {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
     public static void main(String args[])
    {
     MissNumber = new MissNumber();
     int sums[]={0,1,3,4,6,5};
     int res=c.missingNumber(sums);
     System.out.println(res);
    }
}