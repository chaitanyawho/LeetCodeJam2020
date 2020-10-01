//in longest subequese each element stores its longest subsequence 
import java.util.*;
public class Longest_Inc_Subseq {

public static int sub_seq(int arr[],int seq[],int n)
{
    for(int i=1;i<n;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(arr[i]>arr[j])
            {
                seq[i]=Math.max(seq[i],seq[j]+1);
            }
        }

    }
    Arrays.sort(seq);






    return seq[n-1];

}



    public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int arr[]=new int[x];
        int seq[]=new int[x];
        for(int i=0;i<x;i++)
        {
            arr[i]=sc.nextInt();
            seq[i]=1;//1 is the longest sub seq
        }

        System.out.println(sub_seq(arr,seq,x));

    }
    
}