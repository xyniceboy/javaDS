
public class LinkListApp {
	public static void main(String[] args) {
		LinkList theList = new LinkList();
		
		//�����
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		theList.displayList();
		
		//��ɾ��
		while(!theList.isEmpty()){
			Link aLink = theList.deleteFisrt();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println();
		}
		theList.displayList();  //������������ǲ��ǿ���
	}
}