//定义节点中数据项的情况

public class DataItem {
	public long dData;

	public DataItem(long dd) {
		dData = dd;
	}

	public void displayItem() {
		System.out.print("/" + dData);
	}
}
