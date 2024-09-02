class Node {

	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class rightView {

	Node root;
	int maxlevel = 0;

	void rightViewUtil(Node node, int level) {
		if (node == null)
			return;

		if (maxlevel < level) {
			System.out.print(node.data + " ");
			maxlevel = level;
		}
		rightViewUtil(node.right, level + 1);
		rightViewUtil(node.left, level + 1);
	}

	void rightView() {
		maxlevel = 0;
		rightViewUtil(root, 1);
	}

	public static void main(String args[]) {
		rightView tree = new rightView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);

		tree.rightView();
	}
}