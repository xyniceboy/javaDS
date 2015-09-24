
public class DArray {
	private long[] theArray;
	private int nElems;
	
	public DArray(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int j = 0; j < nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}
	
	public void mergeSort(){  //需要重新开辟的，同等大小的临时数组
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems-1);
	}
	
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound){
		if(lowerBound == upperBound) return;
		else {
			int mid = (lowerBound+upperBound)/2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid+1, upperBound);
			merge(workSpace, lowerBound, mid+1, upperBound);
		}
	}
	
	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound){
		int j = 0;
		int lowerBound = lowPtr;  // 开始位置
		int mid = highPtr-1;  //中间位置
		int n = upperBound - lowerBound + 1;  //要归并的数量
		while(lowPtr <= mid && highPtr <= upperBound)//左半部分的开始 小于 左半部分的结束，且
			//右半部分的开始 小于 右半部分的结束
			if(theArray[lowPtr] < theArray[highPtr]) //左半部分开始位置 小于 右半部分开始位置
				workSpace[j++] = theArray[lowPtr++]; //j++、lowPtr++ 都是为了获得下一个
			else
				workSpace[j++] = theArray[highPtr++];  
		
		//不管左边剩余、还是右边剩余，都遍历一遍
		while(lowPtr <= mid)//前面的开始 小于 前面面的结束
			workSpace[j++] = theArray[lowPtr++];  //把后面的放到借助的数组中
		while(highPtr <= upperBound)//后面的开始 小于 后面的结束
			workSpace[j++] = theArray[highPtr++];   //把后面的放到借助的数组中
		
		//把排序好的数组返回到原来数组中
		for(j = 0; j < n; j++)
			theArray[lowerBound + j] = workSpace[j];  //从指定的位置往后放
	}
}
