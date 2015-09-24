public class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayIns arr = new ArrayIns(maxSize);

		arr.insert(10);
		arr.insert(3);
		arr.insert(16);
		arr.insert(78);
		arr.insert(2);
		arr.insert(6);

		arr.display();
		arr.insertionSort();
		arr.display();
	}
}
