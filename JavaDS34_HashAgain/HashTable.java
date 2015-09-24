public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem; // 用来标记不是数据项。意思是删除了的

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
	
	public int hashFunc1(int key){ //首次哈希
		return key%arraySize;  
	}
	
	/*
	 * 二次哈希有要求，不能跟第一次hash处理方式相同，不能输出0。
	 * 然而，专家已经研究了一个有效的计算方法，比较高效
	 * 
	 * stepSize = constant - (key%constant)
	 * constant 是质数(仅能被1和自身整除的常数)，且小于数组的容量
	 * 
	 * 比如取 constant=5   那么 0 <= (key%constant) <= 4 ——> 1 <= {constant-(key%constant)} <= 5 
	 */
	public int hashFunc2(int key){
		return 5-key%5;
	}
	 
	public void insert(int key, DataItem item){
		int hashVal = hashFunc1(key);  //首次哈希到的下标位置
		int stepSize = hashFunc2(key);  //再哈希，得到探测步长
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key){
		int hashVal = hashFunc1(key);  //首次哈希得到下标位置
		int stepSize = hashFunc2(key);  //再哈希，得到探测步长
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].getKey() == key){ //找到了要删除的数据项
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;  //找到删除项，返回
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		} //while 结束。都没跳出，说明没找到
		
		return null;  //返回表示没找到
	}
	
	public DataItem find(int key){
		int hashVal = hashFunc1(key);  //首次哈希得到下标位置
		int stepSize = hashFunc2(key);  //再哈希，得到探测步长
		while(hashArray[hashVal] != null){  //非空才 while
			if(hashArray[hashVal].getKey() == key){  //找到了
				return hashArray[hashVal];
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}//while 结束。都没跳出，说明没找到
		return null;  //没找到
	}
}
