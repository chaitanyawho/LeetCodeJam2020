import java.util.*;
import java.math.*;
class CoinChange{
    public static int subset(int x,int coins[],int y)
    {
        int check[][]=new int[x][y+1];
        for(int i=0;i<x;i++)
        {
            int coin=coins[i];
            for(int j=0;j<y+1;j++)
            {
                if(j==0)
                {
                    check[i][j]=0;

                }
                else
                {
                    if(i==0)
                    {    System.out.println(i+" "+j);
                        if(coin<j)
                        {
                            check[i][j]=check[i][j-coin]+1; //note -coin
                            //System.out.println(check[i][j] +"First enter in coin>j");
                        }
                        else 
                        {
                            if (coin==j) 
                            {
                                check[i][j]=1;
                               // System.out.println("set"+i+" "+j);
    
                            }
                            else
                            {


                            check[i][j]=0;
                            //System.out.println(coin +" <--- coin is less than j --->"+j);
                        

                            }   
                    }
                }
                    else
                    {
                        if(j<coin)
                        {
                            check[i][j]=check[i-1][j];

                        }
                        else
                        {
                            check[i][j]= Math.min(check[i-1][j],(check[i][j-coin]+1));
                        }

                    }

                }
                
            }
            
            
        }
      /*  for(int i=0;i<x;i++)
        {
            int coin=coins[i];
            System.out.print(coin+" ");
            for(int j=0;j<y+1;j++)
            {
                System.out.print(check[i][j]+" ");
            }
            System.out.println(" ");
        }*/








        return check[x-1][y]; 
    }










    public static void main(String args[])
    {
        Scanner s= new Scanner(System.in);
        int x,y;
        x=s.nextInt();
        int coins[]=new int[x];
        for(int i=0;i<x;i++)
        {
            coins[i]=s.nextInt();

        }
        System.out.println("Enter sum to be chexked?");
        y=s.nextInt();
        int check=subset(x,coins,y);
        System.out.println(check);

    }
    
}