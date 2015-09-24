public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;

	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1); // 暂时给一个 -1
	}

	public void displayTable() {
		System.out.print("Table:");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null) // 存在
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		} // 把hash表里的内容全部显示，没有内容的用*号代替
		System.out.println();
	}

	public int hashFunc(int key) { // 计算hash化后，数组下标
		return key % arraySize;
	}

	public void insert(DataItem item) {
		int key = item.getKey(); // 取它的键，且转换成hash值
		int hashValue = hashFunc(key); // hash化后的hash值，也就是数组下标
		while (hashArray[hashValue] != null
				&& hashArray[hashValue].getKey() != -1) {
			// hashArray[hashValue] != null，表示：表示这个位置被别的数据项占用了
			// hashArray[hashValue].getKey() != -1，参考nonItem，表示，这个位置没有被删除，因为删除后视
			// -1
			hashValue++; // 有可能超过上限arraySize，可以再进一步取余
			hashValue = hashValue % arraySize;
		}// while结束表示找到这个插入的位置了
			// 那就给这个位置存值即可
		hashArray[hashValue] = item;
	}

	public DataItem delete(int key) {
		int hashValue = hashFunc(key); // hash化
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) { // 找到要删除的数据了！
				DataItem temp = hashArray[hashValue];
				hashArray[hashValue] = nonItem; // 调用了nonItem = new
												// DataItem(-1); //暂时给一个 -1

				return temp; // 找到了，并返回了删除的这个值
			}
			hashValue++; // 因为没有找到，所以就需要继续往下找
			hashValue = hashValue % arraySize; // 每加过之后，为防止数组溢出，需要求余
		}
		return null; // 表示没有找到，退出
	}

	public DataItem find(int key) {
		int hashValue = hashFunc(key);
		while (hashArray[hashValue] != null) {
			if (hashArray[hashValue].getKey() == key) { // 表示找到了
				return hashArray[hashValue];
			} 			
			
			hashValue++; // 因为没有找到，所以就需要继续往下找
			hashValue = hashValue % arraySize; // 每加过之后，为防止数组溢出，需要求余
		}
		return null; // 表示没找到
	}
}
