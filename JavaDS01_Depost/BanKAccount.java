package javaDS01;

public class BanKAccount {
	
	private double balance;

	// 构造函数
	public BanKAccount(double openingBalance) {
		balance = openingBalance;
	}
	
	//存款
	public void deposit(double amount){
		balance = balance + amount;
	}
	
	//存款
	public void withdraw(double amount){
		balance = balance - amount;
	}
	
	//显示
	public void display(){
		System.out.println("balance: " + balance);
	}
	
}
