package com.DTO;

import java.time.LocalDateTime;

public class TransactionDTO {
	private int accountNo;
	private String type;
	private double amount;
	private LocalDateTime dateTime;
	
	public TransactionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public TransactionDTO(int accountNo, String type, double amount) {
		super();
		this.accountNo = accountNo;
		this.type = type;
		this.amount = amount;
		this.dateTime = LocalDateTime.now();
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "TransactionDTO [accountNo=" + accountNo + ", type=" + type + ", amount=" + amount + ", dateTime="
				+ dateTime + "]";
	}
	
	

}
