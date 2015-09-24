//构建树
public class Tree234 {
	private Node root = new Node();

	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1) // 找到了，返回了位置
				return childNumber; // 找到之后，直接 return
			else if (curNode.isLeaf()) // 当前节点是叶子节点，没有找到 返回 -1
				return -1;
			else
				curNode = getNextChild(curNode, key); // 如果当前节点没找到，就去拿它的子节点了
		}
	}

	// 拿到下一个节点
	/*
	 * @param theNode 表示当前节点
	 * 
	 * @param theValue 表示查找的值
	 */
	public Node getNextChild(Node theNode, long theValue) {
		int j;
		int numItems = theNode.getNumItems(); // 取数据项个数。可取值 2、3、4
		for (j = 0; j < numItems; j++) {
			if (theValue < theNode.getItem(j).dData)
				return theNode.getChild(j); // 大于或等于 ，直接返回
		}
		return theNode.getChild(j); // 把最后一个返回
	}

	// 插入
	public void insert(long dVlaue) { // 行增数据项
		Node curNode = root; // 遍历时候的一个临时指针
		DataItem tempItem = new DataItem(dVlaue); // 实例化需要插入的数据项对象
		while (true) {
			if (curNode.isFull()) {
				split(curNode); // 拆分节点
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, dVlaue); // 找到当前数据项(待插入的数据项，应该查到什么位置)
			} else if (curNode.isLeaf()) { // 如果当前节点是叶节点，而且未满
				break; // 找到了要插入的数据的节点
			} else
				curNode = getNextChild(curNode, dVlaue);
		}

		curNode.insertItem(tempItem);
	}

	/*
	 * 拆分一个满的节点(那一定是有3个数据项)，思路就是：中间数据项要做父节点，两边数据项要做子节点
	 */
	public void split(Node thisNode) { // 拆分节点
		DataItem itemB, itemC; // 原节点中的数据第二、三个数据项
		Node parent, child2, child3; // 用来记录拆分后的节点
		int itemIndex; // 用来记录数据项的索引

		itemC = thisNode.removeItem(); // 节点中最大的数据项
		itemB = thisNode.removeItem(); // 节点中中间的数据项
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);

		Node newRight = new Node();
		if (thisNode == root) { // 如果是根节点
			root = new Node(); // 就是说 不存在子节点
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
		// 实际上，比起原来的多了一个数据项，也多了一个子节点
		
		parent.connectChild(itemIndex+1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	
	public void displayTree(){
		recDisplayTree(root, 0, 0);
	}
	
	/*
	 * @param thisNode 当前节点
	 * @param level 层数
	 * @param childNumber 第几个子节点
	 */
	private void recDisplayTree(Node thisNode, int level, int childNumber){
		System.out.print("level=" + level + " child=" + childNumber + " ");
		
		thisNode.displayNode();//调用节点自己的打印方法
		
		//因为不知道有多少个节点，就用递归的方式
		int numItems = thisNode.getNumItems();  //取数据个数
		for(int j=0; j<numItems+1; j++){
			Node nextNode = thisNode.getChild(j);
			if(nextNode != null) //不是叶子节点  
				recDisplayTree(nextNode, level+1, j); //向下层节点递归
			else 
				return;
		}
	}
}
