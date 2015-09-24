/*
 * 用单端链表(从头拿，从头放)，很好的特点，实现 栈
 */

public class LinkStack {
	private LinkList theList;
	
	public LinkStack(){
		theList = new LinkList();
	}
	
	public void push(long j){
		theList.insertFirst(j);
	}
	
	public long pop(){
		return theList.deleteFirst();
	}
	
	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public void displayStack(){
		System.out.print("Stack(top-->bottom:)");
		theList.displayList();
	}
}
