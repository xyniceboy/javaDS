package bwang;
//用栈 存 数
public class StackY {
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public StackY(int s){
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	public void push(int p){
		stackArray[++top] = p;
	}
	
	public int pop(){
		return stackArray[top--];
	}
	
	//查看
	public int peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
}
