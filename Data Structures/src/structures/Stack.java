package structures;

import java.util.NoSuchElementException;

public class Stack <T>{

	public int size = 0;
	private ArrList<T> arrList;
	
	public Stack(){
		arrList = new ArrList<T>();
	}
	
	public void push(T obj){
		arrList.add(obj);
		size ++;
	}
	
	public T pop(){
		if(size == 0) throw new NoSuchElementException();
		T obj = arrList.remove(size - 1);
		size --;
		return obj;
	}
	
	public T peek(){
		if(size == 0) throw new NoSuchElementException();
		return arrList.get(size - 1);
	}
	
}
