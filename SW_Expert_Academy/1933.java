import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int i = 1;
        
        while( i<=N ){
            if(N%i == 0){
                System.out.print(i+" ");
            }
            i++;
        }
	}
}