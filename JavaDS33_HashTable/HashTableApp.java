import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashTableApp {
	public static void main(String[] args) throws IOException{
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;
		System.out.print("Enter size of hash table: ");  //��ʾ���ݴ�С���������룺60������Դ�� 0 ~ 59
		size = getInt();
		
		System.out.print("Enter initial number of items: ");  //��������磺15.  �мǣ���� size > n.��Ȼ������Ų��¡�����ֿ�
		n = getInt();
		keysPerCell = 10;
		HashTable theHashTable = new HashTable(size);  
		for(int j = 0; j < n; j++){
			aKey = (int)(java.lang.Math.random() * keysPerCell * size); //˫���ȱ�ת���� int
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		} //ѭ���������Ͳ�����һ�������������
		
		//һ�����û�������
		while(true){
			System.out.print("Enter first letter of show,insert,delete, or kind:");
			char choice = getChar();
			switch(choice){
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter key value to insert: ");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aDataItem);
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
				if(aDataItem != null) //�ҵ���
					System.out.println("Found " + aKey);
				else 
					System.out.println("Cann't find " + aKey);
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
		String s = getString();
		return Integer.parseInt(s);
	}
}

/*
Enter size of hash table: 60
Enter initial number of items: 15
Enter first letter of show,insert,delete, or kind:s
Table:** ** ** ** ** ** 486 ** ** ** ** ** ** 253 ** ** ** ** ** ** ** ** ** 383 ** 265 ** ** 388 ** 90 ** ** ** ** ** ** 157 ** 399 460 521 ** 463 ** 285 ** 407 108 ** ** 291 ** ** ** ** ** ** ** ** 
Enter first letter of show,insert,delete, or kind:i
Enter key value to insert: 129
Enter first letter of show,insert,delete, or kind:s
Table:** ** ** ** ** ** 486 ** ** 129 ** ** ** 253 ** ** ** ** ** ** ** ** ** 383 ** 265 ** ** 388 ** 90 ** ** ** ** ** ** 157 ** 399 460 521 ** 463 ** 285 ** 407 108 ** ** 291 ** ** ** ** ** ** ** ** 
Enter first letter of show,insert,delete, or kind:i
Enter key value to insert: 63
Enter first letter of show,insert,delete, or kind:s
Table:** ** ** 63 ** ** 486 ** ** 129 ** ** ** 253 ** ** ** ** ** ** ** ** ** 383 ** 265 ** ** 388 ** 90 ** ** ** ** ** ** 157 ** 399 460 521 ** 463 ** 285 ** 407 108 ** ** 291 ** ** ** ** ** ** ** ** 
Enter first letter of show,insert,delete, or kind:d
Enter key value to delete:63
Enter first letter of show,insert,delete, or kind:s
Table:** ** ** -1 ** ** 486 ** ** 129 ** ** ** 253 ** ** ** ** ** ** ** ** ** 383 ** 265 ** ** 388 ** 90 ** ** ** ** ** ** 157 ** 399 460 521 ** 463 ** 285 ** 407 108 ** ** 291 ** ** ** ** ** ** ** ** 
Enter first letter of show,insert,delete, or kind:f
Enter key value to find:460
Found 460
Enter first letter of show,insert,delete, or kind:f
Enter key value to find:461
Cann't find 461
Enter first letter of show,insert,delete, or kind:
*/
