package bwang;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;  //顶点数组
	private int adjMat[][]; //邻接矩阵
	private int nVerts; //当顶点数量
	
	private Queue theQueue; //广度优先搜索用的队列
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		
		for(int j=0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0; //
		theQueue = new Queue();
	}
	
	//添加顶点
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}

	//添加边
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	//显示顶点
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	//广度优先搜索
	public void bfs(){
		vertexList[0].wasVisited = true;  //第一个顶点标识为访问过
		displayVertex(0); //显示访问的顶点
		theQueue.insert(0);
		int v2;
		while(!theQueue.isEmpty()){
			int v1 = theQueue.remove();  //从对头取出第一个顶点
			while((v2 = getAdjUnvisitedVertex(v1))!= -1){ //没被访问过，才进入
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.insert(v2);
			} //while 这样把所有没有访问过的都遍历了一遍 
		}

		//把所有顶点的标志都改成 false
		for(int j=0; j<nVerts; j++)
			vertexList[j].wasVisited = false;
	}
	
	
	//获取指定顶点(v)相邻接的一个未被访问的顶点下标索引
	public int getAdjUnvisitedVertex(int v){
		for(int j = 0; j < nVerts; j++)
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j; //找到了一个与v顶点相邻的未访问的顶点位置
		return -1; //未找到
	}
}
