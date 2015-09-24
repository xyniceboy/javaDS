//������
public class Tree234 {
	private Node root = new Node();

	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1) // �ҵ��ˣ�������λ��
				return childNumber; // �ҵ�֮��ֱ�� return
			else if (curNode.isLeaf()) // ��ǰ�ڵ���Ҷ�ӽڵ㣬û���ҵ� ���� -1
				return -1;
			else
				curNode = getNextChild(curNode, key); // �����ǰ�ڵ�û�ҵ�����ȥ�������ӽڵ���
		}
	}

	// �õ���һ���ڵ�
	/*
	 * @param theNode ��ʾ��ǰ�ڵ�
	 * 
	 * @param theValue ��ʾ���ҵ�ֵ
	 */
	public Node getNextChild(Node theNode, long theValue) {
		int j;
		int numItems = theNode.getNumItems(); // ȡ�������������ȡֵ 2��3��4
		for (j = 0; j < numItems; j++) {
			if (theValue < theNode.getItem(j).dData)
				return theNode.getChild(j); // ���ڻ���� ��ֱ�ӷ���
		}
		return theNode.getChild(j); // �����һ������
	}

	// ����
	public void insert(long dVlaue) { // ����������
		Node curNode = root; // ����ʱ���һ����ʱָ��
		DataItem tempItem = new DataItem(dVlaue); // ʵ������Ҫ��������������
		while (true) {
			if (curNode.isFull()) {
				split(curNode); // ��ֽڵ�
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, dVlaue); // �ҵ���ǰ������(������������Ӧ�ò鵽ʲôλ��)
			} else if (curNode.isLeaf()) { // �����ǰ�ڵ���Ҷ�ڵ㣬����δ��
				break; // �ҵ���Ҫ��������ݵĽڵ�
			} else
				curNode = getNextChild(curNode, dVlaue);
		}

		curNode.insertItem(tempItem);
	}

	/*
	 * ���һ�����Ľڵ�(��һ������3��������)��˼·���ǣ��м�������Ҫ�����ڵ㣬����������Ҫ���ӽڵ�
	 */
	public void split(Node thisNode) { // ��ֽڵ�
		DataItem itemB, itemC; // ԭ�ڵ��е����ݵڶ�������������
		Node parent, child2, child3; // ������¼��ֺ�Ľڵ�
		int itemIndex; // ������¼�����������

		itemC = thisNode.removeItem(); // �ڵ�������������
		itemB = thisNode.removeItem(); // �ڵ����м��������
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);

		Node newRight = new Node();
		if (thisNode == root) { // ����Ǹ��ڵ�
			root = new Node(); // ����˵ �������ӽڵ�
			parent = root;
			root.connectChild(0, thisNode);
		} else {
			parent = thisNode.getParent();
		}
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		for (int j = n; j > itemIndex; j--) {
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}
		// ʵ���ϣ�����ԭ���Ķ���һ�������Ҳ����һ���ӽڵ�
		
		parent.connectChild(itemIndex+1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	
	public void displayTree(){
		recDisplayTree(root, 0, 0);
	}
	
	/*
	 * @param thisNode ��ǰ�ڵ�
	 * @param level ����
	 * @param childNumber �ڼ����ӽڵ�
	 */
	private void recDisplayTree(Node thisNode, int level, int childNumber){
		System.out.print("level=" + level + " child=" + childNumber + " ");
		
		thisNode.displayNode();//���ýڵ��Լ��Ĵ�ӡ����
		
		//��Ϊ��֪���ж��ٸ��ڵ㣬���õݹ�ķ�ʽ
		int numItems = thisNode.getNumItems();  //ȡ���ݸ���
		for(int j=0; j<numItems+1; j++){
			Node nextNode = thisNode.getChild(j);
			if(nextNode != null) //����Ҷ�ӽڵ�  
				recDisplayTree(nextNode, level+1, j); //���²�ڵ�ݹ�
			else 
				return;
		}
	}
}
