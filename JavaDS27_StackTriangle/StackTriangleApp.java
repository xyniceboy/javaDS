import java.io.*;
public class StackTriangleApp {
	static int theNumber;
	static int theAnswer;
	static StackX theStack;
	static int codePart;
	static Parame theseParame;
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number: ");
		theNumber = getInt();
		recTriangle();
		System.out.println("Triangle = " + theAnswer);
	}
	
	public static void recTriangle(){
		theStack = new StackX(100);  //��Ҫ��ջ�����ݹ飬�Ǿ��ȴ���һ��ջ
		codePart = 1;  //��ʼ������������
		while(step() == false) ; //step() ����true����������� ����false������ͣ�ļ���
	}
	
	public static boolean step(){
		switch(codePart){
		case 1:  //��ʼ��������������
			theseParame = new Parame(theNumber, 6); //6��ʾ��ǰ������ջ����ײ��һ��
			theStack.push(theseParame); // ����ѹջ
			codePart = 2; //��ʾ��ȡ��һ��
			break;
		case 2: //��ȡ��һ����ֵ
			theseParame = theStack.peek();
			
			//�������ͷ�ˣ�ȫ�����
			if(theseParame.n == 1) {  //ȫ������������ջ�У�Ҫ��������
				theAnswer = 1;
				codePart = 5; //ȡջ������
			}else
				//����û�ж���ͷ��������ջ�����
				codePart = 3;  //����ǰ��ֵ����ջ��
			break;
		case 3:  //����ǰ��ֵ����ջ��
			Parame newParame = new Parame(theseParame.n-1, 4);  //4 ��ʾ��Ҫ��ͼ���
			theStack.push(newParame);
			codePart = 2;
			break;
		case 4: //��ͼ�����(�ۼ�)
			theseParame = theStack.peek();
			theAnswer = theAnswer + theseParame.n;
			codePart = 5; //�ٴ�ջ��ȡ��һ��
			break;
		case 5: //�ٴ�ջ��ȡ��һ��
			theseParame = theStack.peek();
			codePart = theseParame.returnAddress;
			theStack.pop();
			break;
		case 6:    //6��ʾ��ǰ������ջ����ײ��һ��
			return true;
		}
		return false;
	}
	
	
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
//		String s = br.readLine();
//		return s;
		return br.readLine();
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}
