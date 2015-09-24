import java.io.*;
import java.util.*;

import sun.security.krb5.internal.LocalSeqNumber;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	// 插入一个节点
	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if (root == null) // 树是空的
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) { // 小于
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else { // 大于
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			} // while
		}
	} // if

	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			} // 找到或者没找到

			if (current == null)
				return false; // 没有找到要删除的节点
		} // while

		// 上移要根据父节点的情况，父节点是 左节点？ 右节点？
		if (current.leftChild == null && current.rightChild == null) {// 删除的是叶子节点
			if (current == root) // 删除的是根节点，并且没有子节点
				root = null;
			else if (isLeftChild) // 删除的叶子节点是父节点的左子节点
				parent.leftChild = null;
			else
				parent.rightChild = null;
		} else if (current.rightChild == null) { // 要删除的节点只有一个左子节点
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		} else if (current.leftChild == null) { // 删除的节点只有一个右子节点
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		} else { // 删除的节点有两个子节点
			Node successor = getSuccessor(current); // 从当前删除节点找继承人
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;

			successor.leftChild = current.leftChild; // 等于删除的左子节点
		}
		return true;
	}

	// 向右子节点下找继承者节点
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;

		while (current != null) { // 一直找到左子节点的左子节点的左子节点.......,因为它就是继承者
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != delNode.rightChild) { // 那就是左边
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}

		return successor; // 返回继承者
	}

	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData)
				current = current.leftChild;
			else
				current = current.rightChild;

			if (current == null)
				return null;
		}
		return current;
	}

	// 遍历，依次访问，把每个节点都访问到
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			// 从上至下，从左至右
			System.out.print("\nPreder traversal: ");
			preOrder(root);
			break;
		case 2: // 从下至上，从左至右 (从大到小)
			System.out.print("\nInorder traversal: ");
			inOrder(root);
			break;
		case 3: // 从下至上，从右到左的遍历
			System.out.println("\nPostOrder traveral: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	public void preOrder(Node localRoot) { // 从上到下，从左到右的遍历
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	public void inOrder(Node localRoot) { // 从上到下，从左到右的遍历(从小到大)
		if (localRoot != null) { //
			inOrder(localRoot.leftChild); // 递归判断左孩子完事
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	public void postOrder(Node localRoot) { // 从下至上，从右到左的遍历
		if (localRoot != null) { //
			postOrder(localRoot.rightChild);
			postOrder(localRoot.leftChild); // 递归判断左孩子完事
			System.out.print(localRoot.iData + " "); // 递归完后，再反转

		}
	}

	public void displayTree() {
		// 因为要用到栈，所以引入 java.io.*; java.util.*;两个包
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("----------------------------------------------------------------------------------------");

		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++)
				System.out.print(" "); // 控制输出32个空格
			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				}else{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(" ");
			}//while
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false) {  //localStack 不为空。  本地栈依次弹出
				globalStack.push(localStack.pop()); //依次取出来，再放进去
			}
		}//while
		System.out.println("----------------------------------------------------------------------------------------");

	}
}


//注意两点：
//1, ctrl+d退出
/*2， 测试：
 * Enter first letter of show,insert,find,delete or traverse:s
----------------------------------------------------------------------------------------
                                50                                                              
                25                              75                              
        19              35              --              75              
    0      --      --      --      --      --      --      --      
----------------------------------------------------------------------------------------
Enter first letter of show,insert,find,delete or traverse:t
Enter type 1,2 or 3: 1

Preder traversal: 50 25 19 0 35 75 75 
Enter first letter of show,insert,find,delete or traverse:t
Enter type 1,2 or 3: 2

Inorder traversal: 0 19 25 35 50 75 75 
Enter first letter of show,insert,find,delete or traverse:t
Enter type 1,2 or 3: 3

PostOrder traveral: 
0 19 35 25 75 75 50 
Enter first letter of show,insert,find,delete or traverse:i
Enter value to insert:72
Enter first letter of show,insert,find,delete or traverse:s
----------------------------------------------------------------------------------------
                                50                                                              
                25                              75                              
        19              35              72              75              
    0      --      --      --      --      --      --      --      
----------------------------------------------------------------------------------------
Enter first letter of show,insert,find,delete or traverse:i
Enter value to insert:73
Enter first letter of show,insert,find,delete or traverse:s
----------------------------------------------------------------------------------------
                                50                                                              
                25                              75                              
        19              35              72              75              
    0      --      --      --      --      73      --      --      
----------------------------------------------------------------------------------------
Enter first letter of show,insert,find,delete or traverse:d
Enter value to delete:75
Deleted 75
Enter first letter of show,insert,find,delete or traverse:s
----------------------------------------------------------------------------------------
                                50                                                              
                25                              75                              
        19              35              72              --              
    0      --      --      --      --      73      --      --      
----------------------------------------------------------------------------------------
Enter first letter of show,insert,find,delete or traverse:d
Enter value to delete:75
Deleted 75
Enter first letter of show,insert,find,delete or traverse:s
----------------------------------------------------------------------------------------
                                50                                                              
                25                              72                              
        19              35              --              73              
    0      --      --      --      --      --      --      --      
----------------------------------------------------------------------------------------
Enter first letter of show,insert,find,delete or traverse:d
Enter value to delete:52
Cann't find 52
Enter first letter of show,insert,find,delete or traverse:
 * */
