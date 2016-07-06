package structures;

public class DynamicArray<T>{

	private int size = 10;
	private int filled = 0;
	private T[] array;
	
	public DynamicArray(){
		array = (T[])new Object[size];
	}
	
	public DynamicArray(int size){
		this.size = size;
		array = (T[])new Object[size];
	}
	
	public int size(){
		return filled;
	}
	
	private void respace(){
		if(filled != size) return;
		
		size *= 2;
		T[] newArr = (T[])new Object[size];
		for(int i = 0; i < filled; i ++){
			newArr[i] = array[i];
		}
		array = newArr;
	}
	
	public void add(T obj){
		filled ++;
		respace();
		filled --;
		array[filled] = obj;
		filled ++;
	}
	
	public T remove(int pos){
		if(pos >= filled) return null;
		T obj = array[pos];
		array[filled] = null;
		for(int i = pos; i < filled - 1; i ++){
			if(array[i] == null) break;
			array[i] = array[i + 1];
		}
		
		filled --;
		return obj;
	}
	
	public T get(int pos){
		if(pos >= filled) return null;
		return array[pos];
	}
	
	public void print(){
		for(int i = 0; i < size; i ++){
			System.out.print("(" + i + ": " + array[i] + "), ");
		}
		System.out.println();
	}
	
}
