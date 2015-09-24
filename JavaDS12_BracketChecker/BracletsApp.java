import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracletsApp {
	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.println("Enter string containing delimiters: ");
			System.out.flush();
			input = getSting();
			if (input.equals(""))
				break;
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check();
		}
	}

	// ��Ϊ���ھ�̬����ڷ���������ã�������������õķ���Ҳ��Ҫ����ɾ�̬��
	public static String getSting() throws IOException {
		// ��Ҫһ����������ȡ��(InputStreamReader)��װһ�´ӿ���̨����(System.in)������
		InputStreamReader isr = new InputStreamReader(System.in);

		// ��Ϊ��������ȡ�������ã������б�Ҫ�ô�����Ķ�ȡ������������ȡ����õ������ٰ�װһ��(���ΰ�װ)��
		BufferedReader br = new BufferedReader(isr);

		// �ô������ readline ������һ�ζ���ӿ���̨������ַ���
		String s = br.readLine();

		return s;
	}
}
