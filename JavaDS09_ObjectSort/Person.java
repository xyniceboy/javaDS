
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
	
	public String getLast(){   // 因為姓(lastName)是私有成员，所以可以定义一个方法，将lastName定义成外界可以访问的。
		return lastName;
	}
	
	public int getAge(){
		return age;
	}
}
