//�����������Ҳ���ǶԺ�׺���ʽ���м��㣬�õ������  

public class ParsePost {
	private StackY theStack;
	private String input;

	// ��input��¼ ����ĺ�׺���ʽ
	public ParsePost(String s) {
		input = s;
	}

	// doParse�ǶԺ�׺���ʽ��һ�����㣬�ҽ������int���ͽ���ŵ�
	public int doParse() {
		theStack = new StackY(20);
		char ch;
		int j; // ����ѭ���ı���
		int num1, num2, interAns; // num1,num2
									// �Ǵ�ջ���浯�����Ĳ������ŵ������������С�interAns����������������Ľ��

//		System.out.println("input: " + input);
		for (j = 0; j < input.length(); j++) {
//			System.out.println("input: " + input);
			
			ch = input.charAt(j);

//			System.out.println("ch: " + ch);
//			System.out.println("ok");
			
			// �õ���׺���ʽ������ַ�������ջ��������
			theStack.displayStack(" " + ch + " ");
			
			
			// ��ÿһ���������������ַ����õ�
			if (ch >= '0' && ch <= '9') // ˵����ǰ�õ�����һ�����������Ͱ�����������ŵ�ջ����
				theStack.push((int)(ch - '0')); // ch-'0'�õ�һ�����֣�����(int)ת��
			else { // ����������֣���һ�����������û�����ţ���Ϊ��׺���ʽ������ȥ����
				num2 = theStack.pop(); // ����ջ�
//				System.out.println("num2: " + num2);
				num1 = theStack.pop(); // ����ջ�ζ�
				switch (ch) {
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				case '/':
					interAns = num1 / num2;
					break;
				default:
					interAns = 0;
//					break;
				}
				theStack.push(interAns); // ��interAns�Ż�ջȥ��
			}
		} // һ��һ�����������������ˡ�

		// ��������֮�󣬰ѽ��������
		interAns = theStack.pop();

		return interAns;
	}
}
