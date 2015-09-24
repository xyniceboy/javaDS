//负责解析处理，也就是对后缀表达式进行计算，得到结果。  

public class ParsePost {
	private StackY theStack;
	private String input;

	// 用input记录 传输的后缀表达式
	public ParsePost(String s) {
		input = s;
	}

	// doParse是对后缀表达式的一个计算，且将计算的int类型结果放到
	public int doParse() {
		theStack = new StackY(20);
		char ch;
		int j; // 用来循环的变量
		int num1, num2, interAns; // num1,num2
									// 是从栈里面弹出来的操作数放到这两个变量中。interAns是两个操作数运算的结果

//		System.out.println("input: " + input);
		for (j = 0; j < input.length(); j++) {
//			System.out.println("input: " + input);
			
			ch = input.charAt(j);

//			System.out.println("ch: " + ch);
//			System.out.println("ok");
			
			// 拿到后缀表达式里面的字符，看看栈里面的情况
			theStack.displayStack(" " + ch + " ");
			
			
			// 把每一个操作数都当做字符来用的
			if (ch >= '0' && ch <= '9') // 说明当前拿到的是一个操作数，就把这个操作数放到栈里面
				theStack.push((int)(ch - '0')); // ch-'0'得到一个数字，且用(int)转型
			else { // 如果不是数字，那一定是运算符。没有括号，因为后缀表达式把括号去掉了
				num2 = theStack.pop(); // 弹出栈最顶
//				System.out.println("num2: " + num2);
				num1 = theStack.pop(); // 弹出栈次顶
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
				theStack.push(interAns); // 把interAns放回栈去了
			}
		} // 一步一步，就这样计算完了。

		// 计算完了之后，把结果弹出来
		interAns = theStack.pop();

		return interAns;
	}
}
