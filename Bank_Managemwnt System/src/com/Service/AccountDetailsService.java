package com.Service;

import java.util.List;

import com.DTO.AccountDTO;
import com.DTO.TransactionDTO;

public interface AccountDetailsService {
	
	public String createAccount(AccountDTO accountDTO) throws Exception;
	
	public List<AccountDTO> getAccountDetailsByAccoNo(int accNo) throws Exception;
	
	public String deposit(int accNo,double newBalance);
	
	public String withdraw(int accNo, double amount);
	
	public List<TransactionDTO> getAllTransactionDetails(int accNo);

}
