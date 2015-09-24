
import java.io.*;
public class InfixApp {
	public static void main(String[] args) throws IOException{
		String input, output;
		while(true){
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString();  //���õ����ַ���������ν����׺���ʽ
			
			if(input.equals(" ")) break;  //����ǿգ����˳�ѭ��
			
			//�����Ϊ�գ�����Ҫ׼��һ������ ����׺���ʽ�� ��׺���ʽ�ķ���
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans();
			System.out.print("Postfix is: " + output + '\n');
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}


//���ԣ� A*(B+C)-D/(E+F)
//�鿴ת����ĺ�׺���ʽ ?????