package bwang;

// 用链表实现队列，要比数组容易的多

public class LinkQueueApp {
	public static void main(String[] args) {
		LinkQueue theQueue = new LinkQueue();
		
		//测 添加
		theQueue.insert(20);
		theQueue.insert(40);
		theQueue.displayQueue();
		theQueue.insert(60);
		theQueue.insert(80);
		theQueue.displayQueue();
		
		//测 删除
		theQueue.remove();
		theQueue.remove();
		theQueue.displayQueue();
	}
}
