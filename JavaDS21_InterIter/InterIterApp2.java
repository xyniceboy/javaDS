
public class InterIterApp2 {
	public static void main(String[] args) {
		LinkList theList = new LinkList();
		ListIterator iter1 = theList.getIterator();
		iter1.insertAfter(21);
		iter1.insertAfter(40);
		iter1.insertAfter(60);
		iter1.insertAfter(45);
		iter1.insertAfter(3);
//		iter1.insertAfter(6);
//		iter1.insertAfter(9);
		theList.displayList();
		
		//����ɾ����ǰ�ڵ�ķ���
		iter1.reset();  //��ָ���Ƶ�����ĵ�һ���ڵ�
		Link aLink = iter1.getCurrent(); //����ָ��aLinkָ�� ��ǰ�ڵ�
		if(aLink.dData%3 == 0)  //// �����ǰ�ڵ����ֵ�� 3 �ı�������ѵ�ǰ�ڵ�ɾ��
			iter1.deleteCurrent();
		
		//�����������������Ƿ��� 3 �ı���
/*		while(!iter1.atEnd()){
			iter1.nextLink();
			aLink = iter1.getCurrent();
			if(aLink.dData%3 == 0)
				iter1.deleteCurrent();
		}*/
		
		do{
			iter1.nextLink();
			aLink = iter1.getCurrent();
			if(aLink.dData%3 == 0)
				iter1.deleteCurrent();
		}while(!iter1.atEnd());

		theList.displayList();
	}
}
/*
21 40 60 45 3 6 9 
40 6 

21 40 60 45 3 6 
40 45 6 

21 40 60 45 3 
40 

21 40 60 45 
40 45 

21 40 60 
40 
 * */
