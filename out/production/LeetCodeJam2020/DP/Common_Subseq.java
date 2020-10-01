import java.util.*;

public class Common_Subseq {
    public static int cal_seq(String x,String y)
    {
        String a,b; //check for the longer substring which will be in a 
        int l1=x.length();
        int l2=y.length();
        if(l1>l2)
        {
            a=x;
            b=y;

        }
        else
        {
            a=y;
            b=x;
        }
         l1=a.length();
         l2=b.length();
         l1=l1+1;
         l2=l2+1;
         
         
         //System.out.println(l1+2+ " "+l2+2);

        int arr[][]=new int[l2][l1];
        for(int i=0;i<l2;i++)
        {    char check;
            if(i>0)
            {
                check=b.charAt(i-1);
            }
            else
            {
                 check=b.charAt(i);
            }
           //
           
         //  System.out.println(l1);
           
            for(int j=0;j<l1;j++)
            {
                //System.out.println(i+ "  "+j);
                if(i==0 || j==0)
                {
                    arr[i][j]=0;

                }
                else
                {
                    if(i==1)
                    {
                       // System.out.println(j-1);
                        if(check==a.charAt(j-1) && i==j)
                        {
                            arr[i][j]=arr[i][j-1] + 1;
    
                        }
                        else if(j>i)
                        {
                            arr[i][j]=arr[i][j-1];
                        }
    
                    }
                    else
                    {
                        
                            if(check==a.charAt(j-1))
                            {
                                arr[i][j]=Math.max(Math.max(arr[i-1][j], arr[i][j-1]),arr[i-1][j-1]+1);
                            }

                            else
                            {
                                arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
                            }
                        
                      

                    }
                   
                }




            }
        }
        


       /* for(int i=0;i<l2;i++)
        {
            for(int j=0;j<l1;j++)
            {
                System.out.print(arr[i][j]+ "   " );
            }
            System.out.println();
        }*/






     return arr[l2-1][l1-1];   
    }





    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String  x=sc.nextLine();
        String y=sc.nextLine();
       
        System.out.println(cal_seq(x,y));
        






    }
    
}