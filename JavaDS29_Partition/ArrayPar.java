public class ArrayPar {
	private long[] theArray;
	private int nElems;

	public ArrayPar(int max) {
		theArray = new long[max];
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public int size() {
		return nElems;
	}
	
	public void display(){
		System.out.print("A = ");
		for(int j=0; j<nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}
	
	//找到划分点的位置
	public int partitionIt(int left, int right, long pivot){  //pivot表示划分点
		int leftPtr = left - 1;  //左边的结束
		int rightPtr = right + 1;    //右边的结束
		while(true){  //找相等的位置
			//从左向右找大于特定值的数据项
			while(leftPtr<right && theArray[++leftPtr] < pivot);  //循环体是一个空语句
			//循环跳出，表示找到了一个大于特定值的数据项
			
			while(rightPtr>left && theArray[--rightPtr] > pivot) ;
			//循环跳出，表示从右向左找到了一个小于特定值的数据项
			
			if(leftPtr >= rightPtr)  break;   //退出循环
			else 
				swap(leftPtr, rightPtr);
		}
		
		return leftPtr;   //此时，左边和右边相等
	}
	
	public void swap(int dex1, int dex2){
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
