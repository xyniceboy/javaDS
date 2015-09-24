public class LinkList2App {
	public static void main(String[] args) {
		LinkList theList = new LinkList();

		// 测插入
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		theList.displayList();
		
		// 测查找
		Link f = theList.find(44);
		if(f != null)
			System.out.println("Found Link with key: " + f.iData);
		else 
			System.out.println("Cann't find linkNode");
		
		//测删除
		Link d = theList.delete(66);
		if(d!=null)
			System.out.println("Deleted Link with key: " + d.iData);
		else 
			System.out.println("Cann't delete linkNode");
		theList.displayList();  //显示当前链表中的数据项
	}
}

//小结：这种链表的插入、删除比较快，查找比较慢
