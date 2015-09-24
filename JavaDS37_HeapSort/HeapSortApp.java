import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSortApp {
	public static void main(String[] args) throws IOException {
//		int value, value2;
//		Heap theHeap = new Heap(31); // 设置最大有31个数据项
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
			theHeap.insertAt(j, newNode); //把随机生成的数字创建成节点后按照顺序放到堆中
			theHeap.increamentSize();  //数量递增
		} //把堆填满了
		
		//将随机生成无序的数组显示出来看一下
		System.out.print("Random:");
		theHeap.displayArray();
		
		//因为随机生成，所以不能保障每个父节点都小于其任意两个子节点，这就有必要进行调整
		/*
		 * 从最后一个元素的父节点开始向下调整，一直到根，调整完后就变成标准的 堆 了
		*/
//		for(j = size/2-1; j>0; j--)  //循环到根   
		for(j = size/2-1; j>=0; j--)  //循环到根      如果少个 =，把数组的第一个就放到跟上了，因为没有对数组第一个进行 真正意义上的入堆操作
			theHeap.trickleDown(j);
		
		//打印
		System.out.print("Heap:");
		theHeap.displayArray(); //按数组打印
		theHeap.displayHeap(); //按树状打印
		
		/*
		 * 通过循环删除最大项，把删除的数据放到数组中指定的位置。如此一来，数组就会成为一个从小到大的有序数组
		 */
		for(j = size-1; j>=0; j--){
			Node biggestNode = theHeap.remove();  //取出最大数据项
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

//通过数组实现的堆，是一个完全的二叉树，且不要求左孩子小于右孩子。这就使得它不能保证有序—— 弱序。然而，我们可以变相的，通过输出，得到一个从小到大的有序序列！

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