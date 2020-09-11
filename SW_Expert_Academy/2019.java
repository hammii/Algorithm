import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int i = 0; i <= T; i++)
		{
            System.out.print((int)Math.pow(2,i)+" ");
		}
	}
}