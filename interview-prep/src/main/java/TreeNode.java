public class TreeNode<T> {

	private final T value;
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;

	public TreeNode(T value) {
		this.value = value;
	}

	public TreeNode<T> left(TreeNode<T> left) {
		this.leftNode = left;
		return this;
	}

	public TreeNode<T> right(TreeNode<T> right) {
		this.rightNode = right;
		return this;
	}

	public String toString() {
		return getValue().toString();
	}

	public TreeNode<T> getRight() {
		return rightNode;
	}

	public TreeNode<T> getLeft() {
		return leftNode;
	}

	public T getValue() {
		return value;
	}

}