package implementation;

import structures.*;

public class Main {

	public static void main(String[] args){
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		bt.add(10);
		bt.add(15);
		bt.add(9);
		bt.add(11);
		bt.add(20);
		bt.add(22);
		bt.add(21);
		bt.add(23);
		bt.add(19);
		bt.add(18);
		bt.add(16);
		bt.print("-");
		bt.delete(20);
		System.out.println("AFTER DELETING 20");
		bt.print("-");
	}
	
}
