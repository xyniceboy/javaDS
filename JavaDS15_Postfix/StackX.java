
public class StackX {
	private char[] stackArray;  //��ʼ��һ������
	private int maxSize;  //ջ��С
	private int top;  //topָ��
	
	//��ʼ��ջ
	public StackX(int s){
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	//ѹջ
	public void push(char j){
		stackArray[++top] = j;
	}
	
	//��ջ
	public char pop(){
		return stackArray[top--];
	}
	
	//�鿴
	public char peek(){
		return stackArray[top]; //�鿴ֱ���ǵ�ǰtopָ���Ԫ��
	}
	
	//���ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return top == -1;
	}
	
	//����ջ����Ԫ�صĸ���
	public int size(){
		return top+1;
	}
	
	//�鿴ĳ��λ��(����ʹ��index�������ѱ���)��Ԫ��
	public char peekN(int n){
		return stackArray[n];
	}
	
	//��ӡջ�����Ԫ��
	public void displayStack(String s){
//		System.out.print(s);
		System.out.print("Stack(bottom-->top): ");
		
		//��Ϊջ���ص��ǣ�top ָ�����Ž�ȥ�ġ������ʵ�ִ����ȷŽ�ȥ�Ĳ鿴������ͨ��peekN����
		for(int j=0; j<size(); j++)
			System.out.print(peekN(j) + " ");
		
		//����
		System.out.println();
	}
}