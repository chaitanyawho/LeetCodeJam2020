
class RevBits 
{ 
	public static int R_B(int n) 
	{ 
		int reverse= 0; 

		
		while (n > 0) 
		{ 
			reverse<<= 1; 

			if ((int)(n & 1) == 1) 
				reverse^= 1; 
 
			n >>= 1; 
		}  
		return rev; 
	} 
	public static void Main() 
	{ 
		int n = 11; 
        System.out.println(R_B(n)); 
	} 
} 
