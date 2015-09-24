
public class ObjectSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayInOb arr = new ArrayInOb(maxSize);
		
		arr.insert("wang", "bin", 26);
		arr.insert("li", "lingli", 23);
		arr.insert("bian", "lulu", 1);
		arr.insert("ren", "zhen", 3);
		arr.insert("he", "chuan", 7);
		arr.insert("wei", "wei", 2);
		System.out.println("Before Sorting:");
		arr.display();
		
		arr.insertionSort();
		System.out.println("After Sorting");
		arr.display();
		
		System.out.println("按年龄排序后的：");
		arr.insertionSortAge();
		arr.display();
		
	
	}
}
