package javaDS01;

public class BanKAccount {
	
	private double balance;

	// ���캯��
	public BanKAccount(double openingBalance) {
		balance = openingBalance;
	}
	
	//���
	public void deposit(double amount){
		balance = balance + amount;
	}
	
	//���
	public void withdraw(double amount){
		balance = balance - amount;
	}
	
	//��ʾ
	public void display(){
		System.out.println("balance: " + balance);
	}
	
}
