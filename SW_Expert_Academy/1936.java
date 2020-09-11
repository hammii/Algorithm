import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int A =sc.nextInt();
		int B =sc.nextInt();
        
        if(A==1){	//가위
            if(B==2){	//바위
                System.out.print("B");
            }else if(B==3){	//보
                System.out.print("A");
            }
        } else if(A==2){	//바위
             if(B==1){	//가위
                System.out.print("A");
            }else if(B==3){	//보
                System.out.print("B");
            }
        }else if(A==3){	//보
              if(B==1){	//가위
                System.out.print("B");
            }else if(B==2){	//바위
                System.out.print("A");
            }
        }    
	}
}