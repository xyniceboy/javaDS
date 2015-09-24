import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSortApp {
	public static void main(String[] args) throws IOException {
//		int value, value2;
//		Heap theHeap = new Heap(31); // ���������31��������
//		boolean success;
//		theHeap.insert(70);
//		theHeap.insert(40);
//		theHeap.insert(50);
//		theHeap.insert(20);
//		theHeap.insert(60);
//		theHeap.insert(100);
//		theHeap.insert(80);
//		theHeap.insert(30);
//		theHeap.insert(10);
//		theHeap.insert(90);

		int size, j;
		System.out.print("Enter number of items:");
		
		size = getInt();
		Heap theHeap = new Heap(size);
		for(j=0; j<size; j++){
			int random = (int)(java.lang.Math.random()*100);
			Node newNode = new Node(random);
			theHeap.insertAt(j, newNode); //��������ɵ����ִ����ɽڵ����˳��ŵ�����
			theHeap.increamentSize();  //��������
		} //�Ѷ�������
		
		//��������������������ʾ������һ��
		System.out.print("Random:");
		theHeap.displayArray();
		
		//��Ϊ������ɣ����Բ��ܱ���ÿ�����ڵ㶼С�������������ӽڵ㣬����б�Ҫ���е���
		/*
		 * �����һ��Ԫ�صĸ��ڵ㿪ʼ���µ�����һֱ�������������ͱ�ɱ�׼�� �� ��
		*/
//		for(j = size/2-1; j>0; j--)  //ѭ������   
		for(j = size/2-1; j>=0; j--)  //ѭ������      ����ٸ� =��������ĵ�һ���ͷŵ������ˣ���Ϊû�ж������һ������ ���������ϵ���Ѳ���
			theHeap.trickleDown(j);
		
		//��ӡ
		System.out.print("Heap:");
		theHeap.displayArray(); //�������ӡ
		theHeap.displayHeap(); //����״��ӡ
		
		/*
		 * ͨ��ѭ��ɾ��������ɾ�������ݷŵ�������ָ����λ�á����һ��������ͻ��Ϊһ����С�������������
		 */
		for(j = size-1; j>=0; j--){
			Node biggestNode = theHeap.remove();  //ȡ�����������
			theHeap.insertAt(j, biggestNode);
		}
		System.out.print("Sorted:");
		theHeap.displayArray();
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

//ͨ������ʵ�ֵĶѣ���һ����ȫ�Ķ��������Ҳ�Ҫ������С���Һ��ӡ����ʹ�������ܱ�֤���򡪡� ����Ȼ�������ǿ��Ա���ģ�ͨ��������õ�һ����С������������У�

/*
Enter number of items:30
Random:78 81 17 87 58 26 61 22 56 88 35 23 40 81 90 24 51 91 67 69 84 88 19 9 78 54 3 93 62 80 
Heap:93 91 90 87 88 78 81 51 81 84 88 26 54 78 80 24 22 56 67 69 58 35 19 9 23 40 3 61 62 17 
................................................................
                                93
                91                              90
        87              88              78              81
    51      81      84      88      26      54      78      80
  24  22  56  67  69  58  35  19  9  23  40  3  61  62  17
................................................................
Sorted:3 9 17 19 22 23 24 26 35 40 51 54 56 58 61 62 67 69 78 78 80 81 81 84 87 88 88 90 91 93 
*/