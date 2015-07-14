import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author kumaksha
 *
 */
public class FilterOddNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<Integer>();
		addNumber(numberList);
		removeOddNumber(numberList);
		for(int i = 0; i < numberList.size(); i++) {
			System.out.println(numberList.get(i));
		}
	}

	private static void addNumber(List<Integer> numberList) {
		for(int i = 1; i <= 100; i++) {
			numberList.add(i);
		}
	}

	private static void removeOddNumber(List<Integer> numberList) {
		for(int i = 0; i < numberList.size(); ) {
			int temp = numberList.get(i);
			if((temp & 1) > 0) {
				numberList.remove(i);
			} else {
				i++;
			}
		}
	}

}
