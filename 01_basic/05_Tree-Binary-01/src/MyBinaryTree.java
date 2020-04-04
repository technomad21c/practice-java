//https://www.geeksforgeeks.org/binary-tree-set-1-introduction/?ref=lbp
//https://www.javatpoint.com/binary-tree

class Node {
	int key;
	Node left, right;
	
	Node(int item) {
		key = item;
		left = right = null;
	}
}

public class MyBinaryTree {
	Node root;
	
	MyBinaryTree(int key) {
		root = new Node(key);
	}
	
	MyBinaryTree() {
		root = null;
	}
	
	public static void main(String args[]) {
		MyBinaryTree tree = new MyBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
	}
}
