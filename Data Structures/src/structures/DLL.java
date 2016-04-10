package structures;

import java.util.NoSuchElementException;

public class DLL <T>{

	private class Node<T>{
		
		public T data;
		public Node<T> prev = null;
		public Node<T> next = null;
		
		public Node(T data, Node<T> prev, Node<T> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		public String toString(){
			return "(" + this.data + ")";
		}
		
	}
	
	public Node<T> root;
	public int size = 0;
	
	public DLL(){
		
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
		while(ptr != null){
			if(ptr.data == target){
				if(ptr.prev == null){
					root = ptr.next;
				}else{
					ptr.prev = ptr.next;
					if(ptr.next != null) ptr.next.prev = ptr.prev;
					size --;
				}
				ptr = ptr.next;
				continue;
			}
			ptr = ptr.next;
		}
	}
	
	public void add(T data){
		Node<T> t = new Node<T>(data, null, null);
		if(root == null) root = t;
		else{
			Node<T> ptr = root;
			while(ptr.next != null) ptr = ptr.next;
			ptr.next = t;
			t.prev = ptr;
		}
		size ++;
	}
	
}
