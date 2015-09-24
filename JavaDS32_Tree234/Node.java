
//�Խڵ�Ķ���
public class Node {
	private static final int ORDER = 4; // ��������4���ӽڵ�
	private int numItems;
	private Node parent; // ���ڵ� 
	private Node[] childArray = new Node[ORDER]; // �ӽڵ�
	private DataItem[] itemArray = new DataItem[ORDER - 1]; // �����������顣 һ���ڵ�
															// �����Է�3��������

	public Node getChild(int childNum) { // ��ΪҪ��֣�������Ҫ֪��
											// �ӽڵ�(getChild)�����ڵ�(getParent)
		return childArray[childNum];
	}

	public Node getParent() { // ȡ���ڵ�. ����Ҷ�ӽڵ�͸��ڵ�֮�仹û�н�������ϵ����������������
		return parent;
	}

	// �������ڵ������ݣ���ô���������϶��ŵ�Ҷ�ӽڵ�ĵ�һ����������
	public boolean isLeaf() {
		// return (getChild(0)==null ? true : false);
		return (getChild(0) == null);
	}

	public int getNumItems() { // ȡ���������
		return numItems;
	}

	public DataItem getItem(int index) { // ȡĳ��������
		return itemArray[index];
	}

	public boolean isFull() { // һ���ڵ��е������� �Ƿ�������
		// return (numItems == ORDER-1) ? true : false; //����Ҳ����
		return (numItems == ORDER - 1);
	}

	// �����ӽڵ� ����ڷ��ѵ�ʱ����Ҫ�õ�
	/*
	 * @param�� childNum ���ӽڵ��е�λ�ã�����Ƕ���
	 * 
	 * @param�� child �ӽڵ�
	 */
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null) // ����ӽڵ㲻�ǿգ����ӽڵ�ĸ��ڵ����óɵ�ǰ�ڵ㡣
			child.parent = this;
	}

	// ��ֹ����У�Ҳ�п��ܽ��ӽڵ�ӵ�ǰ�����������޳���
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum]; // ��ΪҪ���أ������ȼ�¼һ����ʱ����
		childArray[childNum] = null;

		return tempNode;
	}

	// ����ɾ�������ܲ������ݡ�����Ҫ����
	public int findItem(long key) {
		for (int j = 0; j < ORDER - 1; j++) {
			if (itemArray[j] == null) // �ҵ��ͷ���
				break;
			else if (itemArray[j].dData == key)
				return j; // �ҵ��� �򷵻����ݵ�����
		}
		return -1; // û�ҵ�
	}

	// ���������� ���� �ɶ�����Ҷ�ӽڵ�������� (��ӵ�һ������)
	public int insertItem(DataItem newItem) { // �ܲ��룬ÿ���ڵ㲻���ܴ�����������2��
		numItems++; // ��������
		long newKey = newItem.dData; // �����ӵģ������룩������
		for (int j = ORDER - 2; j >= 0; j--) {
			if (itemArray[j] == null)
				continue; // ��������ڼ���ѭ����
			else {
				long itsKey = itemArray[j].dData; // �����������ó���������
				if (newKey < itsKey)
					itemArray[j + 1] = itemArray[j]; // ����Ų�����ݡ�׼���������ݣ���Ϊ��ʱ�϶��п�ȱ��ǰ���Ѿ����жϣ�
				// ��������ǲ�������������ݵġ�Ҳ����˵�������ſ��������
				else { // ����Ų��������
					itemArray[j + 1] = newItem; // ֱ�Ӳ�������
					return j + 1;
				}
			}
		} // for
		itemArray[0] = newItem;
		return 0;
	}

	// ɾ��������
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems - 1]; // �õ�����ӽڵ��������
		itemArray[numItems - 1] = null; // ����λ�����
		numItems--;
		return temp;
	}

	public void displayNode() {
		for (int j = 0; j < numItems; j++)
			itemArray[j].displayItem();
		System.out.println("/");
	}
}
