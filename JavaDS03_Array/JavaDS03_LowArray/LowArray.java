package JavaDS03_LowArray;

public class LowArray {
	private long[] a;  // ����һ���洢���������
	
	//���캯��
	public LowArray(int size){
		a = new long[size];
	}
	
	//����Ԫ��ֵ
	public void setElem(int index, long value){
		a[index] = value;
	}
	
	//����Ԫ��
	public long getElem(int index){
		return a[index];
	}
}
