
public class Person {
	private String lastName;
	private String firstName;
	private int age;
	
	public Person(String last, String first, int a){
		lastName = last;
		firstName = first;
		age = a;
	}
	
	public void displayPerson(){
		System.out.print("Last Name: "+ lastName);
		System.out.print(", First Name: " + firstName);
		System.out.println(", Age: "+age);
	}
	
	public String getLast(){   // �����(lastName)��˽�г�Ա�����Կ��Զ���һ����������lastName����������Է��ʵġ�
		return lastName;
	}
	
	public int getAge(){
		return age;
	}
}
