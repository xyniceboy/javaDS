package javaDS03_Array;

public class ArrayApp {
	public static void main(String[] args){
		long[] arr;
		arr = new long[100];  //��������
		int nElems = 0;
		int j;
		long searchKey;
 
		nElems = 12;
		
		// ��ʾ����Ԫ��
		for(j=0; j<nElems; j++)
			System.out.print(arr[j]+" ");
		System.out.println();
		
		//����76
		searchKey = 76;
  		for(j=0;j<nElems;j++)
			if(arr[j]==searchKey) break;
		if(j==nElems)
			System.out.println("Cann't find " + searchKey);
		else
			System.out.println("Found "+searchKey);
		
		//ɾ��80
		searchKey = 80;
		for(j=0;j<nElems;j++)
			if(arr[j]==searchKey)  break;
		for(int k=j; k<nElems;k++)
			arr[k] =arr[k+1];
		nElems--;
		
		//��ʾ����Ԫ��
		for(j=0; j<nElems; j++)
			System.out.print(arr[j]+" ");
		System.out.println();
	}
}
