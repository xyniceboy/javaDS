package bwang;

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

		arr.quickSort();
		arr.display();
	}
}

/*
 * ������ȡ�Ļ��ֵ㣬����ƫ�����ƫС����ʹ�����ݷֲ������ȣ�������ʹ�����ݾ����أ� �����ٽ�һ���Ż���ʹ����ȡһ���ӽ��м�ֵ�Ļ��ֻ����㡣����ȡ�м���Ľ�����һ����������
 * �뿴�� xupt ��
 */