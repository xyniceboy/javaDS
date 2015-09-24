
public class StackX {
	private char[] stackArray;  //初始化一个数组
	private int maxSize;  //栈大小
	private int top;  //top指针
	
	//初始化栈
	public StackX(int s){
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	//压栈
	public void push(char j){
		stackArray[++top] = j;
	}
	
	//出栈
	public char pop(){
		return stackArray[top--];
	}
	
	//查看
	public char peek(){
		return stackArray[top]; //查看直接是当前top指向的元素
	}
	
	//检查栈是否为空
	public boolean isEmpty(){
		return top == -1;
	}
	
	//返回栈里面元素的个数
	public int size(){
		return top+1;
	}
	
	//查看某个位置(不能使用index变量，已被用)的元素
	public char peekN(int n){
		return stackArray[n];
	}
	
	//打印栈里面的元素
	public void displayStack(String s){
//		System.out.print(s);
		System.out.print("Stack(bottom-->top): ");
		
		//因为栈的特点是，top 指向最后放进去的。如果想实现从最先放进去的查看，可以通过peekN方法
		for(int j=0; j<size(); j++)
			System.out.print(peekN(j) + " ");
		
		//换行
		System.out.println();
	}
}