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
//		int size = left-right+1;   //�����Ļ���ֱ�� return���������
		int size = right-left+1;
		if(size<=3)   //����˵����Ҫһֱ�ݹ�ġ����ȣ�������ĳ��ֶ��ģ����������С��3��Ϳ��Խ����ֹ����иĶ���
			manualSort(left, right);  //�����ͱ�����С���������õݹ鲢���Ǻܺ�
		else{
//			long pivot = theArray[right]; //ȡ�ָ��ֵ
//			int partition = partitionIt(left, right, pivot);
			long median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			recQuickSort(left, partition-1);  //�ݹ飬ǰһ�����ٻ���
			recQuickSort(partition+1, right);  //�ݹ飬��һ�����ڻ���
		}
	}
	
	public long medianOf3(int left, int right){ //��������ȡ��
		int center = (left+right)/2;  //����һ������ֵ ���Ҵ��ڣ�����������������������
		if(theArray[left] > theArray[center])
			swap(left, center);
		if(theArray[left] > theArray[right])
			swap(left, right);
		if(theArray[center] > theArray[right])
			swap(center, right);
		
		swap(center, right-1);  //�м�ֵ�����ұ�ǰ��һ��ֵ����    ??????????Ϊʲô�أ�
		return theArray[right-1];  
	}
	
	public void manualSort(int left, int right){  //�ֹ�����
//		int size = left-right+1;  //Ҫ�����Ԫ������
		int size = right-left+1; //Ҫ�����Ԫ������
		if(size<=1)
			return;
		if(size==2){
			if(theArray[left] > theArray[right])
				swap(left, right);
			return;
		}else{  //3��������3������������ʽ
			if(theArray[left] > theArray[right-1])  //right-1 ��ʾ�м��
				swap(left, right-1);
			if(theArray[left] > theArray[right])  
				swap(left, right);
			if(theArray[left-1] > theArray[right]) 
				swap(left-1, right);
			//���else�����ɹ�֮�󣬾����������
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
		swap(leftPtr, right-1);  //leftPtr, rightPtrͬ���Ұ벿�֣�������Ŀ�ľ�����������һ�·ָ�ֵ
		
		return leftPtr;
	}
	
	public void swap(int dex1, int dex2){
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
