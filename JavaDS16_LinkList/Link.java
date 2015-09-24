
/*
 * 实现单链表,Link类实现一个单节点
 */
public class Link {
	public int iData;
	public double dData;
	public Link next;  //记录下一个节点的应用
	
	public Link(int id, double dd){
		iData = id;
		dData = dd;
	}
	
	public void displayLink(){
		System.out.print("{" + iData + "," + dData + "} ");
	}
}
