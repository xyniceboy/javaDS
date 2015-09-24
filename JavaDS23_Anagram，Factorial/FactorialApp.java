import java.io.*;


public class FactorialApp {
	static int theNumber;  //��¼��һ�������εĸߣ����� 7
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a number: ");
		theNumber = getInt();
		int theAnswer = factorial(theNumber);
		System.out.println("Triangl e = " + theAnswer);
	}
	
	public static int factorial(int n){
		if(n == 1)  //��ֵ��� 
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

//���ԣ�
//Enter a number: 6
//Triangl e = 720
