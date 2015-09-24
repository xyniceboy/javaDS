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

	// 因为是在静态主入口方法里面调用，所以这个被调用的方法也需要定义成静态的
	public static String getSting() throws IOException {
		// 需要一个输入流读取器(InputStreamReader)包装一下从控制台接收(System.in)的内容
		InputStreamReader isr = new InputStreamReader(System.in);

		// 因为输入流读取器不好用，我们有必要用带缓存的读取器把输入流读取器获得的内容再包装一下(二次包装)。
		BufferedReader br = new BufferedReader(isr);

		// 用带缓存的 readline 方法，一次读入从控制台输入的字符串
		String s = br.readLine();

		return s;
	}
}
