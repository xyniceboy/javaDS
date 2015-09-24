package bwang;

public class SortedListApp {
	public static void main(String[] args) {
		SortedList theSortedList = new SortedList();
		
		//测插入
		theSortedList.insert(20);
		theSortedList.insert(40);
		theSortedList.insert(60);
		theSortedList.displayList();
		theSortedList.insert(10);
		theSortedList.insert(30);
		theSortedList.insert(50);
		theSortedList.displayList();
		
		//测删除
		theSortedList.remove();
		theSortedList.displayList();
	}
}

//小结：
//如果一个应用需要频繁的存取最小值，并且需要有序的插入。那么这个有序链表是一个很好的选择。
