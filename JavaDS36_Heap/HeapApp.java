import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapApp {
	public static void main(String[] args) throws IOException {
		int value, value2;
		Heap theHeap = new Heap(31); // 设置最大有31个数据项
		boolean success;
		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);

		while (true) {
			System.out
					.print("Enter first letter of show,insert,remove, or change:");
			int choice = getChar();
			switch (choice) {
			case 's':
				theHeap.displayHeap();
				break;
			case 'i':
				System.out.print("Enter value to insert:");
				value = getInt();
				success = theHeap.insert(value);
				if (!success)
					System.out.println("Cann't insert(heap full)!");
				break;
			case 'r':
				if (!theHeap.isEmtpy())
					theHeap.remove();
				else
					System.out.println("Cann't remove(heap empty)!");
				break;
			case 'c':
				System.out.print("Enter current index of item:");
				value = getInt();
				System.out.print("Enter new key:");
				value2 = getInt();
				success = theHeap.change(value, value2);
				if (!success)
					System.out.println("Invalid index");
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

//通过数组实现的堆，是一个完全的二叉树，且不要求左孩子小于右孩子

/*
Enter first letter of show,insert,remove, or change:s
HeapArray:100 90 80 30 60 50 70 20 10 40 
................................................................
                              100
              90                              80
      30              60              50              70
  20      10      40
................................................................
Enter first letter of show,insert,remove, or change:i
Enter value to insert:101
Enter first letter of show,insert,remove, or change:s
HeapArray:101 100 80 30 90 50 70 20 10 40 60 
................................................................
                              101
              100                              80
      30              90              50              70
  20      10      40      60
................................................................
Enter first letter of show,insert,remove, or change:r
Enter first letter of show,insert,remove, or change:s
HeapArray:100 90 80 30 60 50 70 20 10 40 
................................................................
                              100
              90                              80
      30              60              50              70
  20      10      40
................................................................
Enter first letter of show,insert,remove, or change:c
Enter current index of item:3
Enter new key:130
Enter first letter of show,insert,remove, or change:s
HeapArray:130 100 80 90 60 50 70 20 10 40 
................................................................
                              130
              100                              80
      90              60              50              70
  20      10      40
................................................................
Enter first letter of show,insert,remove, or change:
*/