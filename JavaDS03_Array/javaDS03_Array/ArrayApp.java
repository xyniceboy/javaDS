package javaDS03_Array;

public class ArrayApp {
	public static void main(String[] args){
		long[] arr;
		arr = new long[100];  //创建数组
		int nElems = 0;
		int j;
		long searchKey;
 
		nElems = 12;
		
		// 显示所有元素
		for(j=0; j<nElems; j++)
			System.out.print(arr[j]+" ");
		System.out.println();
		
		//查找76
		searchKey = 76;
  		for(j=0;j<nElems;j++)
			if(arr[j]==searchKey) break;
		if(j==nElems)
			System.out.println("Cann't find " + searchKey);
		else
			System.out.println("Found "+searchKey);
		
		//删除80
		searchKey = 80;
		for(j=0;j<nElems;j++)
			if(arr[j]==searchKey)  break;
		for(int k=j; k<nElems;k++)
			arr[k] =arr[k+1];
		nElems--;
		
		//显示所有元素
		for(j=0; j<nElems; j++)
			System.out.print(arr[j]+" ");
		System.out.println();
	}
}
