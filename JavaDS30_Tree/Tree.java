import java.io.*;
import java.util.*;

import sun.security.krb5.internal.LocalSeqNumber;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	// ����һ���ڵ�
	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;
		if (root == null) // ���ǿյ�
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) { // С��
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else { // ����
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
			} // �ҵ�����û�ҵ�

			if (current == null)
				return false; // û���ҵ�Ҫɾ���Ľڵ�
		} // while

		// ����Ҫ���ݸ��ڵ����������ڵ��� ��ڵ㣿 �ҽڵ㣿
		if (current.leftChild == null && current.rightChild == null) {// ɾ������Ҷ�ӽڵ�
			if (current == root) // ɾ�����Ǹ��ڵ㣬����û���ӽڵ�
				root = null;
			else if (isLeftChild) // ɾ����Ҷ�ӽڵ��Ǹ��ڵ�����ӽڵ�
				parent.leftChild = null;
			else
				parent.rightChild = null;
		} else if (current.rightChild == null) { // Ҫɾ���Ľڵ�ֻ��һ�����ӽڵ�
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		} else if (current.leftChild == null) { // ɾ���Ľڵ�ֻ��һ�����ӽڵ�
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		} else { // ɾ���Ľڵ��������ӽڵ�
			Node successor = getSuccessor(current); // �ӵ�ǰɾ���ڵ��Ҽ̳���
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;

			successor.leftChild = current.leftChild; // ����ɾ�������ӽڵ�
		}
		return true;
	}

	// �����ӽڵ����Ҽ̳��߽ڵ�
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;

		while (current != null) { // һֱ�ҵ����ӽڵ�����ӽڵ�����ӽڵ�.......,��Ϊ�����Ǽ̳���
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != delNode.rightChild) { // �Ǿ������
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}

		return successor; // ���ؼ̳���
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

	// ���������η��ʣ���ÿ���ڵ㶼���ʵ�
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			// �������£���������
			System.out.print("\nPreder traversal: ");
			preOrder(root);
			break;
		case 2: // �������ϣ��������� (�Ӵ�С)
			System.out.print("\nInorder traversal: ");
			inOrder(root);
			break;
		case 3: // �������ϣ����ҵ���ı���
			System.out.println("\nPostOrder traveral: ");
			postOrder(root);
			break;
		}
		System.out.println();
	}

	public void preOrder(Node localRoot) { // ���ϵ��£������ҵı���
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	public void inOrder(Node localRoot) { // ���ϵ��£������ҵı���(��С����)
		if (localRoot != null) { //
			inOrder(localRoot.leftChild); // �ݹ��ж���������
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	public void postOrder(Node localRoot) { // �������ϣ����ҵ���ı���
		if (localRoot != null) { //
			postOrder(localRoot.rightChild);
			postOrder(localRoot.leftChild); // �ݹ��ж���������
			System.out.print(localRoot.iData + " "); // �ݹ�����ٷ�ת

		}
	}

	public void displayTree() {
		// ��ΪҪ�õ�ջ���������� java.io.*; java.util.*;������
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("----------------------------------------------------------------------------------------");

		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++)
				System.out.print(" "); // �������32���ո�
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
			while(localStack.isEmpty() == false) {  //localStack ��Ϊ�ա�  ����ջ���ε���
				globalStack.push(localStack.pop()); //����ȡ�������ٷŽ�ȥ
			}
		}//while
		System.out.println("----------------------------------------------------------------------------------------");

	}
}


//ע�����㣺
//1, ctrl+d�˳�
/*2�� ���ԣ�
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
