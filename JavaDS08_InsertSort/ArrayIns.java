
public class ArrayIns {
	private long[] a;
	private int nElems;
	public ArrayIns(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		a[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int j=0; j< nElems;j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}
	
	/*
	 * 插入排序，在逆序的時候，如果是逆序，冒泡排序要好些。总体来说，插入排序是冒泡排序的2倍，比选择排序快一点点。
	 */
	public void insertionSort(){
		int in, out;
		for(out=1;out<nElems;out++){
			long temp = a[out];
			in = out;
			while(in > 0 && a[in -1]>=temp){
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}
}
