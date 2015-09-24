
public class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;  //ͷָ��
	private int rear;  //βָ��
	private int nItems;
	
	public Queue(int s){
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long j){
		if(rear == maxSize-1) rear = -1;
		queArray[++rear] = j;
		nItems++;
	}
	
	public long remove(){
		long temp = queArray[front++];
		if(front == maxSize) front = 0;
		nItems--;
		return temp;
	}
	
	//�����Ƕ����򷵻�һ��Ӧ�ã������һ���������ͣ��򷵻�һ������
	public long peekFron(){  //�鿴
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == maxSize;
	}
	
	public int size(){
		return nItems;
	}
}
