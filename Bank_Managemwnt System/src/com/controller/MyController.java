package com.controller;

import java.util.List;

import com.DTO.AccountDTO;
import com.DTO.TransactionDTO;
import com.Service.AccountDetailsService;
import com.Service.AccountDetailsServiceImpl;

public class MyController {

	private static final AccountDetailsService accountDetailsService = new AccountDetailsServiceImpl();

	public String createAccount(AccountDTO accountDTO) throws Exception {
		String account = accountDetailsService.createAccount(accountDTO);
		return account;
	}

	public List<AccountDTO> getAccountDetailsByAccNo(int accNo) throws Exception {
		List<AccountDTO> result = accountDetailsService.getAccountDetailsByAccoNo(accNo);
		if (result.isEmpty()) {
			System.out.println("Something went wrong");
		}
		return result;
	}

	public String deposit(int accNo, double newBalance) {

		return accountDetailsService.deposit(accNo, newBalance);
	}

	public String withdraw(int accNo, double amount) {
		return accountDetailsService.withdraw(accNo, amount);
	}
	
	public List<TransactionDTO> getAllTransactionDetails(int accNo){
		List<TransactionDTO> allTransactionDetails = accountDetailsService.getAllTransactionDetails(accNo);
		if (allTransactionDetails.isEmpty()) {
			System.out.println("Somthing went wrong");
		}
		return allTransactionDetails;
	}

}
