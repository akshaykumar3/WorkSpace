import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class ReturnStatement {

	public static void main(String[] args) throws IOException
	{
		boolean flag = checkReturnStatement();
		System.out.println(flag);
		
	}

	private static boolean checkReturnStatement() {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		set1.add("1");
		set1.add("2");
		set1.add("3");
		set2.add("2");
		set2.add("3");
		return set1.containsAll(set2);
	}
}
