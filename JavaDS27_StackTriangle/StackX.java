//��ջ �� ��
public class StackX {
	private int maxSize;
	private Parame[] stackArray;
	private int top;
	
	public StackX(int s){
		maxSize = s;
		stackArray = new Parame[maxSize];
		top = -1;
	}
	
	public void push(Parame p){
		stackArray[++top] = p;
	}
	
	public Parame pop(){
		return stackArray[top--];
	}
	
	//�鿴
	public Parame peek(){
		return stackArray[top];
	}
}
