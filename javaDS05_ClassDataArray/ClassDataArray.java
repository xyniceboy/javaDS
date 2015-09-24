package javaDS05_ClassDataArray;

public class ClassDataArray {
	private Person[] a;   //���M��Ķ����ˡ����M������Դ攵����߀���Դ惦����
	private int nElems;
	
	public ClassDataArray(int max){
		a = new Person[max];
		nElems = 0;
	}
	
	public Person find(String searchName){  //���ղ�ԃ
		int j;
		for(j=0; j<nElems; j++)
			if(a[j].getLast().equals(searchName)) break;
		if(j==nElems) return null;   //�]�ҵ�
		else return a[j];  //�ҵ���
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
