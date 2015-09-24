public class RBTreeTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RBTree rbTree = new RBTree();
		System.out.println("-----------------初始一个RBTree--------------");
		rbTree.rbInsert(new Node(41));
		rbTree.rbInsert(new Node(38));
		rbTree.rbInsert(new Node(31));
		rbTree.rbInsert(new Node(12));
		rbTree.rbInsert(new Node(19));
		rbTree.rbInsert(new Node(8));
		rbTree.printTree();

		System.out.println("-----------------删除节点(19)--------------");
		rbTree.rbDelete(19);
		rbTree.printTree();

	}
}

//参考：http://blog.csdn.net/skylinesky/article/details/6610950 