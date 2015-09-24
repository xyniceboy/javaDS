//StackY 用来存操作符

public class StackY {
	private int[] stackArray;  //初始化一个数组
	private int maxSize;  //栈大小
	private int top;  //top指针
	
	//初始化栈
	public StackY(int s){
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	//压栈
	public void push(int j){
		stackArray[++top] = j;
	}
	
	//出栈
	public int pop(){
//		System.out.println(top);   // -1
//		System.out.println(stackArray[top--]);
		return stackArray[top--];
	}
	
	//查看
	public int peek(){
		return stackArray[top]; //查看直接是当前top指向的元素
	}
	
	//检查栈是否为空
	public boolean isEmpty(){
		return top == -1;
	}
	
	//检查栈是否满
	public boolean isFull(){
		return top == maxSize-1;
	}
	
	//返回栈里面元素的个数
	public int size(){
		return top+1;
	}
	
	//查看某个位置(不能使用index变量，已被用)的元素
	public int peekN(int n){
		return stackArray[n];
	}
	
	//打印栈里面的元素
	public void displayStack(String s){
		//System.out.println(s);
		
		System.out.print("Stack(bottoms-->tops): ");
		//因为栈的特点是，top 指向最后放进去的。如果想实现从最先放进去的查看，可以通过peekN方法
		for(int j=0; j<size(); j++) {
//			System.out.println("peekN(0): " + peekN(0));
			System.out.print(peekN(j) + " ");
		}
		//换行
		System.out.println();
	}
}
