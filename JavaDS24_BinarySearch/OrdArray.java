
public class OrdArray {
	private long[] a;
	private int nElems;
	
	public OrdArray(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public int size(){
		return nElems;
	}
	
	public int find(long searchKey){
		return recFind(searchKey, 0, nElems-1);
	}
	
	//Ӧ�õݹ���� ���� �����㷨��һ��������  ���ε�˼�����һ�������⣬���Էֽ�����ɸ�С���⡣
	private int recFind(long searchKey, int lowerBound, int upperBound){
		int curIn;
		curIn = (lowerBound + upperBound)/2;
		if(a[curIn] == searchKey)  //�ҵ���
			return curIn;
		else if(lowerBound > upperBound)   //û����
			return nElems;   
		else{
			if(a[curIn] < searchKey)   //���������ұߣ������ұ���
				return recFind(searchKey, curIn + 1, upperBound);  //curInt�ȽϹ��ˣ��Ͳ����ٱ���
			else 
				return recFind(searchKey, lowerBound, curIn - 1);
		}
	}
	
	public void insert(long value){
		int j;
		for(j = 0; j < nElems; j++)
			if(a[j] > value) break;  //��ʱ��kΪ�ҵ�����Ҫ�����λ�� 
		
		//��j�����Ԫ�غ���
		for(int k = nElems; k > j; k--)	
			a[k] = a[k-1];  
		//���²�������ݷ��뵽a[j]��λ��, ������++
		a[j] = value;
		nElems++;
	}
	
	public void display(){
		for(int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}
}
