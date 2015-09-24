
import java.io.*;
public class InfixApp {
	public static void main(String[] args) throws IOException{
		String input, output;
		while(true){
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString();  //将拿到的字符串，即所谓的中缀表达式
			
			if(input.equals(" ")) break;  //如果是空，则退出循环
			
			//如果不为空，就需要准备一个处理 由中缀表达式变 后缀表达式的方法
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


//测试： A*(B+C)-D/(E+F)
//查看转换后的后缀表达式 ?????