import java.io.*;
public class StackTriangleApp {
	static int theNumber;
	static int theAnswer;
	static StackX theStack;
	static int codePart;
	static Parame theseParame;
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number: ");
		theNumber = getInt();
		recTriangle();
		System.out.println("Triangle = " + theAnswer);
	}
	
	public static void recTriangle(){
		theStack = new StackX(100);  //需要用栈消除递归，那就先创建一个栈
		codePart = 1;  //开始计算三角数字
		while(step() == false) ; //step() 返回true，计算结束。 返回false，将不停的计算
	}
	
	public static boolean step(){
		switch(codePart){
		case 1:  //开始计算三角形数字
			theseParame = new Parame(theNumber, 6); //6表示当前数据是栈中最底层的一个
			theStack.push(theseParame); // 参数压栈
			codePart = 2; //表示读取下一列
			break;
		case 2: //读取下一列数值
			theseParame = theStack.peek();
			
			//如果读到头了，全部求和
			if(theseParame.n == 1) {  //全部列数都放入栈中，要求进行求和
				theAnswer = 1;
				codePart = 5; //取栈中数据
			}else
				//若果没有读到头，继续往栈里面放
				codePart = 3;  //将当前数值放入栈中
			break;
		case 3:  //将当前数值放入栈中
			Parame newParame = new Parame(theseParame.n-1, 4);  //4 表示需要求和计算
			theStack.push(newParame);
			codePart = 2;
			break;
		case 4: //求和计算中(累计)
			theseParame = theStack.peek();
			theAnswer = theAnswer + theseParame.n;
			codePart = 5; //再从栈中取下一个
			break;
		case 5: //再从栈中取下一个
			theseParame = theStack.peek();
			codePart = theseParame.returnAddress;
			theStack.pop();
			break;
		case 6:    //6表示当前数据是栈中最底层的一个
			return true;
		}
		return false;
	}
	
	
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
//		String s = br.readLine();
//		return s;
		return br.readLine();
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}
