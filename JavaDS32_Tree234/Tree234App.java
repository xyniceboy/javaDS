import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234App {
	public static void main(String[] args) throws IOException {
		long value;
		Tree234 theTree = new Tree234();
//		theTree.insert(50);
//		theTree.insert(40);
//		theTree.insert(70);
//		theTree.insert(30);
//		theTree.insert(60);   //这跟最后的顺序有关系
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(60);
		theTree.insert(30);
		theTree.insert(70);   //这跟最后的顺序无关系
		while (true) {
			System.out.print("Enter first letter of show,insert,or find: ");
			char choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				theTree.insert(value);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = getInt();
				int found = theTree.find(value);
				if (found != -1)
					System.out.println("Found " + value);
				else
					System.out.println("Cann't find " + value);
				break;
			default:
				System.out.println("Invalid enter");
			}
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}

	public static char getChar() throws IOException {
		return getString().charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}

/*Enter first letter of show,insert,or find: s
level=0 child=0 /50/
level=1 child=0 /30/40/
level=1 child=1 /60/70/
Enter first letter of show,insert,or find: i
Enter value to insert: 35
Enter first letter of show,insert,or find: i
Enter value to insert: 45
Enter first letter of show,insert,or find: s
level=0 child=0 /35/50/
level=1 child=0 /30/
level=1 child=1 /40/45/
level=1 child=2 /60/70/
Enter first letter of show,insert,or find: i
Enter value to insert: 65
Enter first letter of show,insert,or find: s
level=0 child=0 /35/50/
level=1 child=0 /30/
level=1 child=1 /40/45/
level=1 child=2 /60/65/70/
Enter first letter of show,insert,or find: f
Enter value to find: 40
Found 40
Enter first letter of show,insert,or find: f
Enter value to find: 49
Cann't find 49
Enter first letter of show,insert,or find: w
Invalid enter
Enter first letter of show,insert,or find: 
 * */