import java.io.*;

public class ReverseApp {
	public static void main(String[] agrs) throws IOException{ 
		//在输出的过程可能会有IO异常，就需要抛出异常。自己不想处理，就可以扔给(throws) IO 异常。
		String input, output;
		
		while(true){
			System.out.println("Enter a String: ");
			System.out.flush();
			
			input = getSting(); //实际上就是控制台输入的拿到这里来了
			if(input.equals(""))  break; //判断如果为空，终止循环
			
			//new 一个实例，让其反转
			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev();
			
			//将反转后的结果做一个输出
			System.out.println("Reversed: " + output);
			
			//因为没有对编码进行处理，所以类似汉字：中华人民共和国，还不能反转
			//需要使用StringBuilder进行反转，进行如下处理
			StringBuilder sb = new StringBuilder("中华人民共和国");
			System.out.println("StringBuilder reverse: " + sb.reverse());
		}
		
	} 
	
	//因为是在静态主入口方法里面调用，所以这个被调用的方法也需要定义成静态的
	public static String getSting() throws IOException{
		//需要一个输入流读取器(InputStreamReader)包装一下从控制台接收(System.in)的内容
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//因为输入流读取器不好用，我们有必要用带缓存的读取器把输入流读取器获得的内容再包装一下(二次包装)。
		BufferedReader br = new BufferedReader(isr);
		
		//用带缓存的 readline 方法，一次读入从控制台输入的字符串
		String s = br.readLine();
		
		return s;
	}
}
