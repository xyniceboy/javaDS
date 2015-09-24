package javaDS03_HighArray;

public class HighArray {
	private long[] a;
	private int nElems;

	//���ܴ����������ʼ��һ������Ϊmax��Ԫ��Ϊ 0 �� long ������
	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	//����
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] == searchKey)
				break;
		}
		if (j == nElems)
			return false;
		else
			return true; // �ҵ�
	}
	
	//����
	public void insert(long value){
		a[nElems] = value;
		nElems++;  //���ݵ���
	}
	
	//ɾ��
	public boolean delete(long value){
		int j;
		for(j=0;j<nElems;j++)
			if(a[j]==value) break;
		if(j==nElems)
			return false;
		else { 
			for(int k=j;k<nElems;k++)
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}
	
	//�鿴
	public void display(){
		for(int j = 0;j<nElems;j++)
			System.out.print(a[j]+ " ");  //ÿ��Ԫ��֮���һ���ո�
		System.out.println();  //һ��ѭ����֮����
	}
}
