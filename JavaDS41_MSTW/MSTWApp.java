/*
 * ��Ȩ�ص���С������ ���Գ���
 */
public class MSTWApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');  //0
		theGraph.addVertex('B');  //1
		theGraph.addVertex('C');  //2
		theGraph.addVertex('D');  //3
		theGraph.addVertex('E');  //4
		theGraph.addVertex('F');  //5
		
		theGraph.addEdge(0, 1, 6);//AB 6
		theGraph.addEdge(0, 3, 4);//AB 6
		theGraph.addEdge(1, 2, 10);//AB 6
		theGraph.addEdge(1, 3, 7);//AB 6
		theGraph.addEdge(1, 4, 7);//AB 6
		theGraph.addEdge(2, 3, 8);//AB 6
		theGraph.addEdge(2, 4, 5);//AB 6
		theGraph.addEdge(2, 5, 6);//AB 6
		theGraph.addEdge(3, 4, 12);//AB 6
		theGraph.addEdge(4, 5, 7);//AB 6
		
		//��ӡ��С������
		System.out.print("Minimun spanning tree: ");
		theGraph.mstw();
		System.out.println();
	}
	
}

//�ο���word  40.JavaDS_��Ȩͼ_��С������   ������С������
//Minimun spanning tree: AD AB BE EC CF 
