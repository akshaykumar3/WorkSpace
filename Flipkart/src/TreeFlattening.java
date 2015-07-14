import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



/**
 * 
 */

/**
 * @author kumaksha
 *
 */
public class TreeFlattening {

	/**
	 * 
	 */
	public TreeFlattening() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = buildTree();
		System.out.println("Give input Node");
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		printTuppleData(value,root);
		System.out.println("Give input key");
		String key = scanner.nextLine();
		System.out.println("Give input value");
		value = scanner.nextLine();
		printContainingValues(key, value, root);
	}
	
	private static void printTuppleData(String value, TreeNode root) {
		Map<String, String> tuppleData = getTuppleData(value, root);
		System.out.println(tuppleData);
	}
	

	private static void printContainingValues(String key, String value, TreeNode node) {
		if(null == node)
			return;
		if(node.getTupple().containsKey(key) && value.equals(node.getTupple().get(key))) {
			System.out.println(node.getValue());
		}
		printContainingValues(key, value, node.getLeftChild());
		printContainingValues(key, value, node.getRightChild());
	}

	private static Map<String, String> getTuppleData(String value, TreeNode node) {
		if(null == node) {
			return null;
		}
		if(value.equals(node.getValue())) {
			return node.getTupple();
		}
		Map<String, String> tempData = getTuppleData(value, node.getLeftChild());
		return (null != tempData) ? tempData : getTuppleData(value, node.getRightChild());
	}

	private static TreeNode buildTree() {
		TreeNode a = new TreeNode("A");
		Map<String, String> tupple = new HashMap<String, String>();
		tupple.put("name", "abc");
		tupple.put("id", "5");
		tupple.put("place", "Tirupati");
		a.setFromCurrentTupple(tupple);
		
		TreeNode B = new TreeNode("B", a.getTupple());
		tupple.clear();
		tupple.put("name", "efg");
		tupple.put("id", "24");
		B.setFromCurrentTupple(tupple);
		
		TreeNode C = new TreeNode("C", B.getTupple());
		tupple.clear();
		tupple.put("name", "xyz");
		C.setFromCurrentTupple(tupple);
		
		TreeNode D = new TreeNode("D", B.getTupple());
		tupple.clear();
		tupple.put("place", "Bangalore");
		tupple.put("job", "SoftwareEngineer");
		D.setFromCurrentTupple(tupple);
		
		TreeNode E = new TreeNode("E", C.getTupple());
		tupple.clear();
		tupple.put("id", "34");
		E.setFromCurrentTupple(tupple);
		
		a.setLeftChild(B);
		a.setRightChild(null);
		
		B.setLeftChild(C);
		B.setRightChild(D);
		
		C.setLeftChild(E);
		C.setRightChild(null);
		
		D.setLeftChild(null);
		D.setRightChild(null);
		
		E.setLeftChild(null);
		E.setRightChild(null);
		
		return a;
	}

}
