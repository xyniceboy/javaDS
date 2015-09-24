/*
 * 想通过利用栈 (stackX) 将中缀表达式( A+B*C )，表示成后缀表达式( ABC*+ )。
 * 利用栈进行控制和优先级别的检查
 */
public class InToPost {
	private StackX theStack;
	private String input; // 中缀表达式
//	private String output; // 后缀表达式  
	private String output = ""; //如果不给初始化一个空串，测试结果会多余一个 null.故，初始化为 ” "

	// 对传入的中缀表达式，进行压栈等操作
	public InToPost(String in) {
		input = in;
		int stackSize = input.length();
		theStack = new StackX(stackSize);
	}

	// 从栈得到后缀表达式
	public String doTrans() {
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j); // 一个一个的取前缀表达式的字符，并用ch记录
			theStack.displayStack("For " + ch + " ");

			// 对得到的 ch 判断，如果是运算符(+-*/)就压栈，且标明优先级；如果是数字直接输出
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
				theStack.push(ch); // ( 无需任何操作，直接入栈
				break;
			case ')':
				gotParen(ch); // 如果是),弹出直到(的，前面的所有内容
				break;
			default:
				output = output + ch; // 直接向后缀表达式追加
				break;
			}
		} // for 结束
		
		//for结束，有可能栈里面的符号没有弹出来，所以需要把栈里面的字符一个一个弹出，放入输出字符串 output 变量里面
		while(!theStack.isEmpty()){
			theStack.displayStack("While ");
			output = output + theStack.pop();
		}
		//至此，把栈里的所有操作符都放到输出字符串里了
		
		//返回的字符串就是最终的 后缀表达式
		theStack.displayStack("End ");
		return output;
	}

	//+-*/往栈里面放的过程
	public void gotOper(char opThis, int prec1) {
		//循环查看
		while(!theStack.isEmpty()){
			char opTop = theStack.pop();
			
			if(opTop == '('){
				theStack.push(opTop);
				break;
			}else {
				// 对获得的 运算符  的优先级进行 内部归类定位： 1、2
				int prec2;
				if(opTop == '+' || opTop == '-') 
					prec2 = 1;
				else 
					prec2 = 2;  // 运算符为： * /
				
				//如果内部归类定位的优先级 低于(<) 传入的优先级(per1),则把栈顶弹出来的 opTop 又放回去(压栈)
				if(prec2 < prec1){
					theStack.push(opTop);
					break;
				}else  //弹出来的级别高，那就把弹出来的操作符放到后缀表达式中。
					output = output + opTop;
			}
		}
		theStack.push(opThis);  // ?? 这个真的很
	}

	public void gotParen(char ch) {
		while(!theStack.isEmpty()){
			char chx = theStack.pop();
			
			if(chx == '(')   //循环到 ( 为止(循环到（退出循环)。
				break;
			else 
				output = output + chx;
		}
	}
}
