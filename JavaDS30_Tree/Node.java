
public class Node {
	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;
	public void displayNode(){  //用一行显示，有整数有小数
		System.out.print("{");
		System.out.print(iData);
		System.out.print(",");
		System.out.print("dData");
		System.out.print("}");
	}
}
