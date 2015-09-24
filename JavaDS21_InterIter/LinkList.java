
public class LinkList {
	private Link first;
	public LinkList(){
		first = null;
	}
	
	public Link getFirst(){
		return first;
	}
	
	public void setFirst(Link f){
		first = f;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void displayList(){
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		
		System.out.println();
	}
	
	//����java�Դ����������Լ�дһ������ĵ�����
	public ListIterator getIterator(){
		return new ListIterator(this);
	}
} //public class ����

//��Ϊǰ���Ѿ�public�ˣ��������ﲻ����public��
class ListIterator {
	  private Link current;  //���ڷ��ʵĵ�ǰ�ڵ�
	  private Link previous;   //���ڷ��ʽڵ��ǰһ���ڵ�
	  private LinkList outList;   //linkList�Լ�
	  
	  public ListIterator(LinkList list){
		  outList = list;
		  reset();
	  }
	  
	  //��Ҫ��������
	  public void reset(){
		  current = outList.getFirst();  //ָ������ĵ�һ��
		  previous = null;  //ǰһ��Ϊ��
	  }
	  
	  public boolean atEnd(){
		  return current.next == null;  //��û�е�ĩβ
	  }
	  
	  //�õ������������ƶ�һ����ʵ�ֵ����Ĺ���
	  public void nextLink(){
		  previous = current;
		  current = current.next;
	  }
	  
	  public Link getCurrent(){
		  return current;
	  }
	  
	  //�ڵ��������ڷ��ʵ����ڵ�֮�󣬲���һ���½ڵ�
	  public void insertAfter(long dd){
		  Link newLink = new Link(dd);
		  if(outList.isEmpty()){
			  outList.setFirst(newLink);
			  current = newLink;
		  }else {
			  newLink.next = current.next;
			  current.next = newLink; 
			  nextLink();  //�����ƶ�һ��
		  }
	  }
	  
	  //�п����ǵ�һ��������һ����û��
	  //�ڵ��������ڷ��ʵ����ڵ�֮ǰ����һ���½ڵ�
	  public void insertBefore(long dd){
		  Link newLink = new Link(dd);
		  if(previous == null) {
			  newLink.next = outList.getFirst();  //�½ڵ����һ�����ڵ�ǰ����ĵ�һ���ڵ�
			  outList.setFirst(newLink);
			  reset();
		  }else{
			  newLink.next = previous.next;
			  previous.next = newLink;
			  current = newLink;   
		  }
	  }
	  
	  public long deleteCurrent(){
		  long value = current.dData;
		  if(previous == null){
			  outList.setFirst(current.next);
			  reset();
		  }else{
			  previous.next = current.next;
			  
			  if(atEnd())
				  
				  reset();
			  else 
				  current = current.next;
//				  current.next = current.next;
		  }
		  return value;
	  }
}


