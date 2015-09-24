public class BracketChecker {
	private String input;

	public BracketChecker(String in) {
		input = in;
	}

	public void check() {
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);

		// a{b(c[d]e)f} �����֣������ַ�ջ����Ӧ���ǣ�{ ( [ ������ ]�͸�ջ���浯�����Ľ��бȽϣ�
		// �����ͬ����ƥ�䣻�����ͬ����ƥ�䡣
		// �������ջ�Ĺ��������ŵļ��
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j); // һ��һ������ջ�����
			switch (ch) { // ��ȡ�������ַ���һһ�ж�
			case '{':
			case '(':
			case '[':
				theStack.push(ch); // �����ŷ���ջ��
				break; // break ֮�󣬾���ѭ����һ�Σ���������һ���ַ�
			case '}':
			case ')':
			case ']':
				if (!theStack.isEmpty()) { // �жϣ����ջ�ﲻΪ��
					char chx = theStack.pop(); // ��ջ�ﵯ�������� chx ��¼
					if ((ch == '}' && chx != '{') || (ch == ')' && chx != '(')
							|| (ch == ']' && chx != '[')) // ��ǰ�ĺ͵����Ĳ�ƥ��
						System.out.println("Log: [error] " + ch + " at " + j);
				} else { // ջ������ˣ����ǻ������˱պ����ţ����Ի�����Ҫ������Ϣ
					System.out.println("Log: [error] " + ch + " at " + j);
				}
				break;
			default:
				break;
			}
		}

		// a{b(c[d]e)f ��������
		if (!theStack.isEmpty())
			System.out.println("Log: [error] missing right delimiter.");
	}
}
