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
	 * ѡ�������㷨Ҳ��Լ򵥣�����Ч�ʲ��Ǻܸߣ���ð������Ч�ʸ�һ�㡣10��Ԫ��45�Σ�100��Ԫ�أ��ӽ�5000�Ρ�
�����Ĵ����������O(n) 
	 */
	public void selectionSort(){
		int out, in, min;
		for(out = 0; out < nElems; out++){
			min = out;
			for(in = out+1; in < nElems; in++)
				if(a[in] < a[min])   //�б����һ�Σ��ҵ���С�ļ�����min
					min = in; 
			
			//��˼�ǣ���� min �� out ָ���Ԫ�ذl����׃�����Ž��Q����t�������Q
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
