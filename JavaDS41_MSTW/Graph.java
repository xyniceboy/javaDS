
public class Graph {
	private final int MAX_VERTS = 20; 
	private final int INFINITY = 1000000; //1百万，表示没有邻接线
	private Vertex[] vertexList;
	private int [][] adjMat; //邻接矩阵
	private int nVerts; //当前顶点数量
	private int currentVert;
	private PriorityQ thePQ; //用来计算最小生成树用的
	private int nTree; //表示最小生成树算法过程中，标志已访问的顶点数量
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		
		//初始化邻接矩阵
		for(int j = 0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = INFINITY;
		
		//初始化(创建)优先队列
		thePQ = new PriorityQ();
	}
	
	//添加顶点
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	//添加一条边
	public void addEdge(int start, int end, int weight){
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	//显示顶点
	public void dispalyVertex(int v){ 
		System.out.print(vertexList[v].label);
	}
	
	//带权值的最小生成树
	public void mstw(){
		currentVert = 0; //第一个顶点开始
		while(nTree<nVerts-1){
			vertexList[currentVert].isInTree = true; //访问过了
			nTree++;
			for(int j = 0; j < nVerts; j++){
				if(j == currentVert) //j和currentVert指向了同一个顶点，就终止本次循环
					continue;
				if(vertexList[j].isInTree) //到这个点的边在队列中已经加入
					continue;
				int distance = adjMat[currentVert][j]; //从邻接矩阵中取出权值
				if(distance == INFINITY) //两点之间没有连接
					continue; 
				putInPQ(j, distance);  //放到队列中
			}//for
			if(this.thePQ.size() == 0){
				System.out.println("Graph not connected");
				return;
			}
			
			Edge theEdge = thePQ.removeMin(); //移除队列中最小的/最短的边
			int sourceVert = theEdge.srcVert; //最小边的原点
			currentVert = theEdge.destVert; //最小边的终点
			
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			//起点和终点打印出来，形成一个路径
			System.out.print(" ");
		}//while 结束。则最小生成树的结果就输出了
		
		//将顶点的标志重置成false
		for(int j=0;j<nVerts; j++)
			vertexList[j].isInTree = false;
	}
	
	public void putInPQ(int newVert, int newDist){
		int queueIndex = thePQ.find(newVert);
		if(queueIndex != -1){ //找到了
			Edge tempEdge = thePQ.peekN(queueIndex);
			int oldDist = tempEdge.distance;
			if(oldDist > newDist){
				thePQ.removeN(queueIndex); //删除旧边
				Edge theEdge = new Edge(currentVert, newVert, newDist);
				thePQ.insert(theEdge);
			}
		}else { //在队列中没有找到 
			Edge theEdge = new Edge(currentVert, newVert, newDist);
			thePQ.insert(theEdge); //将新建出来的插入到优先级队列中
			
		}
	}
}
