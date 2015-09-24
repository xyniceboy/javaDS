
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
	
	public void mergeSort(){  //��Ҫ���¿��ٵģ�ͬ�ȴ�С����ʱ����
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
		int lowerBound = lowPtr;  // ��ʼλ��
		int mid = highPtr-1;  //�м�λ��
		int n = upperBound - lowerBound + 1;  //Ҫ�鲢������
		while(lowPtr <= mid && highPtr <= upperBound)//��벿�ֵĿ�ʼ С�� ��벿�ֵĽ�������
			//�Ұ벿�ֵĿ�ʼ С�� �Ұ벿�ֵĽ���
			if(theArray[lowPtr] < theArray[highPtr]) //��벿�ֿ�ʼλ�� С�� �Ұ벿�ֿ�ʼλ��
				workSpace[j++] = theArray[lowPtr++]; //j++��lowPtr++ ����Ϊ�˻����һ��
			else
				workSpace[j++] = theArray[highPtr++];  
		
		//�������ʣ�ࡢ�����ұ�ʣ�࣬������һ��
		while(lowPtr <= mid)//ǰ��Ŀ�ʼ С�� ǰ����Ľ���
			workSpace[j++] = theArray[lowPtr++];  //�Ѻ���ķŵ�������������
		while(highPtr <= upperBound)//����Ŀ�ʼ С�� ����Ľ���
			workSpace[j++] = theArray[highPtr++];   //�Ѻ���ķŵ�������������
		
		//������õ����鷵�ص�ԭ��������
		for(j = 0; j < n; j++)
			theArray[lowerBound + j] = workSpace[j];  //��ָ����λ�������
	}
}
