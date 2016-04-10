package structures;

public class ArrList<T>{

	private int size = 10;
	private int fill = 0;
	private T[] array;
	
	public ArrList(){
		array = (T[])new Object[size];
	}
	
	public ArrList(int size){
		this.size = size;
		array = (T[])new Object[size];
	}
	
	private void respace(){
		if(fill != size) return;
		
		size *= 2;
		T[] newArr = (T[])new Object[size];
		for(int i = 0; i < fill; i ++){
			newArr[i] = array[i];
		}
		array = newArr;
	}
	
	public void add(T obj){
		fill ++;
		respace();
		fill --;
		array[fill] = obj;
		fill ++;
	}
	
	public T remove(int pos){
		if(pos >= fill) return null;
		T obj = array[pos];
		array[fill] = null;
		for(int i = pos; i < fill - 1; i ++){
			if(array[i] == null) break;
			array[i] = array[i + 1];
		}
		
		fill --;
		return obj;
	}
	
	public T get(int pos){
		if(pos >= fill) return null;
		return array[pos];
	}
	
	public void print(){
		for(int i = 0; i < size; i ++){
			System.out.print("(" + i + ": " + array[i] + "), ");
		}
		System.out.println();
	}
	
}
