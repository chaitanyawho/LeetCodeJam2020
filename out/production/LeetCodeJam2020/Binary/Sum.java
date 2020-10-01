class Sum{
    public int getSum(int a, int b) {
         while(b!=0){
       int carr = a&b;
       System.out.print(carr+" ");
       a=a^b;
       System.out.print(a+' ');
       b=carr<<1;
       System.out.print(b+' ');
       System.out.println();
       
   }
 
   return a;
        
    }
     public static void main(String args[])
    {
     Sum c = new Sum();
     int a =9;
     int b=3;
     int res=c.getSum(a,b);
     System.out.println(res);
    }
}