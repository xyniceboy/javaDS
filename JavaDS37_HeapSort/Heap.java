
public class Heap {
	private Node[] heapArray;
	private int maxSize;  //������������Ԫ�ظ�������ǰ��֪�ġ� bwang
	private int currentSize;
	public Heap(int mx){
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}
	
	public boolean isEmtpy(){
		return currentSize == 0;
	}
	
	public void insertAt(int index, Node newNode){
		heapArray[index] = newNode;
	}
	
	public void increamentSize(){
		currentSize++;
	}
	
	public Node remove(){ //ɾ����
		Node root = heapArray[0]; //��ʾ���ڵ㣬Ҳ�������
		heapArray[0] = heapArray[--currentSize]; //�����һ�����������ƶ�����
		trickleDown(0);// ���µĸ�λ�õ���������бȽϣ������µ�����ֱ�����¸�λ��������С 
		
		return root; //ɾ���ĸ��ڵ�
	} 
	
	public void trickleDown(int index){ //���µ���
		int largerChild;  //����ӽڵ�λ��
		Node top = heapArray[index]; //Ҫ���µ����Ľڵ����
		while(index < currentSize/2){  //���δ�ҵ����һ��
			int leftChild = 2*index+1;
			int rightChild = leftChild + 1;
			if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
				largerChild = rightChild;
			else 
				largerChild = leftChild;
			if(top.getKey() >= heapArray[largerChild].getKey()) //�ҵ�λ�ã����õ���
				break;
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		} //while ��ɣ����ҵ�λ����
		
		//�ҵ�λ�ã���������ķŽ�ȥ�Ϳ�����
		heapArray[index] = top;
	}
	
	public void displayHeap(){
//		System.out.print("HeapArray:");
//		for(int m = 0; m < currentSize; m++)
//			if(heapArray[m] != null)
//				System.out.print(heapArray[m].getKey() + " ");
//			else
//				System.out.print("-- ");
//		System.out.println();
//		
		//����״��ʽ��ʾ
		int nBlanks = 32;
		int itemsPerRow = 1;  //ÿһ�������
		
		int column = 0;
		int j = 0;
		String dots = "................................";
		System.out.println(dots + dots);
		
		while(currentSize > 0){ //����״��ʾ
			if(column == 0){
				for(int k=0; k< nBlanks; k++)
					System.out.print(' ');
			}
			System.out.print(heapArray[j].getKey());
			
			if(++j==currentSize)  //ȫ����ӡ��
				break;
			if(++column == itemsPerRow){  //����������ӡ��
				nBlanks /= 2;
				itemsPerRow *= 2;//ÿ��Ԫ�صĸ���
				column = 0;
				System.out.println();
			}else
				for(int k=0; k<nBlanks*2-2; k++)
					System.out.print(' ');
		}//while
		
		//���������ʾ
//		System.out.println(dots + dots);
		System.out.println("\n" + dots + dots);
	}
	
	//��ӡ����
	public void displayArray(){
		for(int j=0; j<maxSize; j++){
			System.out.print(heapArray[j].getKey() + " ");
		}
		System.out.println();
	}	

}


