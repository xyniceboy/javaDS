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
	
	//冒泡排序
	/*
	 * 冒泡排序规则：
	 * 1, 比较两个相邻对象；
	 * 2, 如果左边的大于右边，则调换位置；
	 * 3, 向右移动一个位置，比较接下来的两个对象。
	 * 冒泡排序需要：out、 in、in+1三个指针：out 记录最后排序后，最大(最小)前一个元素(在所谓的末尾)。
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
//		System.out.println("外层指针跳动了： " + out + " 次！");
//		System.out.println("总共循环了： " + count + " 次！");
	}
	
	private void swap(int one, int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	
	
}
