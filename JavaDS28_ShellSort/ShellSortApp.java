
public class ShellSortApp {
	public static void main(String[] args) {
		int maxSize = 20;
		ArraySh arr = new ArraySh(maxSize);
		
		//���Բ������������ʾ
		for(int j = 0; j < maxSize; j++){
//			long n = (int)java.lang.Math.random()*99;    //���ת����ִ���ˣ�����������ôת������ 0 * 99
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		
		//����ϣ������
		arr.shellSort();  
		System.out.println("======����ϣ������=======");
		arr.display();
	}
}
