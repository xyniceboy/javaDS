
public class BinarySearchApp {
	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray arr = new OrdArray(maxSize);
		
		//���Բ��롢��ʾ
		arr.insert(72);
		arr.insert(94);
		arr.insert(23);
		arr.insert(57);
		arr.insert(12);
		arr.insert(48);
		arr.insert(201);
		arr.insert(102);
		arr.insert(27);
		arr.insert(105);
		arr.insert(63);
		arr.insert(38);
		arr.insert(4);
		arr.display();
		
		//�� ����
		int searchKey = 105;
		if(arr.find(searchKey) != arr.size())  //�ҵ���
			System.out.println("Found " + searchKey);
		else 
			System.out.println("Cann't found " + searchKey);
	}
}
