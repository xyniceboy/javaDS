package bwang;

public class Queue {
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;
	
	public Queue(){
		queArray = new int[SIZE];
		front = 0;  //队头
		rear = -1;  //队尾
	}
	
	public void insert(int j){
		if(rear == SIZE-1)
			rear = -1;
		queArray[++rear] = j;
	}
	
	//移动
	public int remove(){
		int temp = queArray[front++]; 
		if(front == SIZE) //满了
			front = 0;
		return temp;
	}
	
	public boolean isEmpty(){
		return (rear+1==front || front+SIZE-1==rear);  
	}
	
}	
