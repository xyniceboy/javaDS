package bwang;

public class SortedList {
	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	public SortedList(Link[] linkArr){
		first = null;
		for(int j = 0; j < linkArr.length; j++){
			insert(linkArr[j]);
		}
	}
	
	public void insert(Link k){
		Link previous = null;
		Link current = first;
		while(current != null && k.dData > current.dData){
			previous = current;
			current = current.next;
		}
		
		if(previous == null)
			first = k;
		else
			previous.next = k;
		k.next = current;
	}
	
	public void insert(long key){
		Link newLiink = new Link(key);
		Link previous = null;  //������¼�ҵ���ǰһ���ڵ�
		Link current = first; // ����������ָ��
		
		//���Ҳ���
		while(current!=null && key > current.dData){
			previous = current;
			current = current.next;
		} //������Ҫô�ҵ��ˣ�Ҫô�ҵ�ͷ��
		
		//���ݲ��ҽ�������в������
		//1,ǰ������
		if(previous == null)  //û�ж�����null,��ônewLink���ǵ�һ��
			first = newLiink;  
		else 
			previous.next = newLiink;   //
		
		//2����������
		newLiink.next = current;
	}
	
	//�����ʱ����Ҫ��������ɾ�����ֲڵ����˴�ͷɾ
	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.print("List(first-->last):");
		Link current = first;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}
