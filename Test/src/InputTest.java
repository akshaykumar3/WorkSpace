import java.util.Scanner;

/**
 * 
 */

/**
 * @author kumaksha
 *
 */
public class InputTest {

	/**
	 * 
	 */
	public InputTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Enter a number");
		Scanner scannner = new Scanner(System.in);
		int inputInt = scannner.nextInt();
		System.out.println(inputInt);
	}

}
