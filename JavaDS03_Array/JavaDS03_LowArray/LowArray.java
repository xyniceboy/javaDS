package JavaDS03_LowArray;

public class LowArray {
	private long[] a;  // 定义一个存储数组的容器
	
	//构造函数
	public LowArray(int size){
		a = new long[size];
	}
	
	//定义元素值
	public void setElem(int index, long value){
		a[index] = value;
	}
	
	//返回元素
	public long getElem(int index){
		return a[index];
	}
}
