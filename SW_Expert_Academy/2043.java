import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
        int K = sc.nextInt();
        
        System.out.println(P-K+1);

	}
}