//https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
import java.util.*;

public class BinarySearchTree <T extends Comparable<T>> implements Iterable<T> {
	public static void main(String args[]) {
		Integer[] a = {1,5,2,7,4};
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for (Integer n : a) {
			bst.insert(n);
		}
	}
	
	private Node<T> root;
	private Comparator<T> comparator;
	
	public BinarySearchTree() {
		root = null;
		comparator = null;
	}
	
	public BinarySearchTree(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}
	
	private int compare(T x, T  y) {
		if (comparator == null) return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}
	
	public void insert(T data) {
		root = insert(root, data);
	}
	
	private Node<T> insert(Node<T> p, T toInsert) {
		if (p == null) 
			return new Node<T>(toInsert);
		if (compare(toInsert, p.data) == 0) 
			return p;
		if (compare(toInsert, p.data)< 0)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);
		
		return p;
	}
	
	public boolean search(T toSearch) {
		return search(root, toSearch);
	}
	
	public boolean search(Node<T> p, T toSearch) {
		if (p == null) 
			return false;
		else
			if (compare(toSearch, p.data) == 0)
				return true;
			else
				if (compare(toSearch, p.data) < 0)
					return search(p.left, toSearch);
				else
					return search(p.right, toSearch);
	}
	
	public void delete(T toDelete) {
		root = delete(root, toDelete);
	}
	public Node<T> delete(Node<T> p, T toDelete) {
		if (p == null) throw new RuntimeException("cannot delete");
		else
			if (compare(toDelete, p.data) < 0)
				p.left = delete(p.left, toDelete);
			else
				if (compare(toDelete, p.data)> 0) 
					p.right = delete(p.right, toDelete);
				else {
					if (p.left == null) return p.right;
					else
						if (p.right == null) return p.left;
						else {
							p.data = retrieveData(p.left);
							p.left = delete(p.left, p.data);
						}							
				}
		
		return p;
	}
	
	private T retrieveData(Node<T> p) {
		while (p.right != null) p = p.right;
		return p.data;
	}
	
	public String toString()  {
		StringBuffer sb = new StringBuffer();
		for (T data : this) sb.append(data.toString());
		
		return sb.toString();
	}
	
	public void preOrderTraversal() {
		preOrderHelper(root);
	}
	
	public void preOrderHelper(Node r) {
		if (r != null) {
			System.out.println(r + " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);			
		}
	}
	
	public void inOrderTraversal() {
		inOrderHelper(root);
	}
	
	public void inOrderHelper(Node r) {
		if (r != null) {
			inOrderHelper(r.left);
			System.out.println(r + " ");
			inOrderHelper(r.right);
		}
	}	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private class Node<T> {
		private T data;
		private Node<T> left, right;
		
		public Node(T data, Node<T> l, Node<T> r) {
			left = l; right = r;
			this.data = data;
		}
		
		public Node(T data) {
			this(data, null, null);
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
}
