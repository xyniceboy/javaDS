import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HashChainApp {
	public static void main(String[] args) throws IOException{
		int aKey;
		Link aDataItem;
		int size, n, keysPerCell = 100;
		System.out.print("Enter size of hash table:");
		size = getInt();
		HashTable theHashTable = new HashTable(size);
		System.out.print("Enter initial number of items:");
		n = getInt();
		for(int j = 0; j < n; j++){
			aKey = (int)(Math.random() * keysPerCell * size);
			aDataItem = new Link(aKey);
			theHashTable.insert(aDataItem);
		}
		
		//ÈË»ú½»»¥
		while(true){
			System.out.print("Enter first letter of show,insert,delete, or find:");
			char choice = getChar();
			switch(choice){
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter key value to insert:");
				aKey = getInt();
				aDataItem =new Link(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter key value to delete:");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter key value to find:");
				aKey =getInt();
				aDataItem = theHashTable.find(aKey);
				if(aDataItem != null)
					System.out.println("Found " + aKey);
				else 
					System.out.println("Cann't find " + aKey);
				break;
				default:
					System.out.println("Invalid entery");
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
Enter size of hash table:30
Enter initial number of items:25
Enter first letter of show,insert,delete, or find:s
0. List(first-->last):1950 
1. List(first-->last):1 1291 
2. List(first-->last):1682 
3. List(first-->last):2823 
4. List(first-->last):1054 2554 
5. List(first-->last):275 275 
6. List(first-->last):1116 2166 
7. List(first-->last):
8. List(first-->last):908 1058 
9. List(first-->last):
10. List(first-->last):1660 
11. List(first-->last):671 701 
12. List(first-->last):
13. List(first-->last):1573 2803 
14. List(first-->last):2024 
15. List(first-->last):
16. List(first-->last):
17. List(first-->last):587 
18. List(first-->last):
19. List(first-->last):2149 
20. List(first-->last):
21. List(first-->last):2061 
22. List(first-->last):
23. List(first-->last):2063 
24. List(first-->last):444 
25. List(first-->last):
26. List(first-->last):1256 
27. List(first-->last):
28. List(first-->last):
29. List(first-->last):
Enter first letter of show,insert,delete, or find:i
Enter key value to insert:53
Enter first letter of show,insert,delete, or find:s
0. List(first-->last):1950 
1. List(first-->last):1 1291 
2. List(first-->last):1682 
3. List(first-->last):2823 
4. List(first-->last):1054 2554 
5. List(first-->last):275 275 
6. List(first-->last):1116 2166 
7. List(first-->last):
8. List(first-->last):908 1058 
9. List(first-->last):
10. List(first-->last):1660 
11. List(first-->last):671 701 
12. List(first-->last):
13. List(first-->last):1573 2803 
14. List(first-->last):2024 
15. List(first-->last):
16. List(first-->last):
17. List(first-->last):587 
18. List(first-->last):
19. List(first-->last):2149 
20. List(first-->last):
21. List(first-->last):2061 
22. List(first-->last):
23. List(first-->last):53 2063 
24. List(first-->last):444 
25. List(first-->last):
26. List(first-->last):1256 
27. List(first-->last):
28. List(first-->last):
29. List(first-->last):
Enter first letter of show,insert,delete, or find:d
Enter key value to delete:2063
Enter first letter of show,insert,delete, or find:s
0. List(first-->last):1950 
1. List(first-->last):1 1291 
2. List(first-->last):1682 
3. List(first-->last):2823 
4. List(first-->last):1054 2554 
5. List(first-->last):275 275 
6. List(first-->last):1116 2166 
7. List(first-->last):
8. List(first-->last):908 1058 
9. List(first-->last):
10. List(first-->last):1660 
11. List(first-->last):671 701 
12. List(first-->last):
13. List(first-->last):1573 2803 
14. List(first-->last):2024 
15. List(first-->last):
16. List(first-->last):
17. List(first-->last):587 
18. List(first-->last):
19. List(first-->last):2149 
20. List(first-->last):
21. List(first-->last):2061 
22. List(first-->last):
23. List(first-->last):53 
24. List(first-->last):444 
25. List(first-->last):
26. List(first-->last):1256 
27. List(first-->last):
28. List(first-->last):
29. List(first-->last):
Enter first letter of show,insert,delete, or find:f
Enter key value to find:27
Cann't find 27
Enter first letter of show,insert,delete, or find:f
Enter key value to find:1256
Found 1256
Enter first letter of show,insert,delete, or find:asdfasdf
Invalid entery
Enter first letter of show,insert,delete, or find:
 */

