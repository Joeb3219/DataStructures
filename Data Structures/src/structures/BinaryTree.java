package structures;

import java.util.NoSuchElementException;

public class BinaryTree <T extends Comparable>{

	private class Node<T>{
		
		public T data;
		public Node<T> left;
		public Node<T> right;
		
		public Node(T data, Node<T> left, Node<T> right){
			this.data = data;
			this.right = right;
			this.left = left;
		}
		
		public String toString(){return "" + data + "";}
		
	}
	
	private Node<T> root;
	
	public BinaryTree(){
		
	}
	
	public void add(T data){
		if(root == null){
			root = new Node<T>(data, null, null);
			return;
		}
		Node<T> ptr = root;
		Node<T> prev = null;
		while(ptr != null){
			prev = ptr;
			if(data.compareTo(ptr.data) == -1) ptr = ptr.left;
			else ptr = ptr.right;
		}
		if(data.compareTo(prev.data) == -1) prev.left = new Node(data, null, null);
		else prev.right = new Node(data, null, null);
	}
	
	public Node<T> findParent(Node<T> target){
		Node<T> node = root;
		Node<T> prev = null;
		while(node != null){
			if(node == target) return prev;
			prev = node;
			if(node.data.compareTo(target.data) > 0) node = node.left;
			else node = node.right;
		}
		throw new NoSuchElementException();
	}
	
	public void delete(T target){
		Node<T> node = null;
		do{
			try{
				node = search(target);
				delete(node);
			}catch(NoSuchElementException e){
				node = null;
				return;
			}
		}while(node != null);
	}
	
	public void delete(Node<T> node){
		Node<T> parent = findParent(node);
		boolean isLeftChild = (parent.left == node);
		if(node.left == null && node.right == null){
			if(isLeftChild) parent.left = null;
			else parent.right = null;
		}else if((node.left != null && node.right == null)){
			if(isLeftChild) parent.left = node.left;
			else parent.right = node.left;
		}else if((node.left == null && node.right != null)){
			if(isLeftChild) parent.left = node.right;
			else parent.right = node.right;
		}else{
			Node<T> smallest = findSmallest(node.right);
			Node<T> smallestParent = findParent(smallest);
			if(smallestParent == node){
				smallestParent.data = smallest.data;
				delete(smallest);
			}else{
				smallestParent.left = null;
				node.data = smallest.data;
			}
		}
	}
	
	protected Node<T> findSmallest(Node<T> root){
		if(root == null) return null;
		if(root.left == null && root.right == null) return root;
		Node<T> leftSmallest = findSmallest(root.left);
		Node<T> rightSmallest = findSmallest(root.right);
		if(leftSmallest != null && leftSmallest.data.compareTo(root.data) < 0) return root.left;
		if(rightSmallest != null && rightSmallest.data.compareTo(root.data) < 0) return root.right;
		return root;
	}
	
	public Node<T> search(T data){
		Node<T> node = root;
		while(node != null){
			if(node.data.equals(data)) return node;
			if(node.data.compareTo(data) > 0) node = node.left;
			else node = node.right;
		}
		throw new NoSuchElementException();
	}
		
	public void print(String indent){
		print(root, indent);
	}
	
	public void print(Node<T> root, String indent){
		if(root == null) return;
		System.out.println(indent + root);
		print(root.left, indent + "-");
		print(root.right, indent + "-");
	}
	
}
