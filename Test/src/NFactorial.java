import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class NFactorial {
	
	public static void main(String[] args) throws IOException
	{
		int n;
		System.out.println("Enter a number to print its factorial");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		if(n < 0)
			System.out.println("Negative numbers can not have factorial");
		else if(n == 0 || n==1)
			System.out.println("1");
		else
			getFactorial(n);
	}

	private static void getFactorial(int n) 
	{
		int i = 2;
		Vector<Integer> factorial = new Vector<Integer>();
		factorial.add(1);
		while(i<=n)
		{
			factorial = multiply(factorial,i);
//			while(factorial.elementAt(0) == 0)
//			{
//				factorial.remove(0);
//			}
			i++;
		}
		for(i=0;i<factorial.size();i++)
			System.out.print(factorial.elementAt(i));
	}

	private static Vector<Integer> multiply(Vector<Integer> factorial, int i) 
	{
		int size = factorial.size();
		int r = 0,q = 0;
		Vector<Integer> solution = new Vector<Integer>();
		for(int j = size - 1; j >= 0; j--)
		{
			int x = factorial.elementAt(j);
			int ans = x*i;
			ans += q;
			r = ans % 10;
			q = ans / 10;
			solution.add(0, r);
		}
		while(q>0)
		{
			r = q % 10;
			q = q /10;
			solution.add(0, r);
		}
		return solution;
	}
}
