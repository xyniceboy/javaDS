import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashAgainApp {
	public static void main(String[] args) throws IOException {
		int aKey;
		DataItem aDataItem;
		int size, n;
		System.out.print("Enter size of hash table:");
		size = getInt();
		System.out.print("Enter initial number of items:");
		n = getInt();
		HashTable theHashTable = new HashTable(size);
		for (int j = 0; j < n; j++) {
			aKey = (int) (java.lang.Math.random() * 2 * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aKey, aDataItem);
		}

		while (true) {
			System.out
					.print("Enter first letter of show,insert,delete, or find:");
			char choice = getChar();
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter key value to insert:");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aKey, aDataItem);
				break;
			case 'd':
				System.out.print("Enter key value to delete:");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter key value to find:");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null)
					System.out.println("Found " + aKey);
				else
					System.out.println("Cann't find " + aKey);
				break;
			default:
				System.out.println("Invalid Entery");
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

/*
Enter size of hash table:60
Enter initial number of items:20
Enter first letter of show,insert,delete, or find:s
Table:115 ** ** ** ** 65 6 ** ** ** 66 ** 72 ** ** ** ** 77 78 ** 17 ** ** ** ** ** 26 ** ** ** ** 91 ** ** ** 35 96 ** ** ** 100 101 ** ** 44 ** 46 ** 48 ** ** ** 52 ** ** 55 ** ** ** 119 
Enter first letter of show,insert,delete, or find:i
Enter key value to insert:62
Enter first letter of show,insert,delete, or find:s
Table:115 ** 62 ** ** 65 6 ** ** ** 66 ** 72 ** ** ** ** 77 78 ** 17 ** ** ** ** ** 26 ** ** ** ** 91 ** ** ** 35 96 ** ** ** 100 101 ** ** 44 ** 46 ** 48 ** ** ** 52 ** ** 55 ** ** ** 119 
Enter first letter of show,insert,delete, or find:i
Enter key value to insert:2
Enter first letter of show,insert,delete, or find:s
Table:115 ** 62 ** ** 65 6 ** 2 ** 66 ** 72 ** ** ** ** 77 78 ** 17 ** ** ** ** ** 26 ** ** ** ** 91 ** ** ** 35 96 ** ** ** 100 101 ** ** 44 ** 46 ** 48 ** ** ** 52 ** ** 55 ** ** ** 119 
Enter first letter of show,insert,delete, or find:i
Enter key value to insert:122
Enter first letter of show,insert,delete, or find:s
Table:115 ** 62 ** ** 65 6 ** 2 ** 66 122 72 ** ** ** ** 77 78 ** 17 ** ** ** ** ** 26 ** ** ** ** 91 ** ** ** 35 96 ** ** ** 100 101 ** ** 44 ** 46 ** 48 ** ** ** 52 ** ** 55 ** ** ** 119 
Enter first letter of show,insert,delete, or find:f
Enter key value to find:122
Found 122
Enter first letter of show,insert,delete, or find:f
Enter key value to find:123
Cann't find 123
Enter first letter of show,insert,delete, or find:d
Enter key value to delete:62
Enter first letter of show,insert,delete, or find:s
Table:115 ** -1 ** ** 65 6 ** 2 ** 66 122 72 ** ** ** ** 77 78 ** 17 ** ** ** ** ** 26 ** ** ** ** 91 ** ** ** 35 96 ** ** ** 100 101 ** ** 44 ** 46 ** 48 ** ** ** 52 ** ** 55 ** ** ** 119 
Enter first letter of show,insert,delete, or find:d
Enter key value to delete:122
Enter first letter of show,insert,delete, or find:s
Table:115 ** -1 ** ** 65 6 ** 2 ** 66 -1 72 ** ** ** ** 77 78 ** 17 ** ** ** ** ** 26 ** ** ** ** 91 ** ** ** 35 96 ** ** ** 100 101 ** ** 44 ** 46 ** 48 ** ** ** 52 ** ** 55 ** ** ** 119 
Enter first letter of show,insert,delete, or find:
*/
