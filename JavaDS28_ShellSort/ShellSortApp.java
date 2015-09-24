
public class ShellSortApp {
	public static void main(String[] args) {
		int maxSize = 20;
		ArraySh arr = new ArraySh(maxSize);
		
		//测试插入随机数、显示
		for(int j = 0; j < maxSize; j++){
//			long n = (int)java.lang.Math.random()*99;    //这个转换先执行了，所以无论怎么转，都是 0 * 99
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		
		//测试希尔排序
		arr.shellSort();  
		System.out.println("======测试希尔排序=======");
		arr.display();
	}
}
