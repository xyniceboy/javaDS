package bwang;
/*
 * ������ȱ���(BFS) ����
 */
public class BFSApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		//��ʼ������
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');		

		//���ӱ�
		theGraph.addEdge(0, 1); //AB��
		theGraph.addEdge(0, 2); //AC��
		theGraph.addEdge(0, 3); //AD��
		theGraph.addEdge(1, 3); //BD��
		theGraph.addEdge(3, 4); //CE��
		
		System.out.print("Visits: ");
		theGraph.bfs(); //���ù����������
		System.out.println();
	}
}

//�ο���word ���� �С�ͼ���ڽӾ��󡱵��Ǹ�ͼ