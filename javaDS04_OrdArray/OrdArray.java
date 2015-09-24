package javaDS04_OrdArray;


public class OrdArray {
	private long[] a;
	private int nElems;

	public OrdArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() { // �鿴��С��Ԫ�ظ���
		return nElems;
	}

	// ���ֲ��ҷ���
	public int find(long searchKey) {
		int lowBound = 0; // ��ʼ����
		int upperBound = nElems - 1; // ��������
		int curInt; // �м���ʱ

		while (true) {
			curInt = (lowBound + upperBound) / 2;
			if (a[curInt] == searchKey)
				return curInt;
			else if (lowBound > upperBound) // û���ҵ�
				return nElems;
			else {
				if (a[curInt] < searchKey) // ����
					lowBound = curInt + 1; // �ı���С����
				else
					// ��ǰ��
					upperBound = curInt - 1; // �ı��������
//				lowBound++;
//				upperBound--;
			}
		}
	}

	// ���������(���Բ���)
	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			// ���ȶ�λ���������ݵ�λ��
			if (a[j] > value)
				break;

		for (int k = nElems; k > j; k--)
			// ����
			a[k] = a[k - 1];

		a[j] = value; // �������ݣ������� 1
		nElems++;
	}

	// ɾ��������
	public boolean delete(long value) {
		int j = find(value); // �ȵ��ö��ֲ���ȥ��������
		if (j == nElems)
			return false;
		else {
			for (int k = j; k < nElems; k++)   // ��������ǰ�ƶ�������ɾ����Ԫ��
				a[k] = a[k + 1];
			
			nElems--;    // Ԫ���ܸ����� 1
			return true;
		}
	}

	// ��ʾ
	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}

}
