public class SelectSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ArraySel arr = new ArraySel(maxSize);
		
		arr.insert(16);
		arr.insert(25);
		arr.insert(32);
		arr.insert(76);
		arr.insert(21);
		arr.insert(34);
		arr.insert(10);
		
		arr.display();
		arr.selectionSort();
		arr.display();
	}
}
