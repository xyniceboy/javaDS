package JavaDS03_LowArray;

public class LowArrayApp {
	public static void main(String[] args) {
		LowArray arr;
		arr = new LowArray(100);

		int nElems = 0;
		int j;
		long searchKey;
		
		arr.setElem(0, 10);
		arr.setElem(1, 11);
		arr.setElem(2, 12);
		arr.setElem(3, 13);
		arr.setElem(4, 14);
		arr.setElem(5, 15);
		arr.setElem(6, 16);
		arr.setElem(7, 17);
		arr.setElem(8, 18);
		arr.setElem(9, 19);
		arr.setElem(10, 20);
		arr.setElem(11, 21);
		nElems = 12;

		// 显示所有元素
		for (j = 0; j < nElems; j++)
			System.out.print(arr.getElem(j) + " ");
		System.out.println();

		// 查找15
		searchKey = 15;
		for (j = 0; j < nElems; j++)
			if (arr.getElem(j) == searchKey)
				break;
		if (j == nElems)
			System.out.println("Cann't find " + searchKey);
		else
			System.out.println("Found " + searchKey);

		// 删除20
		searchKey = 20;
		for (j = 0; j < nElems; j++)
			if (arr.getElem(j) == searchKey)
				break;
		for (int k = j; k < nElems; k++)
			arr.setElem(k, arr.getElem(k+1));
//			arr.setElem(k, value);( k ) = arr.getElem(k + 1);
		nElems--;

		// 显示所有元素
		for (j = 0; j < nElems; j++)
			System.out.print(arr.getElem(j) + " ");
		System.out.println();

	}

}
