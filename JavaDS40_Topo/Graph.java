public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList; // 顶点数组
	private int adjMat[][]; // 邻接矩阵
	private int nVerts; // 当顶点数量
	private char[] sortedArray; //排序的数组

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;

		for (int j = 0; j < MAX_VERTS; j++)
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0; //
		sortedArray = new char[MAX_VERTS];
	}

	// 添加顶点
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	// 添加边
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
//		adjMat[end][start] = 1;
	}

	// 显示顶点
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	//拓扑排序
	public void topo(){
		int orig_nVerts = nVerts;
		while(nVerts > 0){
			int currenVertex = noSuccessors();
			if(currenVertex == -1){ //找不到没有后继顶点的顶点了
				System.out.println("Error: Graph has cycles");
				return ; //退出方法
			}
			
			/*
			 * @param nVerts-1 表示最后一个
			 */
			sortedArray[nVerts-1] = vertexList[currenVertex].label;
			deleteVertex(currenVertex); //从图中删除当前顶点
		}
		
		System.out.print("Topologically sorted order:");
		for(int j = 0; j < orig_nVerts; j++)
			System.out.print(sortedArray[j]);
		System.out.println();
	}
	
	//查找图中没有后继顶点的顶点
	public int noSuccessors(){
		boolean isEdge;
		for(int row = 0; row < nVerts; row++){
			isEdge = false;
			for(int col = 0; col < nVerts; col++){
				if(adjMat[row][col] > 0){
					isEdge = true;
					break;  
				}
			}
			if(!isEdge)
				return row;
		}
		return -1; //没有找到没有后继顶点的顶点
	}
	
	public void deleteVertex(int delVert){
		 if(delVert != nVerts-1){ //要删除的顶点不是最后一个，就要处理邻接矩阵
			 for(int j = delVert; j < nVerts - 1; j++)
				 vertexList[j] = vertexList[j+1];
			 
			 for(int row = delVert; row < nVerts-1; row++) //把邻接矩阵中删除行后面行向上移动
				 moveRowUp(row, nVerts); 
			 
			 for(int col = delVert; col < nVerts-1; col++)
				 moveColLeft(col, nVerts-1);
		 }
		 nVerts--;
	}
	
	private void moveRowUp(int row, int length){
		for(int col = 0; col < length; col++)
			adjMat[row][col] = adjMat[row+1][col];
	}
	
	//把列往左移
	private void moveColLeft(int col, int length){
		for(int row = 0; row < length; row++)
			adjMat[row][col] = adjMat[row][col+1];
	}
//	
//	
//	// 最小生成树 MST
//	public void mst() {
//		vertexList[0].wasVisited = true; // 第一个顶点标记为访问过
//		theStack.push(0);
//
//		while (!theStack.isEmpty()) {
//			int currentVertex = theStack.peek();
//			int v = getAdjUnvisitedVertex(theStack.peek()); // 找的是从栈里面
//			if (v == -1) { // 没有找到邻接的没有访问过的顶点
//				theStack.pop();
//			} else {
//				vertexList[v].wasVisited = true;
//				theStack.push(v);
//				displayVertex(currentVertex);
//				displayVertex(v);
//				System.out.print(" ");
//			}
//		} // while 循环显示
//
//		// 还原成初始状态
//		for (int j = 0; j < nVerts; j++)
//			vertexList[j].wasVisited = false;
//	}
//
//	// 获取指定顶点(v)相邻接的一个未被访问的顶点下标索引
//	public int getAdjUnvisitedVertex(int v) {
//		for (int j = 0; j < nVerts; j++)
//			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
//				return j; // 找到了一个与v顶点相邻的未访问的顶点位置
//		return -1; // 未找到
//	}
}
