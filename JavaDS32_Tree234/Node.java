
//对节点的定义
public class Node {
	private static final int ORDER = 4; // 最多可以有4个子节点
	private int numItems;
	private Node parent; // 父节点 
	private Node[] childArray = new Node[ORDER]; // 子节点
	private DataItem[] itemArray = new DataItem[ORDER - 1]; // 数据项数据组。 一个节点
															// 最多可以放3个数据项

	public Node getChild(int childNum) { // 因为要拆分，所以需要知道
											// 子节点(getChild)、父节点(getParent)
		return childArray[childNum];
	}

	public Node getParent() { // 取父节点. 但是叶子节点和父节点之间还没有建立起联系啊？？？？？？？
		return parent;
	}

	// 如果这个节点有数据，那么这个数据项肯定放到叶子节点的第一个数据项里
	public boolean isLeaf() {
		// return (getChild(0)==null ? true : false);
		return (getChild(0) == null);
	}

	public int getNumItems() { // 取数据项个数
		return numItems;
	}

	public DataItem getItem(int index) { // 取某个数据项
		return itemArray[index];
	}

	public boolean isFull() { // 一个节点中的数据项 是否满？？
		// return (numItems == ORDER-1) ? true : false; //这样也可以
		return (numItems == ORDER - 1);
	}

	// 连接子节点 这个在分裂的时候，需要用到
	/*
	 * @param： childNum 在子节点中的位置，序号是多少
	 * 
	 * @param： child 子节点
	 */
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null) // 如果子节点不是空，将子节点的父节点设置成当前节点。
			child.parent = this;
	}

	// 拆分过程中，也有可能将子节点从当前的数据线中剔除掉
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum]; // 因为要返回，所以先记录一个临时变量
		childArray[childNum] = null;

		return tempNode;
	}

	// 可能删除、可能插入数据。都需要查找
	public int findItem(long key) {
		for (int j = 0; j < ORDER - 1; j++) {
			if (itemArray[j] == null) // 找到就返回
				break;
			else if (itemArray[j].dData == key)
				return j; // 找到， 则返回数据的索引
		}
		return -1; // 没找到
	}

	// 插入数据项 —— 可定是往叶子节点里面插入 (最复杂的一个方法)
	public int insertItem(DataItem newItem) { // 能插入，每个节点不可能存三个，最多存2个
		numItems++; // 数量增加
		long newKey = newItem.dData; // 新增加的（待插入）的数据
		for (int j = ORDER - 2; j >= 0; j--) {
			if (itemArray[j] == null)
				continue; // 如果不存在继续循环找
			else {
				long itsKey = itemArray[j].dData; // 从数据项中拿出来的数据
				if (newKey < itsKey)
					itemArray[j + 1] = itemArray[j]; // 往后挪动数据。准备插入数据，因为此时肯定有空缺，前面已经有判断，
				// 如果满了是不能往里插入数据的。也就是说，不满才可以往里插
				else { // 不用挪动数据了
					itemArray[j + 1] = newItem; // 直接插入数据
					return j + 1;
				}
			}
		} // for
		itemArray[0] = newItem;
		return 0;
	}

	// 删除数据项
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems - 1]; // 拿到这个子节点的数据项
		itemArray[numItems - 1] = null; // 将此位置情况
		numItems--;
		return temp;
	}

	public void displayNode() {
		for (int j = 0; j < numItems; j++)
			itemArray[j].displayItem();
		System.out.println("/");
	}
}
