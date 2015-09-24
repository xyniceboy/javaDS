
public class Reverser {
	private String input;  //��Ŵ��������ȴ�������ַ���
	private String output = ""; //��ž������������ַ���,��ʼ��һ���մ�
	
	public Reverser(String in){
		input = in;
	}
	
	public String doRev(){
		int stackSize = input.length();  //��ô������ַ����ĳ���
		StackX theStack = new StackX(stackSize);  
		//���ַ�һ��һ������ջ���� input ������
		for(int j=0; j<input.length(); j++){
			char ch = input.charAt(j); //���ַ�����һ��һ���������ַ�
			theStack.push(ch);  //��ȡ�������ַ��Rջ
		}
		
		//���ַ�һ��һ���ĵ����������� output ��
		while(!theStack.isEmpty()){
			char c = theStack.pop(); //��ջ������Ԫ����c��ʱ�洢
			output  = output + c;  //׷�ӵ�output����
		}
		return output;
	}
}
