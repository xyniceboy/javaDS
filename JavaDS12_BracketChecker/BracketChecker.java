public class BracketChecker {
	private String input;

	public BracketChecker(String in) {
		input = in;
	}

	public void check() {
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);

		// a{b(c[d]e)f} 像这种，不管字符栈里存的应该是：{ ( [ ，遇到 ]就跟栈里面弹出来的进行比较：
		// 如果相同，算匹配；如果不同，不匹配。
		// 下面就用栈的功能做符号的检查
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j); // 一个一个的往栈里面放
			switch (ch) { // 对取出来的字符，一一判断
			case '{':
			case '(':
			case '[':
				theStack.push(ch); // 将括号放入栈中
				break; // break 之后，就是循环下一次，继续拿下一个字符
			case '}':
			case ')':
			case ']':
				if (!theStack.isEmpty()) { // 判断，如果栈里不为空
					char chx = theStack.pop(); // 从栈里弹出来，用 chx 记录
					if ((ch == '}' && chx != '{') || (ch == ')' && chx != '(')
							|| (ch == ']' && chx != '[')) // 当前的和弹出的不匹配
						System.out.println("Log: [error] " + ch + " at " + j);
				} else { // 栈里面空了，但是还读到了闭合括号，所以还是需要错误信息
					System.out.println("Log: [error] " + ch + " at " + j);
				}
				break;
			default:
				break;
			}
		}

		// a{b(c[d]e)f 类似这种
		if (!theStack.isEmpty())
			System.out.println("Log: [error] missing right delimiter.");
	}
}
