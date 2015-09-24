
public class DoubleLinkedApp {
	public static void main(String[] args) {
		DoubleLinkedList theLink = new DoubleLinkedList();
		
		//测试从头插入、尾部插入、指定位置插入
		theLink.insertFirst(22);
		theLink.insertFirst(44);
		theLink.insertFirst(66);
		theLink.insertLast(11);
		theLink.insertLast(33);
		theLink.insertLast(55);
		theLink.insertAfter(44, 100); 
		theLink.insertAfter(33, 101);
		theLink.displayBackward(); //从后向前显示
		theLink.displayForward();  //从前往后显示
		
		//测试头删除、尾删除、指定元素删除
		theLink.deleteFirst();
		theLink.deleteLast();
		theLink.deletekey(101);
		theLink.displayBackward();
		theLink.displayForward();
	}
}


//双向链表实现了双端队列的功能，可以从任意一头插入，也可以从任意一端删除