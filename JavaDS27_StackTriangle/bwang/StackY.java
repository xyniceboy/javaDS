package bwang;
//��ջ �� ��
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
	
	//�鿴
	public int peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
}
