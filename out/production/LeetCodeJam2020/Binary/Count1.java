class Count1 { 
    static int count(int n) 
    { 
        int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
  
    // driver program 
    public static void main(String args[]) 
    { 
        int i = 9; 
        System.out.println(count(i)); 
    } 
} 
  