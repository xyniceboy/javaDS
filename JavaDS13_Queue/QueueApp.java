import java.io.*;
public class QueueApp {
	public static void main(String[] args) throws IOException{
		Queue theQueue = new Queue(5); //��Ϊ�ڲ��õ����ݽṹ��������
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		System.out.println("ɾ���� "+ theQueue.remove());
		System.out.println("ɾ���� "+ theQueue.remove());
		System.out.println("ɾ���� "+ theQueue.remove());
//		System.out.println("ɾ���� "+ theQueue.remove());
//		System.out.println("ʣ�ࣺ " + theQueue.peekFron());
		theQueue.insert(50);
		theQueue.insert(60);
		theQueue.insert(70);
//		theQueue.insert(80);
		
		while(!theQueue.isEmpty()){
			long n = theQueue.remove();
			System.out.println("ɾ���� "+ n);
		}
	}
}
