package bwang;

public class QuickSortApp {
	public static void main(String[] args) {
		int maxSize = 16;

		// 测试插入、显示
		ArrayIns arr = new ArrayIns(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}
		arr.display();

		arr.quickSort();
		arr.display();
	}
}

/*
 * 这样的取的划分点，可能偏大或者偏小，会使得数据分布不均匀，那怎样使得数据均匀呢？ 可以再进一步优化，使得其取一个接近中间值的划分基本点。三项取中间项改进这样一个快速排序
 * 请看： xupt 包
 */