package structures;

import java.util.NoSuchElementException;

public class CLL <T>{

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
	
	public Node<T> rear;
	public int size = 0;
	
	public CLL(){
		
	}
	
	public void print(){
		if(rear == null) return;
		Node<T> ptr = rear;
		System.out.print("(" + size + ") ");
		do{
			ptr = ptr.next;
			System.out.print(ptr + " => ");
		}while(ptr != rear);
		System.out.println();
	}
	
	public void remove(T target){
		if(rear == null) throw new NoSuchElementException();
		if(rear.next == rear && rear.data == target){
			rear = null;
			size --;
			return;
		}
		Node<T> ptr = rear;
		Node<T> prev = null;
		while(ptr != rear){
			if(ptr.data == target){
				if(ptr == rear){
					rear = ptr.next;
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
		if(rear == null){
			rear = t;
			rear.next = rear;
		}
		else{
			Node<T> ptr = rear;
			while(ptr.next != rear) ptr = ptr.next;
			ptr.next = t;
			t.next = rear;
		}
		size ++;
	}
	
}
