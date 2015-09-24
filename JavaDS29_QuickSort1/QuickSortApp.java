package xdup;

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
		arr.quickSort(); //三项数据取中划分快速排序
		arr.display();
	}
}

// 将快速排序发挥到极限，使用 “小划分采用插入排序”策略是很有用的。
// 时间复杂度是很优秀了：n*long(n)
