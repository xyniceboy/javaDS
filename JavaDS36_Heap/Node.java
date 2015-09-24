
public class Node {
	private int iData;
	
	public Node(int key){
		iData = key;
	}
	
	public int getKey(){
		return iData;
	}
	
	public void setKey(int id){  //需要设置优先级
		iData = id;
	}
}
