package structures;

/**
 * Generic dynamic array implementation.
 * @author joeb3219
 *
 */
public class DynamicArray<T>{

	private int size = 10;
	private int filled = 0;
	private T[] array;
	
	/**
	 * Creates a DynamicArray of a predetermined size.
	 */
	public DynamicArray(){
		array = (T[])new Object[size];
	}
	
	/**
	 * Creates a DynamicArray of the indicated size.
	 * @param size The size of the initial array.
	 */
	public DynamicArray(int size){
		this.size = size;
		array = (T[])new Object[size];
	}
	
	/**
	 * Gets the size of the FILLED portion of the array.
	 * @return Returns the number of elements FILLED in the array.
	 */
	public int size(){
		return filled;
	}
	
	/**
	 * If the array is filled, creates a new array and copies the contents of the old array over.
	 * New array will be growthFactor times larger than the original.
	 * Runs in O(n).
	 */
	private void respaceIfNeeded(){
		if( (filled + 1) != size) return;
		
		size *= 2;
		T[] newArr = (T[])new Object[size];
		for(int i = 0; i < filled; i ++){
			newArr[i] = array[i];
		}
		array = newArr;
	}
	
	/**
	 * Adds an object to the end of the array.
	 * If the array is not big enough, calls respaceIfNeeded() to create more room in the data structure.
	 * Runs in O(1) unless a respace is needed, in which case will run in O(n + 1) => O(n).
	 * @param num Object to insert
	 */
	public void add(T obj){
		respaceIfNeeded();
		array[filled] = obj;
		filled ++;
	}
	
	/**
	 * Removes the object at the specified position from the array.
	 * @param pos Index of the item to remove.
	 * @return Returns the object removed.
	 */
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
	
	/**
	 * Returns the object at the indicated position.
	 * Runs in O(1).
	 * @param pos Index of the number to return.
	 * @return Returns the object at index pos.
	 */
	public T get(int pos){
		if(pos >= filled) return null;
		return array[pos];
	}
	
	/**
	 * Prints the contents of the data structure.
	 */
	public void print(){
		for(int i = 0; i < size; i ++){
			System.out.print("(" + i + ": " + array[i] + "), ");
		}
		System.out.println();
	}
	
}
