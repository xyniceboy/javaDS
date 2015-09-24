
public class Graph {
	private final int MAX_VERTS = 20; 
	private final int INFINITY = 1000000; //1���򣬱�ʾû���ڽ���
	private Vertex[] vertexList;
	private int [][] adjMat; //�ڽӾ���
	private int nVerts; //��ǰ��������
	private int currentVert;
	private PriorityQ thePQ; //����������С�������õ�
	private int nTree; //��ʾ��С�������㷨�����У���־�ѷ��ʵĶ�������
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		
		//��ʼ���ڽӾ���
		for(int j = 0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = INFINITY;
		
		//��ʼ��(����)���ȶ���
		thePQ = new PriorityQ();
	}
	
	//��Ӷ���
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	//���һ����
	public void addEdge(int start, int end, int weight){
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	//��ʾ����
	public void dispalyVertex(int v){ 
		System.out.print(vertexList[v].label);
	}
	
	//��Ȩֵ����С������
	public void mstw(){
		currentVert = 0; //��һ�����㿪ʼ
		while(nTree<nVerts-1){
			vertexList[currentVert].isInTree = true; //���ʹ���
			nTree++;
			for(int j = 0; j < nVerts; j++){
				if(j == currentVert) //j��currentVertָ����ͬһ�����㣬����ֹ����ѭ��
					continue;
				if(vertexList[j].isInTree) //�������ı��ڶ������Ѿ�����
					continue;
				int distance = adjMat[currentVert][j]; //���ڽӾ�����ȡ��Ȩֵ
				if(distance == INFINITY) //����֮��û������
					continue; 
				putInPQ(j, distance);  //�ŵ�������
			}//for
			if(this.thePQ.size() == 0){
				System.out.println("Graph not connected");
				return;
			}
			
			Edge theEdge = thePQ.removeMin(); //�Ƴ���������С��/��̵ı�
			int sourceVert = theEdge.srcVert; //��С�ߵ�ԭ��
			currentVert = theEdge.destVert; //��С�ߵ��յ�
			
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			//�����յ��ӡ�������γ�һ��·��
			System.out.print(" ");
		}//while ����������С�������Ľ���������
		
		//������ı�־���ó�false
		for(int j=0;j<nVerts; j++)
			vertexList[j].isInTree = false;
	}
	
	public void putInPQ(int newVert, int newDist){
		int queueIndex = thePQ.find(newVert);
		if(queueIndex != -1){ //�ҵ���
			Edge tempEdge = thePQ.peekN(queueIndex);
			int oldDist = tempEdge.distance;
			if(oldDist > newDist){
				thePQ.removeN(queueIndex); //ɾ���ɱ�
				Edge theEdge = new Edge(currentVert, newVert, newDist);
				thePQ.insert(theEdge);
			}
		}else { //�ڶ�����û���ҵ� 
			Edge theEdge = new Edge(currentVert, newVert, newDist);
			thePQ.insert(theEdge); //���½������Ĳ��뵽���ȼ�������
			
		}
	}
}
