/*
 * ������ȱ���(DFS) ����
 */
public class MSTApp {
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
		theGraph.addEdge(0, 4); //AD��
		theGraph.addEdge(1, 3); //BD��
		theGraph.addEdge(1, 2); //BD��
		theGraph.addEdge(2, 4); //BD��
		theGraph.addEdge(3, 4); //BD��
		
		System.out.print("Mininum spanning tree: ");
		theGraph.mst(); //��С�������㷨
		System.out.println();
	}
}


//MST����С���������ȿ��Ի��������ѡ����(�������������������)��Ҳ���Ի��ڹ����������