
public class StackX {
	private long[] stackArray;
	private int maxSize;
	private int top;
	
	public StackX(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;  //刚开始top是-1，只有在将要放入一个数时，top才 ++
	}
	
	//添加数据
	public void push(long j){
		stackArray[++top] = j;
	}
	
	//查看并删除
	public long pop(){
		return stackArray[top--];  //因为数组都是私有的，所以需要这么一个带返回的方法
	}
	
	//查看
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == maxSize-1;
	}
}
