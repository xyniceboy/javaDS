
public class Heap {
	private Node[] heapArray;
	private int maxSize;  //所以整个树的元素个数是提前已知的。 bwang
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
	
	public Node remove(){ //删除根
		Node root = heapArray[0]; //表示根节点，也是最大项
		heapArray[0] = heapArray[--currentSize]; //把最后一个数据项先移动到根
		trickleDown(0);// 与新的根位置的数据项进行比较，并向下调整，直到比新根位置数据项小 
		
		return root; //删除的根节点
	} 
	
	public void trickleDown(int index){ //向下调整
		int largerChild;  //大的子节点位置
		Node top = heapArray[index]; //要向下调整的节点对象
		while(index < currentSize/2){  //如果未找到最后一层
			int leftChild = 2*index+1;
			int rightChild = leftChild + 1;
			if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
				largerChild = rightChild;
			else 
				largerChild = leftChild;
			if(top.getKey() >= heapArray[largerChild].getKey()) //找到位置，不用调换
				break;
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		} //while 完成！就找到位置了
		
		//找到位置，把最上面的放进去就可以了
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
		//以树状方式显示
		int nBlanks = 32;
		int itemsPerRow = 1;  //每一层的数量
		
		int column = 0;
		int j = 0;
		String dots = "................................";
		System.out.println(dots + dots);
		
		while(currentSize > 0){ //以树状显示
			if(column == 0){
				for(int k=0; k< nBlanks; k++)
					System.out.print(' ');
			}
			System.out.print(heapArray[j].getKey());
			
			if(++j==currentSize)  //全部打印完
				break;
			if(++column == itemsPerRow){  //这层数据项打印完
				nBlanks /= 2;
				itemsPerRow *= 2;//每层元素的个数
				column = 0;
				System.out.println();
			}else
				for(int k=0; k<nBlanks*2-2; k++)
					System.out.print(' ');
		}//while
		
		//输出结束提示
//		System.out.println(dots + dots);
		System.out.println("\n" + dots + dots);
	}
	
	//打印数组
	public void displayArray(){
		for(int j=0; j<maxSize; j++){
			System.out.print(heapArray[j].getKey() + " ");
		}
		System.out.println();
	}	

}


