
public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;  //��������
	private int adjMat[][]; //�ڽӾ���
	private int nVerts; //����������
	private StackX theStack;  //���������������ʹ������
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		
		for(int j=0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0; //
		theStack = new StackX();
	}
	
	//��Ӷ���
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}

	//��ӱ�
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	//��ʾ����
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	//�����������(DFS)
	public void dfs(){
		vertexList[0].wasVisited = true; //��һ��������Ϊ���ʹ�
		displayVertex(0);//��ʾ���ʵĶ���
		theStack.push(0);
		
		while(!theStack.isEmpty()){
			//�ҵ��ڽӵ�δ�����ʶ����±�
			int v = getAdjUnvisitedVertex(theStack.peek()); //�ҵ��Ǵ�ջ����
			if(v == -1){
				theStack.pop();
			}else{
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		} //while ѭ����ʾ
		
		//��ԭ�ɳ�ʼ״̬
		for(int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	}
	
	//��ȡָ������(v)���ڽӵ�һ��δ�����ʵĶ����±�����
	public int getAdjUnvisitedVertex(int v){
		for(int j = 0; j < nVerts; j++)
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j; //�ҵ���һ����v�������ڵ�δ���ʵĶ���λ��
		return -1; //δ�ҵ�
	}
}
