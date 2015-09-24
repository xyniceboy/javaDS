package bwang;

//将无需数组元素，放到有序链表中排好序，再放回元数组。此时的原数组成了有序数组

public class ListInsertionSortApp {
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArray = new Link[size];
		
		for(int j = 0; j < size; j++){
			int n = (int) (java.lang.Math.random()*99);  //1, 产生0~99之间的数字；2, 因为是double，故需要转换。
			
			//产生一个新的有数据的链节点········································
			Link newLink = new Link(n);
			linkArray[j] = newLink;
		} //循环结束，就有10个随机的连节点了
		
		System.out.print("Unsorted array: ");
		for(int j = 0; j< size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println();  //至此，把无序的数组就打印出来了
		
		//将无序的链表，放到有序链表
		SortedList theSortedList = new SortedList(linkArray);  
		theSortedList.displayList();
		
		//将有序数组的元素，一个一个的返回原链表 linkArray
		System.out.print("Sorted Array: ");
		for(int j=0; j < size; j++){
			linkArray[j] = theSortedList.remove();  //移除的永远都是最小的。
		} //存放到原数组
		
		for(int j = 0; j < size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println();  //循环打印元数组(linkArray)元素
		
	}
}
