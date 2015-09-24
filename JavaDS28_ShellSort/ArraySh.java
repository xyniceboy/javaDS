
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
	
	//����˵��ϣ��������������˼����ϣ������
	// ϣ�������ǻ��� ���������һ���߼�����
	public void shellSort(){
		int inner, outer;
		long temp;
		
		int h = 1;
		
		//���������
		while(h <= nElems/3)   // 100
			h = h*3+1;  // 1 4 13 40  //�����100���������ôh = 40
		
		//��͵õ��� h
		
		//ѭ��������м����������
		while(h > 0){
			for(outer = h; outer < nElems; outer++){  //���м������
				temp = theArray[outer];
				inner = outer;
				while(inner > h-1 && theArray[inner-h] >= temp){
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			h = (h-1)/3;  //�����100���������ô ��ʼ=40
			              //2. h=13   3.h=4   4.h=1
		}
		
	}
}
