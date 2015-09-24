
public class PartitionApp {
	public static void main(String[] args) {
		int maxSize = 16;

		//测试插入、显示
		ArrayPar arr = new ArrayPar(maxSize);
		for(int j = 0; j < maxSize; j++){
			long n = (int)(java.lang.Math.random()*199);
			arr.insert(n);
		}
		arr.display();
		
		//分隔点计算
		long pivot = 99;  //分割点
		System.out.print("Pivot is " + pivot);
		int size = arr.size();
		int partDex = arr.partitionIt(0, size-1, pivot);
		System.out.println(", Partition is at index " + partDex);
		arr.display();
		//此时，左边是小于99的，右边是大于99
		
	}
}

// 请看：bwang 包
