import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int temp = 0;

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            // Selection Sort
            for (int j = 0; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[j] > arr[k]) {
                        temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }
            }

            System.out.print("#" + (i + 1));
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + arr[j]);
            }
            System.out.println();
        }
	}
}