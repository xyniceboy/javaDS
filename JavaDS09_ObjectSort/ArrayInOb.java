
public class ArrayInOb {
	private Person[] a;
	private int nElems;
	
	public ArrayInOb(int max){  //���캯��
		a = new Person[max];
		nElems = 0;
	}
	
	public void insert(String last, String first, int age){
		a[nElems] = new Person(last, first, age);
		nElems++;
	}
	
	public void display(){
		for(int j=0; j < nElems; j++)
			a[j].displayPerson();
		System.out.println();
	}
	
	public void insertionSort(){
		int in, out;
		for(out = 1; out < nElems; out++){
			Person temp = a[out];
			in = out;
			//�ҷ����ݵ�λ��
			while (in > 0 && a[in-1].getLast().compareTo(temp.getLast())>0){
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}
	
	public void insertionSortAge(){
		int in, out;
		for(out = 1; out < nElems; out++){
			Person temp = a[out];
			in = out;
			//�ҷ����ݵ�λ��
			while (in > 0 && a[in-1].getAge()>temp.getAge()){  //�����������ұߵ�����
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}
}
