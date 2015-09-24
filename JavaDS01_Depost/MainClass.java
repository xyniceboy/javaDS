package javaDS01;
/*
 * from polar-bear
 */
public class MainClass {
	public static void main(String[] args) {
		BanKAccount bal = new BanKAccount(100.00);
		bal.display();
		System.out.println("--------------------");
		bal.deposit(10);
		bal.display();
		System.out.println("--------------------");
		bal.withdraw(10000);
		bal.display();
		System.out.println("--------------------");
	}
}

