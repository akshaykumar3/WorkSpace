import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author kumaksha
 *
 */
public class TreeNode {

	private String value;
	private Map<String, String> tupple = new HashMap<String, String>();
	private TreeNode leftChild, rightChild;
	private boolean requireUpdation = false;

	/**
	 * 
	 */
	public TreeNode(String value) {
		this.value = value;
	}

	public TreeNode(String value, Map<String, String> tupple) {
		this.value = value;
		setFromParentTupple(tupple);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getTupple() {
		return tupple;
	}

	public void setFromCurrentTupple(String key, String value) {
		this.tupple.put(key, value);
	}

	public void setFromCurrentTupple(Map<String, String> newTupple) {
		this.tupple.putAll(newTupple);
	}

	public void setFromParentTupple(Map<String, String> newTupple) {
		Set<String> keySet = newTupple.keySet();
		for (String key : keySet) {
			if (!this.tupple.containsKey(key)) {
				this.tupple.put(key, newTupple.get(key));
			}
		}
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public boolean getRequireUpdation() {
		return this.requireUpdation;
	}

	public void setRequireUpdation(boolean requireUpdation) {
		this.requireUpdation = requireUpdation;
	}

}
