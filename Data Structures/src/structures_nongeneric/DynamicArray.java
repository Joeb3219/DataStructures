package structures_nongeneric;

import java.util.NoSuchElementException;

/**
 * Dynamic Array implementation for Integers.
 * @author joeb3219
 *
 */
public class DynamicArray{

	private int size = 10;
	private int filled = 0;
	private int[] array;
	private static final int growthFactor = 2;
	
	/**
	 * Creates a DynamicArray of a predetermined size.
	 */
	public DynamicArray(){
		array = new int[size];
	}
	
	/**
	 * Creates a DynamicArray of the indicated size.
	 * @param size The size of the initial array.
	 */
	public DynamicArray(int size){
		this.size = size;
		array = new int[size];
	}
	
	/**
	 * Adds a number to the end of the array.
	 * If the array is not big enough, calls respaceIfNeeded() to create more room in the data structure.
	 * Runs in O(1) unless a respace is needed, in which case will run in O(n + 1) => O(n).
	 * @param num Number to insert
	 */
	public void add(int num){
		respaceIfNeeded();
		array[filled] = num;
		filled ++;
	}
	
	/**
	 * Removes the object at the specified position from the array.
	 * @param pos Index of the item to remove.
	 * @return Returns the integer removed.
	 */
	public int remove(int pos){
		if(pos >= filled) throw new NoSuchElementException();
		int num = array[pos];
		array[filled] = -1;
		for(int i = pos; i < filled - 1; i ++){
			if(array[i] == -1) break;
			array[i] = array[i + 1];
		}
		
		filled --;
		return num;
	}
	
	/**
	 * Returns the integer at the indicated position.
	 * Runs in O(1).
	 * @param pos Index of the number to return.
	 * @return Returns the integer at index pos.
	 */
	public int get(int pos){
		if(pos >= filled) throw new NoSuchElementException();
		return array[pos];
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
		
		size *= growthFactor;
		int[] newArr = new int[size];
		for(int i = 0; i < filled; i ++){
			newArr[i] = array[i];
		}
		array = newArr;
	}
	
	/**
	 * Prints out the contents of the structure.
	 */
	public void print(){
		for(int i = 0; i < size; i ++){
			System.out.print("(" + i + ": " + array[i] + "), ");
		}
		System.out.println();
	}
	
}
