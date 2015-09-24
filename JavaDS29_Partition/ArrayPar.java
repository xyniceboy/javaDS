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
	
	//�ҵ����ֵ��λ��
	public int partitionIt(int left, int right, long pivot){  //pivot��ʾ���ֵ�
		int leftPtr = left - 1;  //��ߵĽ���
		int rightPtr = right + 1;    //�ұߵĽ���
		while(true){  //����ȵ�λ��
			//���������Ҵ����ض�ֵ��������
			while(leftPtr<right && theArray[++leftPtr] < pivot);  //ѭ������һ�������
			//ѭ����������ʾ�ҵ���һ�������ض�ֵ��������
			
			while(rightPtr>left && theArray[--rightPtr] > pivot) ;
			//ѭ����������ʾ���������ҵ���һ��С���ض�ֵ��������
			
			if(leftPtr >= rightPtr)  break;   //�˳�ѭ��
			else 
				swap(leftPtr, rightPtr);
		}
		
		return leftPtr;   //��ʱ����ߺ��ұ����
	}
	
	public void swap(int dex1, int dex2){
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
