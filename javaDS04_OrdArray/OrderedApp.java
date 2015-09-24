package javaDS04_OrdArray;

public class OrderedApp {
	public static void main(String[] args){
		int maxSize = 200;
		OrdArray arr;
		arr = new OrdArray(maxSize);
		
		arr.insert(10);
		arr.insert(11);
		arr.insert(12);
		arr.insert(13);
		arr.insert(14);
		arr.insert(15);
		arr.insert(16);
		arr.insert(17);
		
		arr.display();  //調用顯示
		
		//實驗搜索
		int searchKey = 22;
		if(arr.find(searchKey)!= arr.size())  //返回的數值不等於大小(中的數據總量)
			System.out.println("Found " + searchKey);
		else 
			System.out.println("Cann't find "+ searchKey);


		arr.delete(11);
		arr.delete(123);
		arr.delete(14);
		arr.display();
	}
}
