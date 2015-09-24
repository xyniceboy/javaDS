import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 变位字，在日常的搜索中会经常用到

public class AnagramApp {
	static int size;
	static int count;
	static char[] arrChar = new char[100];
	
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a word: ");
		String input = getString();
		size = input.length();
		count = 0;
		for(int j = 0; j < size; j++)
			arrChar[j] = input.charAt(j);
		doAnagram(size);
	}
	
	public static void doAnagram(int newSize){
		if(newSize == 1)  //基值情况 
			return ;
		for(int j = 0; j < newSize; j++){ 
			doAnagram(newSize-1);
			if (newSize == 2)
				displayWord();
			rotate(newSize);  //转动
		}
	}
	
	//转动（就是换位置的过程）
	public static void rotate(int newSize){
		int j;
		int position = size - newSize;
		char temp = arrChar[position];
		for(j = position + 1; j < size; j++)
			arrChar[j - 1] = arrChar[j];
		arrChar[j-1] = temp;
	}
	
	//单词的打印
	public static void displayWord(){
		if(count < 99) System.out.print(" ");
		if(count < 9) System.out.print(" ");  //多加一个空格
		System.out.print(++count + " ");
		
		for(int j = 0; j < size; j++)
			System.out.print(arrChar[j]);
		System.out.print("  ");
		System.out.flush();
		
		//控制每6个就换行
		if(count%6 == 0)
			System.out.println();
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
}

/*
 Enter a word: xupt
  1 xupt    2 xutp    3 xptu    4 xput    5 xtup    6 xtpu  
  7 uptx    8 upxt    9 utxp   10 utpx   11 uxpt   12 uxtp  
 13 ptxu   14 ptux   15 pxut   16 pxtu   17 putx   18 puxt  
 19 txup   20 txpu   21 tupx   22 tuxp   23 tpxu   24 tpux  
  
 */
