import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import javax.lang.model.type.PrimitiveType;


public class SpeedComparison 
{
	
	public static void main(String[] args)
	{
		//compareSwitchWithIfElse();
		//compareTernaryWithIfElse();
		//compareReturnStatementWithIfElse();
		TestEnum.INSTANCE.printFunction();
	}

	private static void compareReturnStatementWithIfElse() {
		long loop = 100000000;
		ReturnStatementCall(loop);
		AlsoIfElseCall(loop);
	}

	private static void AlsoIfElseCall(long loop) {
		Date date = new Date();
		System.out.println("Time in IfElseCall call : " + date);
		boolean temp;
		while(0 != loop--)
			temp = getIfElseReturn();
		date = new Date();
		System.out.println(date);
	}

	private static boolean getIfElseReturn() {
		if(1 == helper())
			return true;
		return false;
	}

	private static void ReturnStatementCall(long loop) {
		Date date = new Date();
		System.out.println("Time in ReturnStatement call : " + date);
		boolean temp;
		while(0 != loop--)
			temp = getDirectReturn();
		date = new Date();
		System.out.println(date);
	}

	private static boolean getDirectReturn() {
		return helper() == 1;
	}

	private static void compareTernaryWithIfElse() {
		long loop = 100000000;
		TernaryCall(loop);
		IfElseCall(loop);
	}
	
	private static int helper() {
		int c;
		c = 100;
		while(0 != c--)
		{
			primeFactorize();
		}
		return c;
	}

	private static void TernaryCall(long loop) {
		Date date = new Date();
		System.out.println("Time in Ternary call : " + date);
		int i = 0;
		int c = 0, a = 10, b = 5;
		while(0 != loop--)
		{
			c = 100;
			while(0 != c--)
			{
				primeFactorize();
			}
			c = (i==1) ? a+b : a-b;
			i = i ^ 1;
		}
		date = new Date();
		System.out.println(c+"\n"+date);
	}
	
	private static void IfElseCall(long loop) {
		Date date = new Date();
		System.out.println("Time in IfElse call : " + date);
		int i = 0;
		int c = 0, a = 10, b = 5;
		while(0 != loop--)
		{
			c = 100;
			while(0 != c--)
			{
				primeFactorize();
			}
			if(i==1)
				c = a+b;
			else
				c = a-b;
			i = i ^ 1;
		}
		date = new Date();
		System.out.println(c+"\n"+date);
	}
	
	private static void primeFactorize() {
		int i, n = 100;
		for(i = 2; i <= Math.sqrt(n);i++) {
			if(n%i==0)
			{
				while(n%i==0)
				{
					n/=i;
				}
			}
		}
	}

	private static void compareSwitchWithIfElse()
	{
		BigInteger loops = new BigInteger("10");
		System.out.println("Time in IfElse");
		getIfElseTime(loops);
		System.out.println("\n\nTime in Switch");
		getSwitchTime(loops);
		
	}

	private static void getSwitchTime(BigInteger loops) 
	{
		Date date = new Date();
		System.out.println(date);
		BigInteger temp = new BigInteger("-1");
		int a = 5, b = 6,c;
		while(!loops.equals(0))
		{
			loops.add(temp);
			Random random = new Random();
			int n = random.nextInt(10);
			switch(n)
			{
				case 1:
					c = a + b;
					break;
				case 2:
					c = a + b;
					break;
				case 3:
					c = a + b;
					break;
				case 4:
					c = a + b;
					break;
				case 5:
					c = a + b;
					break;
				case 6:
					c = a + b;
					break;
				case 7:
					c = a + b;
					break;
				case 8:
					c = a + b;
					break;
				case 9:
					c = a + b;
					break;
				case 10:
					c = a + b;
					break;
				default:
					c = a + b;
			}
		}
		date = new Date();
		System.out.println(date);
	}

	private static void getIfElseTime(BigInteger loops) 
	{
		Date date = new Date();
		System.out.println(date);
		BigInteger temp = new BigInteger("-1");
		int a = 5, b = 6,c;
		while(!loops.equals(0))
		{
			loops.add(temp);
			Random random = new Random();
			int n = random.nextInt(10);
			if(n==1)
				c = a + b;
			else if(n==2)
				c = a + b;
			else if(n==3)
				c = a + b;
			else if(n==4)
				c = a + b;
			else if(n==5)
				c = a + b;
			else if(n==6)
				c = a + b;
			else if(n==7)
				c = a + b;
			else if(n==8)
				c = a + b;
			else if(n==9)
				c = a + b;
			else if(n==10)
				c = a + b;
			else 
				c = a + b;
		}
		date = new Date();
		System.out.println(date);
	}
}
