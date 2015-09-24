package javaDS05_ClassDataArray;

public class ClassDataArray {
	private Person[] a;   //數組存的都是人。數組不光可以存數據，還可以存儲對象
	private int nElems;
	
	public ClassDataArray(int max){
		a = new Person[max];
		nElems = 0;
	}
	
	public Person find(String searchName){  //按姓查詢
		int j;
		for(j=0; j<nElems; j++)
			if(a[j].getLast().equals(searchName)) break;
		if(j==nElems) return null;   //沒找到
		else return a[j];  //找到了
	}
	
	public void insert(String last, String first, int age){
		a[nElems] = new Person(last, first, age);
		nElems++;
	}
	
	public boolean delete(String searchName){
		int j;
		for(j=0; j<nElems;j++)
			if(a[j].getLast().equals(searchName)) break;
		if(j == nElems) return false;
		else {
			for(int k = j; k < nElems;k++)
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}
	
	public void display(){
		for(int j=0; j<nElems; j++)
			a[j].displayPerson();
//			System.out.print(a[j]+" ");
//		System.out.println();
	}
}
