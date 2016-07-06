package implementation;

import structures.*;

public class Main {

	public static void main(String[] args){
		structures_nongeneric.DynamicArray dArray = new structures_nongeneric.DynamicArray(3);
		dArray.add(1);
		dArray.add(2);
		dArray.add(3);
		dArray.add(4);
		dArray.print();
	}
	
}
