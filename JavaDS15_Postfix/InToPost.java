/*
 * ��ͨ������ջ (stackX) ����׺���ʽ( A+B*C )����ʾ�ɺ�׺���ʽ( ABC*+ )��
 * ����ջ���п��ƺ����ȼ���ļ��
 */
public class InToPost {
	private StackX theStack;
	private String input; // ��׺���ʽ
//	private String output; // ��׺���ʽ  
	private String output = ""; //���������ʼ��һ���մ������Խ�������һ�� null.�ʣ���ʼ��Ϊ �� "

	// �Դ������׺���ʽ������ѹջ�Ȳ���
	public InToPost(String in) {
		input = in;
		int stackSize = input.length();
		theStack = new StackX(stackSize);
	}

	// ��ջ�õ���׺���ʽ
	public String doTrans() {
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j); // һ��һ����ȡǰ׺���ʽ���ַ�������ch��¼
			theStack.displayStack("For " + ch + " ");

			// �Եõ��� ch �жϣ�����������(+-*/)��ѹջ���ұ������ȼ������������ֱ�����
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				theStack.push(ch); // ( �����κβ�����ֱ����ջ
				break;
			case ')':
				gotParen(ch); // �����),����ֱ��(�ģ�ǰ�����������
				break;
			default:
				output = output + ch; // ֱ�����׺���ʽ׷��
				break;
			}
		} // for ����
		
		//for�������п���ջ����ķ���û�е�������������Ҫ��ջ������ַ�һ��һ����������������ַ��� output ��������
		while(!theStack.isEmpty()){
			theStack.displayStack("While ");
			output = output + theStack.pop();
		}
		//���ˣ���ջ������в��������ŵ�����ַ�������
		
		//���ص��ַ����������յ� ��׺���ʽ
		theStack.displayStack("End ");
		return output;
	}

	//+-*/��ջ����ŵĹ���
	public void gotOper(char opThis, int prec1) {
		//ѭ���鿴
		while(!theStack.isEmpty()){
			char opTop = theStack.pop();
			
			if(opTop == '('){
				theStack.push(opTop);
				break;
			}else {
				// �Ի�õ� �����  �����ȼ����� �ڲ����ඨλ�� 1��2
				int prec2;
				if(opTop == '+' || opTop == '-') 
					prec2 = 1;
				else 
					prec2 = 2;  // �����Ϊ�� * /
				
				//����ڲ����ඨλ�����ȼ� ����(<) ��������ȼ�(per1),���ջ���������� opTop �ַŻ�ȥ(ѹջ)
				if(prec2 < prec1){
					theStack.push(opTop);
					break;
				}else  //�������ļ���ߣ��ǾͰѵ������Ĳ������ŵ���׺���ʽ�С�
					output = output + opTop;
			}
		}
		theStack.push(opThis);  // ?? �����ĺ�
	}

	public void gotParen(char ch) {
		while(!theStack.isEmpty()){
			char chx = theStack.pop();
			
			if(chx == '(')   //ѭ���� ( Ϊֹ(ѭ�������˳�ѭ��)��
				break;
			else 
				output = output + chx;
		}
	}
}
