package bwang;

//����������Ԫ�أ��ŵ������������ź����ٷŻ�Ԫ���顣��ʱ��ԭ���������������

public class ListInsertionSortApp {
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArray = new Link[size];
		
		for(int j = 0; j < size; j++){
			int n = (int) (java.lang.Math.random()*99);  //1, ����0~99֮������֣�2, ��Ϊ��double������Ҫת����
			
			//����һ���µ������ݵ����ڵ㡤������������������������������������������������������������������������������
			Link newLink = new Link(n);
			linkArray[j] = newLink;
		} //ѭ������������10����������ڵ���
		
		System.out.print("Unsorted array: ");
		for(int j = 0; j< size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println();  //���ˣ������������ʹ�ӡ������
		
		//������������ŵ���������
		SortedList theSortedList = new SortedList(linkArray);  
		theSortedList.displayList();
		
		//�����������Ԫ�أ�һ��һ���ķ���ԭ���� linkArray
		System.out.print("Sorted Array: ");
		for(int j=0; j < size; j++){
			linkArray[j] = theSortedList.remove();  //�Ƴ�����Զ������С�ġ�
		} //��ŵ�ԭ����
		
		for(int j = 0; j < size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println();  //ѭ����ӡԪ����(linkArray)Ԫ��
		
	}
}
