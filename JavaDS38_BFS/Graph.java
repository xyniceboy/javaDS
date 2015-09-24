package bwang;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;  //��������
	private int adjMat[][]; //�ڽӾ���
	private int nVerts; //����������
	
	private Queue theQueue; //������������õĶ���
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		
		for(int j=0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0; //
		theQueue = new Queue();
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
	//�����������
	public void bfs(){
		vertexList[0].wasVisited = true;  //��һ�������ʶΪ���ʹ�
		displayVertex(0); //��ʾ���ʵĶ���
		theQueue.insert(0);
		int v2;
		while(!theQueue.isEmpty()){
			int v1 = theQueue.remove();  //�Ӷ�ͷȡ����һ������
			while((v2 = getAdjUnvisitedVertex(v1))!= -1){ //û�����ʹ����Ž���
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.insert(v2);
			} //while ����������û�з��ʹ��Ķ�������һ�� 
		}

		//�����ж���ı�־���ĳ� false
		for(int j=0; j<nVerts; j++)
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
