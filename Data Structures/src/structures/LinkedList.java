package structures;

import java.util.NoSuchElementException;

public class LinkedList <T>{

	private class Node<T>{
		
		public T data;
		public Node<T> next = null;
		
		public Node(T data){
			this.data = data;
		}
		
		public String toString(){
			return "(" + this.data + ")";
		}
		
	}
	
	public Node<T> root;
	public int size = 0;
	
	public LinkedList(){
		
	}
	
	public void print(){
		if(root == null) return;
		Node<T> ptr = root;
		System.out.print("(" + size + ") ");
		do{
			System.out.print(ptr + " => ");
			ptr = ptr.next;
		}while(ptr != null);
		System.out.println();
	}
	
	public void remove(T target){
		if(root == null) throw new NoSuchElementException();
		if(root.next == null && root.data == target){
			root = null;
			size --;
			return;
		}
		Node<T> ptr = root;
		Node<T> prev = null;
		while(ptr != null){
			if(ptr.data == target){
				if(ptr == root){
					root = ptr.next;
				}else{
					prev.next = ptr.next;
					size --;
				}
				ptr = ptr.next;
				continue;
			}
			prev = ptr;
			ptr = ptr.next;
		}
	}
	
	public void add(T data){
		Node<T> t = new Node<T>(data);
		if(root == null) root = t;
		else{
			Node<T> ptr = root;
			while(ptr.next != null) ptr = ptr.next;
			ptr.next = t;
		}
		size ++;
	}
	
}
