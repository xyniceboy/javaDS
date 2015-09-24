//StackY �����������

public class StackY {
	private int[] stackArray;  //��ʼ��һ������
	private int maxSize;  //ջ��С
	private int top;  //topָ��
	
	//��ʼ��ջ
	public StackY(int s){
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	//ѹջ
	public void push(int j){
		stackArray[++top] = j;
	}
	
	//��ջ
	public int pop(){
//		System.out.println(top);   // -1
//		System.out.println(stackArray[top--]);
		return stackArray[top--];
	}
	
	//�鿴
	public int peek(){
		return stackArray[top]; //�鿴ֱ���ǵ�ǰtopָ���Ԫ��
	}
	
	//���ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return top == -1;
	}
	
	//���ջ�Ƿ���
	public boolean isFull(){
		return top == maxSize-1;
	}
	
	//����ջ����Ԫ�صĸ���
	public int size(){
		return top+1;
	}
	
	//�鿴ĳ��λ��(����ʹ��index�������ѱ���)��Ԫ��
	public int peekN(int n){
		return stackArray[n];
	}
	
	//��ӡջ�����Ԫ��
	public void displayStack(String s){
		//System.out.println(s);
		
		System.out.print("Stack(bottoms-->tops): ");
		//��Ϊջ���ص��ǣ�top ָ�����Ž�ȥ�ġ������ʵ�ִ����ȷŽ�ȥ�Ĳ鿴������ͨ��peekN����
		for(int j=0; j<size(); j++) {
//			System.out.println("peekN(0): " + peekN(0));
			System.out.print(peekN(j) + " ");
		}
		//����
		System.out.println();
	}
}
