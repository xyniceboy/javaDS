package javaDS03_HighArray;

public class HighArrayApp {
	public static void main(String[] args) {
		int maxSize = 100;
		HighArray arr;
		arr = new HighArray(maxSize);   
		
//		HighArray arr = new HighArray(maxSize);
		
		arr.insert(10);
		arr.insert(11);
		arr.insert(12);
		arr.insert(13);
		arr.insert(14);
		arr.insert(15);
		arr.insert(16);
		arr.insert(17);
		
		arr.display();
		
		int searchKey = 12;
		if(arr.find(searchKey))
			System.out.println("Found "+searchKey);
		else 
			System.out.println("Cann't find " + searchKey);
		
		
		arr.delete(33);
		arr.delete(15);
		arr.delete(17);
		
		arr.display();
	}
}
