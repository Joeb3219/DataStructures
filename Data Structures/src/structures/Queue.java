package structures;

import java.util.NoSuchElementException;

public class Queue<T> {

	private ArrList<T> arrList;
	private int size = 0;
	
	public Queue(){
		arrList = new ArrList<T>();
	}
	
	public void enqueue(T obj){
		size ++;
		arrList.add(obj);
	}
	
	public T dequeue(){
		if(size == 0) throw new NoSuchElementException();
		size --;
		return arrList.remove(0);
	}
	
}
