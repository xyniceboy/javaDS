import java.io.*;

//对ParsePost进行测试： 传入后缀表达式，看计算结果正确与否。

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
			
			//不是空，说明是个中缀表达式。那就需要将中缀表达式转换成后缀表达式
			inobj = new InToPost(input); 
			input = inobj.doTrans();  //中缀表达式变后缀表达式。返回 用 input 记录后缀表达式
			System.out.println("转换后的后缀表达式： "+ input);
			
			//创建解析(计算)的对象
			ParsePost theTrans = new ParsePost(input);
			output = theTrans.doParse();  //对象的doParse 负责计算
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

//测试：  3+4*(6-2)
//后缀表达式 的计算结果：  ?????

