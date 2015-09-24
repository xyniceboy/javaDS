import java.io.*;

public class ReverseApp {
	public static void main(String[] agrs) throws IOException{ 
		//������Ĺ��̿��ܻ���IO�쳣������Ҫ�׳��쳣���Լ����봦���Ϳ����Ӹ�(throws) IO �쳣��
		String input, output;
		
		while(true){
			System.out.println("Enter a String: ");
			System.out.flush();
			
			input = getSting(); //ʵ���Ͼ��ǿ���̨������õ���������
			if(input.equals(""))  break; //�ж����Ϊ�գ���ֹѭ��
			
			//new һ��ʵ�������䷴ת
			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev();
			
			//����ת��Ľ����һ�����
			System.out.println("Reversed: " + output);
			
			//��Ϊû�жԱ�����д����������ƺ��֣��л����񹲺͹��������ܷ�ת
			//��Ҫʹ��StringBuilder���з�ת���������´���
			StringBuilder sb = new StringBuilder("�л����񹲺͹�");
			System.out.println("StringBuilder reverse: " + sb.reverse());
		}
		
	} 
	
	//��Ϊ���ھ�̬����ڷ���������ã�������������õķ���Ҳ��Ҫ����ɾ�̬��
	public static String getSting() throws IOException{
		//��Ҫһ����������ȡ��(InputStreamReader)��װһ�´ӿ���̨����(System.in)������
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//��Ϊ��������ȡ�������ã������б�Ҫ�ô�����Ķ�ȡ������������ȡ����õ������ٰ�װһ��(���ΰ�װ)��
		BufferedReader br = new BufferedReader(isr);
		
		//�ô������ readline ������һ�ζ���ӿ���̨������ַ���
		String s = br.readLine();
		
		return s;
	}
}
