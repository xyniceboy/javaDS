package javaDS06_bubbleSort;

public class BubbleSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayBub arr;
		arr = new ArrayBub(maxSize);
		
		arr.insert(26);
		arr.insert(13);
		arr.insert(16);
		arr.insert(14);
		arr.insert(19);
		arr.insert(32);
		 
		arr.display();   //≈≈–Ú«∞œ‘ æ
		
		arr.bubbleSort();
		arr.display();   //√∞≈›≈≈–Ú∫Ûœ‘ æ
		
		
	}
}
