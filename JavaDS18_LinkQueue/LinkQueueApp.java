package bwang;

// ������ʵ�ֶ��У�Ҫ���������׵Ķ�

public class LinkQueueApp {
	public static void main(String[] args) {
		LinkQueue theQueue = new LinkQueue();
		
		//�� ���
		theQueue.insert(20);
		theQueue.insert(40);
		theQueue.displayQueue();
		theQueue.insert(60);
		theQueue.insert(80);
		theQueue.displayQueue();
		
		//�� ɾ��
		theQueue.remove();
		theQueue.remove();
		theQueue.displayQueue();
	}
}
