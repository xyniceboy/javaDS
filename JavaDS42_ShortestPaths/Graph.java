
public class Graph {
	private final int MAX_VERTS = 20; 
	private final int INFINITY = 1000000; //1百万，表示没有邻接线
	private Vertex[] vertexList;
	private int [][] adjMat; //邻接矩阵
	private int nVerts; //当前顶点数量
	private int currentVert;
	private int startToCurrent;
	private DistParth[] sPath; //用来计算最小生成树用的
	private int nTree; //表示最小生成树算法过程中，标志已访问的顶点数量
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree = 0;
		//初始化邻接矩阵
		for(int j = 0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = INFINITY;
		
		//初始化(创建)优先队列
		sPath = new DistParth[MAX_VERTS];
	}
	
	//添加顶点
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	//添加一条边
	public void addEdge(int start, int end, int weight){
		adjMat[start][end] = weight;
//		adjMat[end][start] = weight;
	}
	
	//最短路径的计算方法
	// 从起点开始，计算到达每个顶点的最小路径。 中间的核心算法就是计算一个，与记录的数字进行比较，谁小取谁
	public void path(){
		int startTree = 0;
		vertexList[startTree].isInTree = true;
		nTree = 1;
		for(int j = 0; j < nVerts; j++){
			int tempDist = adjMat[startTree][j];
			//startTree 是父节点；tempDist 是距离
			sPath[j] = new DistParth(startTree, tempDist);
		}
		
		//如果小于顶点数目，表示还有没有访问过的
		while(nTree < nVerts){
			int indexMin = getMin(); //找到邻接最近的一个顶点
			int minDist = sPath[indexMin].distance;
			if(minDist == INFINITY){
				System.out.println("There are unreachable vertices");
				break;
			}else{
				currentVert = indexMin;
				startToCurrent = sPath[indexMin].distance;
			}
			vertexList[currentVert].isInTree = true; //标记访问过的顶点
			nTree++;
			adjust_sPath();  //更新最短路径
		}
		
		displayPaths();
		
		//将标记改回原来的false
		nTree = 0;
		for(int j=0; j<nVerts; j++)
			vertexList[j].isInTree = false;
	}
	
	//邻接的最短路径
	public void adjust_sPath(){ //核心算法
		int column = 1;
		while(column<nVerts){
			if(vertexList[column].isInTree){ //访问过了
				column++;
				continue;
			}
			//起点到目标点的距离
			int currentToFringe = adjMat[currentVert][column];
			int startToFringe = startToCurrent + currentToFringe; //起点到目标的距离
			
			//取距离
			int sPathDist = sPath[column].distance;
			if(startToFringe < sPathDist){  //当前计算的距离，看哪个短用哪个
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
	}
	
	//显示
	public void displayPaths(){
		for(int j = 0; j < nVerts; j++){
			System.out.print(vertexList[j].label + "=");
			if(sPath[j].distance == INFINITY)
				System.out.print("inf");
			else
				System.out.print(sPath[j].distance);
			
			char parent = vertexList[sPath[j].parentVert].label;
			System.out.println("(" + parent + ")");
		}
		System.out.println();
	}
	
	//从起点开始邻接权值最小的连通的顶点
	public int getMin(){
		int minDist = INFINITY;
		int indexMin = 0;
		for(int j=1; j< nVerts; j++){
			if(!vertexList[j].isInTree && sPath[j].distance < minDist){
				minDist = sPath[j].distance;
				indexMin = j;
			}
		}//for
		return indexMin;
	}
}
