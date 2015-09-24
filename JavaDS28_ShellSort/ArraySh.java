
public class ArraySh {
	private long[] theArray;
	private int nElems;
	public ArraySh(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display(){
		System.out.print("A=");
		for(int j = 0; j < nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}
	
	//简单来说：希尔排序就是增加了间隔的希尔排序
	// 希尔排序是基于 插入排序的一个高级排序
	public void shellSort(){
		int inner, outer;
		long temp;
		
		int h = 1;
		
		//计算最大间隔
		while(h <= nElems/3)   // 100
			h = h*3+1;  // 1 4 13 40  //如果是100个数据项，那么h = 40
		
		//这就得到了 h
		
		//循环间隔进行间隔有序排列
		while(h > 0){
			for(outer = h; outer < nElems; outer++){  //进行间隔排序
				temp = theArray[outer];
				inner = outer;
				while(inner > h-1 && theArray[inner-h] >= temp){
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			h = (h-1)/3;  //如果是100个数据项，那么 初始=40
			              //2. h=13   3.h=4   4.h=1
		}
		
	}
}
