import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {
	public static void main(String[] args) throws IOException {
		int value;
		Tree theTree = new Tree();
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.1);
		theTree.insert(19, 1.5);
		theTree.insert(35, 1.3);
		theTree.insert(75, 1.7);
		theTree.insert(0, 1.6);

		while (true) {
			System.out
					.print("Enter first letter of show,insert,find,delete or traverse:");
			int choice = getChar();
			switch (choice) {
			case 's': // 显示
				theTree.displayTree();
				break;
			case 'i': // 插入
				System.out.print("Enter value to insert:");
				value = getInt();
				theTree.insert(value, value + 0.9);
				break;
			case 'f':// 查
				System.out.print("Enter value to find:");
				value = getInt();
				Node found = theTree.find(value);
				if (found != null) {
					System.out.print("Found: ");
					found.displayNode();
					System.out.println();
				} else
					System.out.println("Cann't found " + value + "\n");
				break;
			case 'd': // 删除
				System.out.print("Enter value to delete:");
				value = getInt();
				boolean didDelete = theTree.delete(value);
				if (didDelete)
					System.out.println("Deleted " + value);
				else
					System.out.println("Cann't find " + value);
				break;
			case 't': // 遍历
				System.out.print("Enter type 1,2 or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
				default:
					System.out.println("Invalid entry");
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
		return Integer.parseInt(getString());
	}
}
