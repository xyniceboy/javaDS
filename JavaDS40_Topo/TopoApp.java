/*
 * 深度优先遍历(DFS) 测试
 */
public class TopoApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		//初始化顶点
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		theGraph.addVertex('G');
		theGraph.addVertex('H');

		//连接边
		theGraph.addEdge(0, 3); //AD边
		theGraph.addEdge(0, 4); //AE边
		theGraph.addEdge(1, 4); //BE边
		theGraph.addEdge(2, 5); //CF边
		theGraph.addEdge(3, 6); //DG边
		theGraph.addEdge(4, 6); //EG边
		theGraph.addEdge(5, 7); //FH边
		theGraph.addEdge(6, 7); //GH边
		
//		System.out.print("Vertex-Graph topo Sorted: ");
		theGraph.topo(); //有向图的拓扑排序
		System.out.println();
	}
}


//Topologically sorted order:BAEDGCFH