
// LinkList��ʾ���������� class
public class LinkList {
	Link first; //��¼��һ�����ӵ�
	
	//������ͷ����ڵ�
	public void insertFirst(int id, double dd){
		Link newLink = new Link(id, dd);  //����һ�������ڵ�
		newLink.next = first;
		first = newLink;  //first��Զָ�� ��һ���ڵ�
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public Link deleteFisrt(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	// ����iDataʱ��������
	public Link find(int key){
		Link current = first;
		while(current.iData != key){  //��������
			if(current.next == null)
				return null;
			else 
				current = current.next;
		}
		return current;   //�������ӵ�
	}
	
	//ɾ�����ҵ��Ľڵ�.����Ƚ���ɾ��ͷ���� deleteFisrt ����Ҫǿ��һ���
	public Link delete(int key){
		Link current = first;
		Link previous = first;
		
		while(current.iData != key){
			if(current.next == null) 
				return null;
			else{
				previous = current;
				current = current.next;
			} 
		}
		
		//�ҵ�������ǵ�һ��
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		
		//����ɾ��������
		return current;
	}
	
	public void displayList(){
		System.out.print("List(first --> last): ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	} 
	
}
