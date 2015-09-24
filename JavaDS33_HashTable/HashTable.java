public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1); // ��ʱ��һ�� -1
	}

	public void displayTable() {
		System.out.print("Table:");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null) // ����
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		} // ��hash���������ȫ����ʾ��û�����ݵ���*�Ŵ���
		System.out.println();
	}

	public int hashFunc(int key) { // ����hash���������±�
		return key % arraySize;
	}

	public void insert(DataItem item) {
		int key = item.getKey(); // ȡ���ļ�����ת����hashֵ
		int hashValue = hashFunc(key); // hash�����hashֵ��Ҳ���������±�
		while (hashArray[hashValue] != null
				&& hashArray[hashValue].getKey() != -1) {
			// hashArray[hashValue] != null����ʾ����ʾ���λ�ñ����������ռ����
			// hashArray[hashValue].getKey() != -1���ο�nonItem����ʾ�����λ��û�б�ɾ������Ϊɾ������
			// -1
			hashValue++; // �п��ܳ�������arraySize�������ٽ�һ��ȡ��
			hashValue = hashValue % arraySize;
		}// while������ʾ�ҵ���������λ����
			// �Ǿ͸����λ�ô�ֵ����
		hashArray[hashValue] = item;
	}

	public DataItem delete(int key) {
		int hashValue = hashFunc(key); // hash��
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) { // �ҵ�Ҫɾ���������ˣ�
				DataItem temp = hashArray[hashValue];
				hashArray[hashValue] = nonItem; // ������nonItem = new
												// DataItem(-1); //��ʱ��һ�� -1

				return temp; // �ҵ��ˣ���������ɾ�������ֵ
			}
			hashValue++; // ��Ϊû���ҵ������Ծ���Ҫ����������
			hashValue = hashValue % arraySize; // ÿ�ӹ�֮��Ϊ��ֹ�����������Ҫ����
		}
		return null; // ��ʾû���ҵ����˳�
	}

	public DataItem find(int key) {
		int hashValue = hashFunc(key);
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) { // ��ʾ�ҵ���
				return hashArray[hashValue];
			} 			
			
			hashValue++; // ��Ϊû���ҵ������Ծ���Ҫ����������
			hashValue = hashValue % arraySize; // ÿ�ӹ�֮��Ϊ��ֹ�����������Ҫ����
		}
		return null; // ��ʾû�ҵ�
	}
}
