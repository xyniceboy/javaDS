

public class HashTable {
	private SortedList[] hashArray;
	private int arraySize;
	
	public HashTable(int size){
		arraySize = size;
		hashArray = new SortedList[arraySize];
		
		for(int j = 0; j < arraySize; j++){
			hashArray[j] = new SortedList();
		} //创建了一个长度为 arraySize的有序hashArray
	}
	
	public void displayTable(){
		for(int j = 0; j < arraySize; j++){
			System.out.print(j + ". ");
			hashArray[j].displayList();
		}
	}
	
	public int hashFunc(int key){
		return key%arraySize; //key有可能超过范围
	}
	
	public void insert(Link theLink){
		int key = theLink.getKey();  //得到键
		int hashVal = hashFunc(key);  //将键 哈希化 后 变成索引
		hashArray[hashVal].insert(theLink);  //将theLink插入到hashVal这个位置
	}
	
	public void delete(int key){
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	
	public Link find(int key){
		int hashVal = hashFunc(key);
		Link theLink = hashArray[hashVal].find(key);  
		
		return theLink;
	}
}
