package bwang;

public class SortedListApp {
	public static void main(String[] args) {
		SortedList theSortedList = new SortedList();
		
		//�����
		theSortedList.insert(20);
		theSortedList.insert(40);
		theSortedList.insert(60);
		theSortedList.displayList();
		theSortedList.insert(10);
		theSortedList.insert(30);
		theSortedList.insert(50);
		theSortedList.displayList();
		
		//��ɾ��
		theSortedList.remove();
		theSortedList.displayList();
	}
}

//С�᣺
//���һ��Ӧ����ҪƵ���Ĵ�ȡ��Сֵ��������Ҫ����Ĳ��롣��ô�������������һ���ܺõ�ѡ��
