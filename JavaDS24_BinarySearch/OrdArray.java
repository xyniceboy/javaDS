
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
	
	//应用递归查找 —— 分治算法的一个方法。  分治的思想就是一个大问题，可以分解成若干个小问题。
	private int recFind(long searchKey, int lowerBound, int upperBound){
		int curIn;
		curIn = (lowerBound + upperBound)/2;
		if(a[curIn] == searchKey)  //找到了
			return curIn;
		else if(lowerBound > upperBound)   //没找着
			return nElems;   
		else{
			if(a[curIn] < searchKey)   //查找项在右边，则在右边找
				return recFind(searchKey, curIn + 1, upperBound);  //curInt比较过了，就不用再比了
			else 
				return recFind(searchKey, lowerBound, curIn - 1);
		}
	}
	
	public void insert(long value){
		int j;
		for(j = 0; j < nElems; j++)
			if(a[j] > value) break;  //此时，k为找到的需要插入的位置 
		
		//将j后面的元素后移
		for(int k = nElems; k > j; k--)	
			a[k] = a[k-1];  
		//将新插入的数据放入到a[j]的位置, 且总数++
		a[j] = value;
		nElems++;
	}
	
	public void display(){
		for(int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}
}
