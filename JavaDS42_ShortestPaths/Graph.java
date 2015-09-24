
public class Graph {
	private final int MAX_VERTS = 20; 
	private final int INFINITY = 1000000; //1���򣬱�ʾû���ڽ���
	private Vertex[] vertexList;
	private int [][] adjMat; //�ڽӾ���
	private int nVerts; //��ǰ��������
	private int currentVert;
	private int startToCurrent;
	private DistParth[] sPath; //����������С�������õ�
	private int nTree; //��ʾ��С�������㷨�����У���־�ѷ��ʵĶ�������
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree = 0;
		//��ʼ���ڽӾ���
		for(int j = 0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = INFINITY;
		
		//��ʼ��(����)���ȶ���
		sPath = new DistParth[MAX_VERTS];
	}
	
	//��Ӷ���
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	//���һ����
	public void addEdge(int start, int end, int weight){
		adjMat[start][end] = weight;
//		adjMat[end][start] = weight;
	}
	
	//���·���ļ��㷽��
	// ����㿪ʼ�����㵽��ÿ���������С·���� �м�ĺ����㷨���Ǽ���һ�������¼�����ֽ��бȽϣ�˭Сȡ˭
	public void path(){
		int startTree = 0;
		vertexList[startTree].isInTree = true;
		nTree = 1;
		for(int j = 0; j < nVerts; j++){
			int tempDist = adjMat[startTree][j];
			//startTree �Ǹ��ڵ㣻tempDist �Ǿ���
			sPath[j] = new DistParth(startTree, tempDist);
		}
		
		//���С�ڶ�����Ŀ����ʾ����û�з��ʹ���
		while(nTree < nVerts){
			int indexMin = getMin(); //�ҵ��ڽ������һ������
			int minDist = sPath[indexMin].distance;
			if(minDist == INFINITY){
				System.out.println("There are unreachable vertices");
				break;
			}else{
				currentVert = indexMin;
				startToCurrent = sPath[indexMin].distance;
			}
			vertexList[currentVert].isInTree = true; //��Ƿ��ʹ��Ķ���
			nTree++;
			adjust_sPath();  //�������·��
		}
		
		displayPaths();
		
		//����ǸĻ�ԭ����false
		nTree = 0;
		for(int j=0; j<nVerts; j++)
			vertexList[j].isInTree = false;
	}
	
	//�ڽӵ����·��
	public void adjust_sPath(){ //�����㷨
		int column = 1;
		while(column<nVerts){
			if(vertexList[column].isInTree){ //���ʹ���
				column++;
				continue;
			}
			//��㵽Ŀ���ľ���
			int currentToFringe = adjMat[currentVert][column];
			int startToFringe = startToCurrent + currentToFringe; //��㵽Ŀ��ľ���
			
			//ȡ����
			int sPathDist = sPath[column].distance;
			if(startToFringe < sPathDist){  //��ǰ����ľ��룬���ĸ������ĸ�
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
	}
	
	//��ʾ
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
	
	//����㿪ʼ�ڽ�Ȩֵ��С����ͨ�Ķ���
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
