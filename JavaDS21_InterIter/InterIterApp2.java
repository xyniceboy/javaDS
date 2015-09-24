
public class InterIterApp2 {
	public static void main(String[] args) {
		LinkList theList = new LinkList();
		ListIterator iter1 = theList.getIterator();
		iter1.insertAfter(21);
		iter1.insertAfter(40);
		iter1.insertAfter(60);
		iter1.insertAfter(45);
		iter1.insertAfter(3);
//		iter1.insertAfter(6);
//		iter1.insertAfter(9);
		theList.displayList();
		
		//测试删除当前节点的方法
		iter1.reset();  //将指针移到链表的第一个节点
		Link aLink = iter1.getCurrent(); //定义指针aLink指向 当前节点
		if(aLink.dData%3 == 0)  //// 如果当前节点的数值是 3 的倍数，则把当前节点删除
			iter1.deleteCurrent();
		
		//遍历整个链表，看看是否有 3 的倍数
/*		while(!iter1.atEnd()){
			iter1.nextLink();
			aLink = iter1.getCurrent();
			if(aLink.dData%3 == 0)
				iter1.deleteCurrent();
		}*/
		
		do{
			iter1.nextLink();
			aLink = iter1.getCurrent();
			if(aLink.dData%3 == 0)
				iter1.deleteCurrent();
		}while(!iter1.atEnd());

		theList.displayList();
	}
}
/*
21 40 60 45 3 6 9 
40 6 

21 40 60 45 3 6 
40 45 6 

21 40 60 45 3 
40 

21 40 60 45 
40 45 

21 40 60 
40 
 * */
