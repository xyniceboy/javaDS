
public class FirstLastApp {
	public static void main(String[] args) {
		FirstLastList theList = new FirstLastList();
		
		//����ǰ����ͺ�����Ƿ���ȷ
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);
		theList.displayList();
		
		//����ɾ��
		theList.deleteFirst();
		theList.deleteFirst();
		theList.deleteFirst();
		theList.displayList();
	}
}	
