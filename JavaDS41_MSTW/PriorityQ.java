/*
 * 优先级队列
 */
public class PriorityQ {
	private final int SIZE = 20;
	private Edge[] queArray;
	private int size; //当前边数量
	
	public PriorityQ(){
		queArray = new Edge[SIZE];
		size = 0;
	}
	
	//插入的边对象
	public void insert(Edge item) { 
		int j;
		for(j=0; j<size; j++)
			if(item.distance >= queArray[j].distance) //找到新增存储的位置
				break;
		//循环后移
		for(int k = size-1; k >= j; k--)
			queArray[k+1] = queArray[k];
		
		//插入操作
		queArray[j] = item;
		size++;
	}
	
	//删除最小的一个边
	public Edge removeMin(){
		return queArray[--size];
	}
	
	//删除指定位置的一条边
	public void removeN(int n){
		for(int j = n; j < size-1; j++)
			queArray[j] = queArray[j+1];
		size--;
	}
	
	//查看最小一条边
	public Edge peekMin(){
		return queArray[size-1];
	}
	
	//查看指定位置的一条边
	public Edge peekN(int n){
		return queArray[n];
	}
	
	//查看当前边的数量
	public int size(){
		return size;
	}
	
	//检查图是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	
	//查找指定一个顶点作为终点的边。 
	//return: 返回的不是这条边的对象，而是在队列中的位置
	public int find(int findDex){
		for(int j = 0; j < size; j++)
			if(queArray[j].destVert == findDex)
				return j;
		
		return -1; //如果循环都结束了，还没找到，就返回个 -1
	}
}
