public class ArraySel {
	private long[] a;
	private int nElems;

	public ArraySel(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}
	
	/*
	 * 选择排序，算法也相对简单，但是效率不是很高，比冒泡排序效率高一点。10个元素45次，100个元素，接近5000次。
交换的次数，大概是O(n) 
	 */
	public void selectionSort(){
		int out, in, min;
		for(out = 0; out < nElems; out++){
			min = out;
			for(in = out+1; in < nElems; in++)
				if(a[in] < a[min])   //列表遍历一次，找到最小的记作：min
					min = in; 
			
			//意思是：如果 min 和 out 指向的元素發生了變化，才交換；否則，不交換
			if((min-out)!=0)   
				swap(out,min);
		}
	}
	
	private void swap(int one, int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
