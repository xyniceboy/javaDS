//带权重的最小生成树
public class Edge {
	public int srcVert;  //原点
	public int destVert; //终点
	public int distance;  //距离
	
	public Edge(int sv, int dv, int d){
		srcVert = sv;
		destVert = dv;
		distance = d;
	}
}
