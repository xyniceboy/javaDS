package bwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StackTriangle2App {
	static int theNumber;
	static int theAnswer;
	static StackY theStack;
	
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a number: ");
		theNumber = getInt();
		stackTriangle();
		System.out.print("Triangle = " + theAnswer);  //�����ǵķ������аѼ���Ľ��д�뵽���յĽ����
	}
	
	public static void stackTriangle(){
		theStack = new StackY(100);
		theAnswer = 0;
		
		//��ÿ��ֵ����ջ��
		while(theNumber > 0){
			theStack.push(theNumber);
			theNumber--;
		}
		
		//��ջ��ȡ����ֵ�������ۼ�
		while(!theStack.isEmpty()){
			int newN = theStack.pop();
			theAnswer += newN;
		}
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
