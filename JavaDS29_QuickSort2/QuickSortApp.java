package xupt;

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

// 可以不是3项，可以改成小数据项的插入排序
// 请看： xdup
