
public class DoubleLinkedApp {
	public static void main(String[] args) {
		DoubleLinkedList theLink = new DoubleLinkedList();
		
		//���Դ�ͷ���롢β�����롢ָ��λ�ò���
		theLink.insertFirst(22);
		theLink.insertFirst(44);
		theLink.insertFirst(66);
		theLink.insertLast(11);
		theLink.insertLast(33);
		theLink.insertLast(55);
		theLink.insertAfter(44, 100); 
		theLink.insertAfter(33, 101);
		theLink.displayBackward(); //�Ӻ���ǰ��ʾ
		theLink.displayForward();  //��ǰ������ʾ
		
		//����ͷɾ����βɾ����ָ��Ԫ��ɾ��
		theLink.deleteFirst();
		theLink.deleteLast();
		theLink.deletekey(101);
		theLink.displayBackward();
		theLink.displayForward();
	}
}


//˫������ʵ����˫�˶��еĹ��ܣ����Դ�����һͷ���룬Ҳ���Դ�����һ��ɾ��