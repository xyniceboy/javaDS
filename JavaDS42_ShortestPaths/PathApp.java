
public class PathApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); //0
		theGraph.addVertex('B'); //1
		theGraph.addVertex('C'); //2
		theGraph.addVertex('D'); //3
		theGraph.addVertex('E'); //4
		
		theGraph.addEdge(0, 1, 50);//AB 50
		theGraph.addEdge(0, 3, 80);//AD 50
		theGraph.addEdge(1, 2, 60);//BC 50
		theGraph.addEdge(1, 3, 90);//BD 50
		theGraph.addEdge(2, 4, 40);//CE 50
		theGraph.addEdge(3, 2, 20);//DC 50
		theGraph.addEdge(3, 4, 70);//DE 50
		theGraph.addEdge(4, 1, 50);//EB 50
		
		System.out.println("Shortest Paths: ");
		theGraph.path();
		System.out.println();
	}
}
/*
 Shortest Paths: 
A=inf(A)
B=50(A)
C=100(D)
D=80(A)
E=140(C)

 */
