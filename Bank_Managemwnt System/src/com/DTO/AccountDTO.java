package com.DTO;

public class AccountDTO {
	
	private String name;
	private String address;
	private int accNo;
	private double blance;
	
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}
	public AccountDTO(String name, String address, int accNo, double blance) {
		super();
		this.name = name;
		this.address = address;
		this.accNo = accNo;
		this.blance = blance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public double getBlance() {
		return blance;
	}
	public void setBlance(double blance) {
		this.blance = blance;
	}
	@Override
	public String toString() {
		return "AccountDTO [name=" + name + ", address=" + address + ", accNo=" + accNo + ", blance=" + blance + "]";
	}
	
	

}
