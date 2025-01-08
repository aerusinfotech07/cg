package com.cg;

public class BankAccount {
	
	
	private int id;
	private String name;
	private float balance;
	public BankAccount(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void withdraw(float amount)
	{
		if(balance<=1000)
			throw new InSufficientBalanaceException("You Don't have Sufficient Balance in your account");
		else
			balance=balance-amount;
		
	}

}
