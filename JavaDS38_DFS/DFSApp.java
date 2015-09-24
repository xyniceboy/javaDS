/*
 * 深度优先遍历(DFS) 测试
 */
public class DFSApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		//初始化顶点
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');

		//连接边
		theGraph.addEdge(0, 1); //AB边
		theGraph.addEdge(0, 2); //AC边
		theGraph.addEdge(0, 3); //AD边
		theGraph.addEdge(1, 3); //BD边
		
		System.out.print("Visits: ");
		theGraph.dfs();
		System.out.println();
	}
}

//参考：word 里面 有“图的邻接矩阵”的那个图