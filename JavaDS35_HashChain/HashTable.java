

public class HashTable {
	private SortedList[] hashArray;
	private int arraySize;
	
	public HashTable(int size){
		arraySize = size;
		hashArray = new SortedList[arraySize];
		
		for(int j = 0; j < arraySize; j++){
			hashArray[j] = new SortedList();
		} //������һ������Ϊ arraySize������hashArray
	}
	
	public void displayTable(){
		for(int j = 0; j < arraySize; j++){
			System.out.print(j + ". ");
			hashArray[j].displayList();
		}
	}
	
	public int hashFunc(int key){
		return key%arraySize; //key�п��ܳ�����Χ
	}
	
	public void insert(Link theLink){
		int key = theLink.getKey();  //�õ���
		int hashVal = hashFunc(key);  //���� ��ϣ�� �� �������
		hashArray[hashVal].insert(theLink);  //��theLink���뵽hashVal���λ��
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
