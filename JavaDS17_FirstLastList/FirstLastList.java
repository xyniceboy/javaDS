
public class FirstLastList {
	public Link first;
	public Link last;   //����ǵ��ı��˫�����������
	
	public FirstLastList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(long dd){
		Link newLink = new Link(dd);
		if(isEmpty()) 
			last = newLink;
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(long dd){
		Link newLink = new Link(dd);
		
		if(isEmpty())
			first = newLink;
		else 
			last.next =  newLink;
		last = newLink;
	}
	
	//ɾ����һ��
	public long deleteFirst(){
		long temp = first.dData;
		if(first.next == null)
			last = null;
		first = first.next;
		return temp;
	}
	
	//��ʾ�����������
	public void displayList(){
		System.out.print("List(first-->last): ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		
		System.out.println();
	}
}
