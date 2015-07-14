/**
 * 
 */

/**
 * @author kumaksha
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long value = nthFibonacci(48);
		if(value < 0) {
			System.out.println("Wrong data " + value);
		} else {
			System.out.println(value);
		}
	}

	private static long nthFibonacci(int n) {
		if(1 >= n) return n;
		int a = 0, b = 1, ans = 0;
		n--;
		while(n-- > 0) {
			ans = a + b;
			a = b;
			b = ans;
		}
		return ans;
	}

}
