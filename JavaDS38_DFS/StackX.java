
public class StackX {
	private final int SIZE = 20; //定义图的顶点个数是 20
	private int[] st; //底层实现图的结构，就是该数组
	private int top;
	
	public StackX(){
		st = new int[SIZE];
		top = -1;
	}
	
	public void push(int j){
		st[++top] = j;
	}
	
	public int pop(){
		return st[top--];
	}
	
	public int peek(){
		return st[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
}
