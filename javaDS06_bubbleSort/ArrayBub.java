package javaDS06_bubbleSort;

public class ArrayBub {
	private long[] a;
	private int nElems;
	
	public ArrayBub(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		a[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}
	
	//ð������
	/*
	 * ð���������
	 * 1, �Ƚ��������ڶ���
	 * 2, �����ߵĴ����ұߣ������λ�ã�
	 * 3, �����ƶ�һ��λ�ã��ȽϽ���������������
	 * ð��������Ҫ��out�� in��in+1����ָ�룺out ��¼�����������(��С)ǰһ��Ԫ��(����ν��ĩβ)��
	 */
	public void bubbleSort(){
		int out, in; 
//		int  count=0;
		for(out = nElems-1; out>1; out--)
			for(in=0; in < out; in++)
				if(a[in] > a[in+1]){
					swap(in, in+1);
//					count++;
				}
//		System.out.println("���ָ�������ˣ� " + out + " �Σ�");
//		System.out.println("�ܹ�ѭ���ˣ� " + count + " �Σ�");
	}
	
	private void swap(int one, int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	
	
}
