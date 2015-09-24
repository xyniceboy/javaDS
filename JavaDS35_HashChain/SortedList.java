//������������洢����
public class SortedList {
	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	public void insert(Link theLink){
		int key = theLink.getKey();
		Link previous = null; 
		Link current = first;
		
		while(current != null && key>current.getKey()){ //��ʾ��ǰ�ڵ������ݣ��Ҳ����ֵ>��ǰ��ֵ
			previous = current;
			current = current.next;
		} //while ���ҵ���Ҫ�����λ��
		
		if(previous == null)
			first = theLink;
		else 
			previous.next = theLink;
		theLink.next = current;
	}
	
	public void delete(int key){
		Link previous = null;
		Link current = first;
		while(current != null && key != current.getKey()){
			previous = current;
			current = current.next;
		}
		
		if(previous == null)
			first = first.next;
		else 
			previous.next = current.next;
	}
	
	public Link find(int key){
		Link  current = first;
		while(current != null && current.getKey() <= key){
			if(current.getKey() == key)
				return current;  //�ҵ���
			current = current.next;  //ѭ��������
		}
		
		return null;  //û�ҵ�
	}
	
	public void displayList(){
		System.out.print("List(first-->last):");
		Link current = first;
		
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		
		System.out.println();
	}
}
