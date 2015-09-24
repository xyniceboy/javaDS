public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem; // ������ǲ����������˼��ɾ���˵�

	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}

	public void displayTable() {
		System.out.print("Table:");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null) {
				System.out.print(hashArray[j].getKey() + " ");
			} else {
				System.out.print("** ");
			}
		}
		System.out.println();
	}
	
	public int hashFunc1(int key){ //�״ι�ϣ
		return key%arraySize;  
	}
	
	/*
	 * ���ι�ϣ��Ҫ�󣬲��ܸ���һ��hash����ʽ��ͬ���������0��
	 * Ȼ����ר���Ѿ��о���һ����Ч�ļ��㷽�����Ƚϸ�Ч
	 * 
	 * stepSize = constant - (key%constant)
	 * constant ������(���ܱ�1�����������ĳ���)����С�����������
	 * 
	 * ����ȡ constant=5   ��ô 0 <= (key%constant) <= 4 ����> 1 <= {constant-(key%constant)} <= 5 
	 */
	public int hashFunc2(int key){
		return 5-key%5;
	}
	 
	public void insert(int key, DataItem item){
		int hashVal = hashFunc1(key);  //�״ι�ϣ�����±�λ��
		int stepSize = hashFunc2(key);  //�ٹ�ϣ���õ�̽�ⲽ��
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key){
		int hashVal = hashFunc1(key);  //�״ι�ϣ�õ��±�λ��
		int stepSize = hashFunc2(key);  //�ٹ�ϣ���õ�̽�ⲽ��
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey() == key){ //�ҵ���Ҫɾ����������
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;  //�ҵ�ɾ�������
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		} //while ��������û������˵��û�ҵ�
		
		return null;  //���ر�ʾû�ҵ�
	}
	
	public DataItem find(int key){
		int hashVal = hashFunc1(key);  //�״ι�ϣ�õ��±�λ��
		int stepSize = hashFunc2(key);  //�ٹ�ϣ���õ�̽�ⲽ��
		while(hashArray[hashVal] != null){  //�ǿղ� while
			if(hashArray[hashVal].getKey() == key){  //�ҵ���
				return hashArray[hashVal];
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}//while ��������û������˵��û�ҵ�
		return null;  //û�ҵ�
	}
}
