
public class SortedList {
	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	public void insert(long key){
		Link newLiink = new Link(key);
		Link previous = null;  //用来记录找到的前一个节点
		Link current = first; // 用来遍历的指针
		
		//查找操作
		while(current!=null && key > current.dData){
			previous = current;
			current = current.next;
		} //结束后，要么找到了，要么找到头了
		
		//根据查找结果，进行插入操作
		//1,前面拉我
		if(previous == null)  //没有动还是null,那么newLink就是第一个
			first = newLiink;  
		else 
			previous.next = newLiink;   //
		
		//2，我拉后面
		newLiink.next = current;
	}
	
	//插入的时候，需要有序，下面删除，粗糙的做了从头删
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
