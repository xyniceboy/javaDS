package xupt;

public class ArrayIns {
	private long[] theArray;
	public int nElems;
	public ArrayIns(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display(){
		System.out.print("A = ");
		for(int j=0; j<nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}
	
	public void quickSort(){
		recQuickSort(0, nElems-1);

	}
	
	public void recQuickSort(int left, int right){
//		int size = left-right+1;   //这样的话，直接 return，可以理解
		int size = right-left+1;
		if(size<=3)   //不是说，需要一直递归的。首先，想把它改成手动的，如果数据项小于3项，就可以进行手工进行改动。
			manualSort(left, right);  //这样就避免了小数据量，用递归并不是很好
		else{
//			long pivot = theArray[right]; //取分割点值
//			int partition = partitionIt(left, right, pivot);
			long median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			recQuickSort(left, partition-1);  //递归，前一部分再划分
			recQuickSort(partition+1, right);  //递归，后一部分在划分
		}
	}
	
	public long medianOf3(int left, int right){ //三项数据取中
		int center = (left+right)/2;  //这是一个计算值 ，且存在！！！！！！！！！！！！
		if(theArray[left] > theArray[center])
			swap(left, center);
		if(theArray[left] > theArray[right])
			swap(left, right);
		if(theArray[center] > theArray[right])
			swap(center, right);
		
		swap(center, right-1);  //中间值和最右边前面一个值交换    ??????????为什么呢？
		return theArray[right-1];  
	}
	
	public void manualSort(int left, int right){  //手工排序
//		int size = left-right+1;  //要排序的元素数量
		int size = right-left+1; //要排序的元素数量
		if(size<=1)
			return;
		if(size==2){
			if(theArray[left] > theArray[right])
				swap(left, right);
			return;
		}else{  //3个，大于3个有其他处理方式
			if(theArray[left] > theArray[right-1])  //right-1 表示中间的
				swap(left, right-1);
			if(theArray[left] > theArray[right])  
				swap(left, right);
			if(theArray[left-1] > theArray[right]) 
				swap(left-1, right);
			//这个else检查完成过之后，就是有序的了
		}
	}
	
	public int partitionIt(int left, int right, long pivot){
//		int leftPtr = left-1;
		int leftPtr = left;
		int rightPtr = right-1;
		while(true){
			while(theArray[++leftPtr] < pivot) ;
			while(theArray[--rightPtr] > pivot) ;
			if(leftPtr >= rightPtr)  break;
			else swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right-1);  //leftPtr, rightPtr同属右半部分，交换的目的就是重新再找一下分割值
		
		return leftPtr;
	}
	
	public void swap(int dex1, int dex2){
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
