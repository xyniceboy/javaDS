/*
 * ���ȼ�����
 */
public class PriorityQ {
	private final int SIZE = 20;
	private Edge[] queArray;
	private int size; //��ǰ������
	
	public PriorityQ(){
		queArray = new Edge[SIZE];
		size = 0;
	}
	
	//����ı߶���
	public void insert(Edge item) { 
		int j;
		for(j=0; j<size; j++)
			if(item.distance >= queArray[j].distance) //�ҵ������洢��λ��
				break;
		//ѭ������
		for(int k = size-1; k >= j; k--)
			queArray[k+1] = queArray[k];
		
		//�������
		queArray[j] = item;
		size++;
	}
	
	//ɾ����С��һ����
	public Edge removeMin(){
		return queArray[--size];
	}
	
	//ɾ��ָ��λ�õ�һ����
	public void removeN(int n){
		for(int j = n; j < size-1; j++)
			queArray[j] = queArray[j+1];
		size--;
	}
	
	//�鿴��Сһ����
	public Edge peekMin(){
		return queArray[size-1];
	}
	
	//�鿴ָ��λ�õ�һ����
	public Edge peekN(int n){
		return queArray[n];
	}
	
	//�鿴��ǰ�ߵ�����
	public int size(){
		return size;
	}
	
	//���ͼ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	
	//����ָ��һ��������Ϊ�յ�ıߡ� 
	//return: ���صĲ��������ߵĶ��󣬶����ڶ����е�λ��
	public int find(int findDex){
		for(int j = 0; j < size; j++)
			if(queArray[j].destVert == findDex)
				return j;
		
		return -1; //���ѭ���������ˣ���û�ҵ����ͷ��ظ� -1
	}
}
