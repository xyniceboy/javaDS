import java.io.*;

//��ParsePost���в��ԣ� �����׺���ʽ������������ȷ���

public class PostfixApp {
	public static void main(String[] args) throws IOException{
		String input; 
		int output;   //
		InToPost inobj;
		while(true){
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString();
			if(input.equals(""))  break;
			
			//���ǿգ�˵���Ǹ���׺���ʽ���Ǿ���Ҫ����׺���ʽת���ɺ�׺���ʽ
			inobj = new InToPost(input); 
			input = inobj.doTrans();  //��׺���ʽ���׺���ʽ������ �� input ��¼��׺���ʽ
			System.out.println("ת����ĺ�׺���ʽ�� "+ input);
			
			//��������(����)�Ķ���
			ParsePost theTrans = new ParsePost(input);
			output = theTrans.doParse();  //�����doParse �������
			System.out.println("Evaluate to: " + output);
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}

//���ԣ�  3+4*(6-2)
//��׺���ʽ �ļ�������  ?????

