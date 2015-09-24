
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
	
	//不用java自带迭代器，自己写一个链表的迭代器
	public ListIterator getIterator(){
		return new ListIterator(this);
	}
} //public class 结束

//因为前面已经public了，所以这里不能再public了
class ListIterator {
	  private Link current;  //正在访问的当前节点
	  private Link previous;   //正在访问节点的前一个节点
	  private LinkList outList;   //linkList自己
	  
	  public ListIterator(LinkList list){
		  outList = list;
		  reset();
	  }
	  
	  //需要方法重置
	  public void reset(){
		  current = outList.getFirst();  //指向链表的第一个
		  previous = null;  //前一个为空
	  }
	  
	  public boolean atEnd(){
		  return current.next == null;  //有没有到末尾
	  }
	  
	  //让迭代器，向下移动一个，实现迭代的功能
	  public void nextLink(){
		  previous = current;
		  current = current.next;
	  }
	  
	  public Link getCurrent(){
		  return current;
	  }
	  
	  //在迭代器正在访问的链节点之后，插入一个新节点
	  public void insertAfter(long dd){
		  Link newLink = new Link(dd);
		  if(outList.isEmpty()){
			  outList.setFirst(newLink);
			  current = newLink;
		  }else {
			  newLink.next = current.next;
			  current.next = newLink; 
			  nextLink();  //向下移动一下
		  }
	  }
	  
	  //有可能是第一个，或者一个都没有
	  //在迭代器正在访问的链节点之前插入一个新节点
	  public void insertBefore(long dd){
		  Link newLink = new Link(dd);
		  if(previous == null) {
			  newLink.next = outList.getFirst();  //新节点的下一个等于当前链表的第一个节点
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


