package model.entities;

import model.exceptions.DomainExceptions;

public class account {
	Integer number;
	String holder;
	Double balance;
	Double withdrawLimit;

	public account() {
	}

	public account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdray(double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}

	private void validateWithdraw(Double amount) {
		if (amount > getWithdrawLimit()) {
			throw new DomainExceptions("Withdraw Error: The amount exceeds the withdraw limit");
		}
		if (amount > getBalance()) {
			throw new DomainExceptions("Withdraw Error: Not enough balance!");
		}
	}
}
