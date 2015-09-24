import java.io.*;


public class FactorialApp {
	static int theNumber;  //记录第一个三角形的高，比如 7
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a number: ");
		theNumber = getInt();
		int theAnswer = factorial(theNumber);
		System.out.println("Triangl e = " + theAnswer);
	}
	
	public static int factorial(int n){
		if(n == 1)  //基值情况 
			return 1;
		else 
			return (n * factorial(n - 1));
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}

//测试：
//Enter a number: 6
//Triangl e = 720
