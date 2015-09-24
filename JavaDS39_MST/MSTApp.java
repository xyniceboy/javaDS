/*
 * 深度优先遍历(DFS) 测试
 */
public class MSTApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		//初始化顶点
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');

		//连接边
		theGraph.addEdge(0, 1); //AB边
		theGraph.addEdge(0, 2); //AC边
		theGraph.addEdge(0, 3); //AD边
		theGraph.addEdge(0, 4); //AD边
		theGraph.addEdge(1, 3); //BD边
		theGraph.addEdge(1, 2); //BD边
		theGraph.addEdge(2, 4); //BD边
		theGraph.addEdge(3, 4); //BD边
		
		System.out.print("Mininum spanning tree: ");
		theGraph.mst(); //最小生成树算法
		System.out.println();
	}
}


//MST（最小生成树）既可以基于深度优选搜索(本例基于深度优先搜索)，也可以基于广度优先搜索