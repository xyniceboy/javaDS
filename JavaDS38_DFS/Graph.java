
public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;  //顶点数组
	private int adjMat[][]; //邻接矩阵
	private int nVerts; //当顶点数量
	private StackX theStack;  //进行深度优先搜索使得容器
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		
		for(int j=0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0; //
		theStack = new StackX();
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
	
	//深度优先搜索(DFS)
	public void dfs(){
		vertexList[0].wasVisited = true; //第一个顶点标记为访问过
		displayVertex(0);//显示访问的顶点
		theStack.push(0);
		
		while(!theStack.isEmpty()){
			//找到邻接的未被访问顶点下标
			int v = getAdjUnvisitedVertex(theStack.peek()); //找的是从栈里面
			if(v == -1){
				theStack.pop();
			}else{
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		} //while 循环显示
		
		//还原成初始状态
		for(int j = 0; j < nVerts; j++)
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
