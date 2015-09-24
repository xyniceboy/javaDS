/*
 * 定义图的定点(Vertex)
 */
public class Vertex {
	public char label;
	public boolean wasVisited;  //标志该定点是否被访问过
	
	public Vertex(char lab){
		label = lab;
		wasVisited = false; //false表示没有访问
	}

}
