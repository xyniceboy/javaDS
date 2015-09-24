
public class StackX {
	private long[] stackArray;
	private int maxSize;
	private int top;
	
	public StackX(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;  //�տ�ʼtop��-1��ֻ���ڽ�Ҫ����һ����ʱ��top�� ++
	}
	
	//�������
	public void push(long j){
		stackArray[++top] = j;
	}
	
	//�鿴��ɾ��
	public long pop(){
		return stackArray[top--];  //��Ϊ���鶼��˽�еģ�������Ҫ��ôһ�������صķ���
	}
	
	//�鿴
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
