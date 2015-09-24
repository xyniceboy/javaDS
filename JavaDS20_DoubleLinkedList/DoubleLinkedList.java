
public class DoubleLinkedList {
	private Link first;
	private Link last;
	
	public DoubleLinkedList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(long dd){
		Link newLink = new Link(dd);
		if(isEmpty())
			last = newLink;  //此时的first也是新的
		else 
			first.previous = newLink;
		newLink.next = first;  //newLink的next等于原来的first
		first = newLink;
	}
	
	public void insertLast(long dd) {
		Link newLink = new Link(dd);
		if(isEmpty())
			first = newLink;
		else{
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		if(first.next == null)
			last = null;
		else 
			first.next.previous = null;
		first = first.next;
		
		return temp;
	}
	
	public Link deleteLast(){
		  Link temp = last;
		  if(first.next == null)
			  first = null;
		  else 
			  last.previous.next = null;
		  last = last.previous;
		  
		  return temp;
	}
	
	//查到指定的元素后面
	public boolean insertAfter(long key, long dd){  //key 是查找的对象；dd是插入的对象
		Link current = first;
		while(current.dData != key){
			current = current.next;
			
			if(current == null)  //如果找到最后都没找到，就返回false  
				return false;  //退出方法，表示插入失败
		}
		
		Link newLink = new Link(dd);
		
		if(current == last){  //找到最后了
			newLink.next = null;
			last = newLink;
		}else{  //不是最后一个
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		
		newLink.previous = current;
		current.next = newLink;
		
		return true;
	}
	
	public Link deletekey(long key){
		Link current = first;
		while(current.dData != key){
			current = current.next;
			if(current == null)  //退出方法，没有找到 
				return null;
		}
		
		if(current == first)
			first = current.next;
		else
			current.previous.next = current.next;
		
		if(current == last)
			last = current.previous;
		else
			current.next.previous = current.previous;
		
		return current;
	}
	
	public void displayForward(){
		 System.out.print("List(first-->last): ");
		 Link current = first;
		 while(current != null){
			 current.displayLink();
			 current = current.next;
		 }
		 
		 System.out.println();
	}
	
	public void displayBackward(){
		System.out.print("List(last-->first):");
		Link current = last;
		while(current != null){
			current.displayLink();
			current = current.previous;
		}
		
		System.out.println();
	}
}
