/*
 * ������ȱ���(DFS) ����
 */
public class TopoApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		//��ʼ������
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		theGraph.addVertex('G');
		theGraph.addVertex('H');

		//���ӱ�
		theGraph.addEdge(0, 3); //AD��
		theGraph.addEdge(0, 4); //AE��
		theGraph.addEdge(1, 4); //BE��
		theGraph.addEdge(2, 5); //CF��
		theGraph.addEdge(3, 6); //DG��
		theGraph.addEdge(4, 6); //EG��
		theGraph.addEdge(5, 7); //FH��
		theGraph.addEdge(6, 7); //GH��
		
//		System.out.print("Vertex-Graph topo Sorted: ");
		theGraph.topo(); //����ͼ����������
		System.out.println();
	}
}


//Topologically sorted order:BAEDGCFH