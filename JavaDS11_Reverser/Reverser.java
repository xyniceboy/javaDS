
public class Reverser {
	private String input;  //存放传进来，等待逆序的字符串
	private String output = ""; //存放经过逆序处理后的字符串,初始化一个空串
	
	public Reverser(String in){
		input = in;
	}
	
	public String doRev(){
		int stackSize = input.length();  //获得传进来字符串的长度
		StackX theStack = new StackX(stackSize);  
		//把字符一个一个的入栈，从 input 里面获得
		for(int j=0; j<input.length(); j++){
			char ch = input.charAt(j); //从字符串里一个一个往出拿字符
			theStack.push(ch);  //将取出来的字符圧栈
		}
		
		//把字符一个一个的弹出来，并用 output 存
		while(!theStack.isEmpty()){
			char c = theStack.pop(); //从栈弹出的元素用c临时存储
			output  = output + c;  //追加到output里面
		}
		return output;
	}
}
