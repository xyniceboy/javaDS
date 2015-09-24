import java.io.*;
public class QueueApp {
	public static void main(String[] args) throws IOException{
		Queue theQueue = new Queue(5); //因为内层用的数据结构还是数组
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		System.out.println("删除： "+ theQueue.remove());
		System.out.println("删除： "+ theQueue.remove());
		System.out.println("删除： "+ theQueue.remove());
//		System.out.println("删除： "+ theQueue.remove());
//		System.out.println("剩余： " + theQueue.peekFron());
		theQueue.insert(50);
		theQueue.insert(60);
		theQueue.insert(70);
//		theQueue.insert(80);
		
		while(!theQueue.isEmpty()){
			long n = theQueue.remove();
			System.out.println("删除： "+ n);
		}
	}
}
