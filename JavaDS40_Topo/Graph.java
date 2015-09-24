public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList; // ��������
	private int adjMat[][]; // �ڽӾ���
	private int nVerts; // ����������
	private char[] sortedArray; //���������

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;

		for (int j = 0; j < MAX_VERTS; j++)
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0; //
		sortedArray = new char[MAX_VERTS];
	}

	// ��Ӷ���
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	// ��ӱ�
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
//		adjMat[end][start] = 1;
	}

	// ��ʾ����
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	//��������
	public void topo(){
		int orig_nVerts = nVerts;
		while(nVerts > 0){
			int currenVertex = noSuccessors();
			if(currenVertex == -1){ //�Ҳ���û�к�̶���Ķ�����
				System.out.println("Error: Graph has cycles");
				return ; //�˳�����
			}
			
			/*
			 * @param nVerts-1 ��ʾ���һ��
			 */
			sortedArray[nVerts-1] = vertexList[currenVertex].label;
			deleteVertex(currenVertex); //��ͼ��ɾ����ǰ����
		}
		
		System.out.print("Topologically sorted order:");
		for(int j = 0; j < orig_nVerts; j++)
			System.out.print(sortedArray[j]);
		System.out.println();
	}
	
	//����ͼ��û�к�̶���Ķ���
	public int noSuccessors(){
		boolean isEdge;
		for(int row = 0; row < nVerts; row++){
			isEdge = false;
			for(int col = 0; col < nVerts; col++){
				if(adjMat[row][col] > 0){
					isEdge = true;
					break;  
				}
			}
			if(!isEdge)
				return row;
		}
		return -1; //û���ҵ�û�к�̶���Ķ���
	}
	
	public void deleteVertex(int delVert){
		 if(delVert != nVerts-1){ //Ҫɾ���Ķ��㲻�����һ������Ҫ�����ڽӾ���
			 for(int j = delVert; j < nVerts - 1; j++)
				 vertexList[j] = vertexList[j+1];
			 
			 for(int row = delVert; row < nVerts-1; row++) //���ڽӾ�����ɾ���к����������ƶ�
				 moveRowUp(row, nVerts); 
			 
			 for(int col = delVert; col < nVerts-1; col++)
				 moveColLeft(col, nVerts-1);
		 }
		 nVerts--;
	}
	
	private void moveRowUp(int row, int length){
		for(int col = 0; col < length; col++)
			adjMat[row][col] = adjMat[row+1][col];
	}
	
	//����������
	private void moveColLeft(int col, int length){
		for(int row = 0; row < length; row++)
			adjMat[row][col] = adjMat[row][col+1];
	}
//	
//	
//	// ��С������ MST
//	public void mst() {
//		vertexList[0].wasVisited = true; // ��һ��������Ϊ���ʹ�
//		theStack.push(0);
//
//		while (!theStack.isEmpty()) {
//			int currentVertex = theStack.peek();
//			int v = getAdjUnvisitedVertex(theStack.peek()); // �ҵ��Ǵ�ջ����
//			if (v == -1) { // û���ҵ��ڽӵ�û�з��ʹ��Ķ���
//				theStack.pop();
//			} else {
//				vertexList[v].wasVisited = true;
//				theStack.push(v);
//				displayVertex(currentVertex);
//				displayVertex(v);
//				System.out.print(" ");
//			}
//		} // while ѭ����ʾ
//
//		// ��ԭ�ɳ�ʼ״̬
//		for (int j = 0; j < nVerts; j++)
//			vertexList[j].wasVisited = false;
//	}
//
//	// ��ȡָ������(v)���ڽӵ�һ��δ�����ʵĶ����±�����
//	public int getAdjUnvisitedVertex(int v) {
//		for (int j = 0; j < nVerts; j++)
//			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
//				return j; // �ҵ���һ����v�������ڵ�δ���ʵĶ���λ��
//		return -1; // δ�ҵ�
//	}
}
