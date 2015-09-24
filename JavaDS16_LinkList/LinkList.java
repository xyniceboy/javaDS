
// LinkList表示链表真正的 class
public class LinkList {
	Link first; //记录第一个连接点
	
	//从链表头插入节点
	public void insertFirst(int id, double dd){
		Link newLink = new Link(id, dd);  //创建一个新链节点
		newLink.next = first;
		first = newLink;  //first永远指向 第一个节点
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public Link deleteFisrt(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	// 查找iData时候在链中
	public Link find(int key){
		Link current = first;
		while(current.iData != key){  //遍历查找
			if(current.next == null)
				return null;
			else 
				current = current.next;
		}
		return current;   //返回连接点
	}
	
	//删除查找到的节点.这个比仅能删除头结点的 deleteFisrt 功能要强大一点点
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
		
		//找到，如果是第一个
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		
		//返回删除数据项
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
