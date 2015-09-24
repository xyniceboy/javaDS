package javaDS04_OrdArray;


public class OrdArray {
	private long[] a;
	private int nElems;

	public OrdArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() { // 查看大小，元素个数
		return nElems;
	}

	// 二分查找方法
	public int find(long searchKey) {
		int lowBound = 0; // 开始索引
		int upperBound = nElems - 1; // 结束索引
		int curInt; // 中间临时

		while (true) {
			curInt = (lowBound + upperBound) / 2;
			if (a[curInt] == searchKey)
				return curInt;
			else if (lowBound > upperBound) // 没有找到
				return nElems;
			else {
				if (a[curInt] < searchKey) // 完后查
					lowBound = curInt + 1; // 改变最小索引
				else
					// 往前查
					upperBound = curInt - 1; // 改变最大索引
//				lowBound++;
//				upperBound--;
			}
		}
	}

	// 添加数据项(线性查找)
	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			// 首先定位待插入数据的位置
			if (a[j] > value)
				break;

		for (int k = nElems; k > j; k--)
			// 后移
			a[k] = a[k - 1];

		a[j] = value; // 插入数据，总数加 1
		nElems++;
	}

	// 删除数据项
	public boolean delete(long value) {
		int j = find(value); // 先调用二分查找去找数据项
		if (j == nElems)
			return false;
		else {
			for (int k = j; k < nElems; k++)   // 将数据向前移动，覆盖删除的元素
				a[k] = a[k + 1];
			
			nElems--;    // 元素总个数减 1
			return true;
		}
	}

	// 显示
	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}

}
