package xupt;

public class QuickSortApp {
	public static void main(String[] args) {
		int maxSize = 16;

		// ���Բ��롢��ʾ
		ArrayIns arr = new ArrayIns(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort(); //��������ȡ�л��ֿ�������
		arr.display();
	}
}

// ���Բ���3����Ըĳ�С������Ĳ�������
// �뿴�� xdup
