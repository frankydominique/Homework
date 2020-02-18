
public class TreeNode {
	private Object value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Object v)
	{
		value = v;
		left = null;
		right = null;
	}
	
	public TreeNode(Object v, TreeNode lt, TreeNode rt)
	{
		value = v;
		left = lt;
		right = rt;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
}
