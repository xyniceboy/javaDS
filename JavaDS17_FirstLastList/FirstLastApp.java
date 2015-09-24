
public class FirstLastApp {
	public static void main(String[] args) {
		FirstLastList theList = new FirstLastList();
		
		//测试前插入和后插入是否正确
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);
		theList.displayList();
		
		//测试删除
		theList.deleteFirst();
		theList.deleteFirst();
		theList.deleteFirst();
		theList.displayList();
	}
}	
