package javaDS03_HighArray;

public class HighArray {
	private long[] a;
	private int nElems;

	//接受传入参数，初始化一个长度为max，元素为 0 的 long 型数组
	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	//查找
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] == searchKey)
				break;
		}
		if (j == nElems)
			return false;
		else
			return true; // 找到
	}
	
	//插入
	public void insert(long value){
		a[nElems] = value;
		nElems++;  //数据递增
	}
	
	//删除
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
	
	//查看
	public void display(){
		for(int j = 0;j<nElems;j++)
			System.out.print(a[j]+ " ");  //每个元素之间空一个空格
		System.out.println();  //一个循环完之后换行
	}
}
