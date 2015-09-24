
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
	
	public boolean insert(int key){
		if(currentSize == maxSize)  //����
			return false;
		Node newNode = new Node(key); 
		heapArray[currentSize] = newNode;  //�½ڵ�ŵ����
		trickleUP(currentSize); //���½ڵ���бȽ����ϵ���
		currentSize++;
		return true;  //�����ɹ�
	}
	
	public void trickleUP(int index){ //���ϵ���
		int parent = (index-1)/2;
		Node bottom = heapArray[index];
		while(index>0 && heapArray[parent].getKey() < bottom.getKey()){
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		} //while �󣬾��ҵ�����Ҫ�������ݵ�λ��
		heapArray[index] = bottom;
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
			int rightChild = leftChild +1;
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
	
	//�ı�ڵ����ȼ�
	public boolean change(int index, int newValue){
		if(index < 0 || index>=currentSize){  //��Чλ��
			return false;
		}
		
		int oldValue = heapArray[index].getKey();
		heapArray[index].setKey(newValue);  //�Ѵ�����Ԫ�طŵ� ��������
		
		if(oldValue < newValue)
			trickleUP(index);
		else
			trickleDown(index);
		return true;
	}
	
	public void displayHeap(){
		System.out.print("HeapArray:");
		for(int m = 0; m < currentSize; m++)
			if(heapArray[m] != null)
				System.out.print(heapArray[m].getKey() + " ");
			else
				System.out.print("-- ");
		System.out.println();
		
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
}
