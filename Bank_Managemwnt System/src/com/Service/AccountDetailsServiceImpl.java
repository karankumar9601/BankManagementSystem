package com.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.DAO.AccountDetailsDAO;
import com.DTO.AccountDTO;
import com.DTO.TransactionDTO;
import com.connection.ConnectionFactory;
import com.validation.AccounDetailsValidate;

public class AccountDetailsServiceImpl implements AccountDetailsService {

	private static final AccountDetailsDAO accountDetailsDAO = new AccountDetailsDAO();
	private static final AccounDetailsValidate validate = new AccounDetailsValidate();

	@Override
	public String createAccount(AccountDTO accountDTO) throws Exception {

		String result = validate.accountDetailsValidates(accountDTO);
		if (result.equalsIgnoreCase("Invalid")) {
			return "Wrong Entry Data";
		} else {

			return accountDetailsDAO.createAccount(accountDTO);
		}

	}

	@Override
	public List<AccountDTO> getAccountDetailsByAccoNo(int accNo) throws Exception {
		
		List<AccountDTO> account = accountDetailsDAO.getAccount(accNo);

		return account;
	}

	@Override
	public String deposit(int accNo, double amount) {
		String result = validate.depositValidate(accNo, amount);
		if (result.equalsIgnoreCase("Invalid")) {
			return"wrong Entry Data";
		} else {
			try {
				Connection connection = ConnectionFactory.getConnection();
				connection.setAutoCommit(false);
				List<AccountDTO> account = accountDetailsDAO.getAccount(accNo);
				if (account.isEmpty()) {
					return"Account not found";
				}
				double blance = account.get(0).getBlance();
				double newBalance=blance+amount;
				accountDetailsDAO.updateBalance(accNo, newBalance);
				accountDetailsDAO.saveTransaction(new TransactionDTO(accNo, "deposit", amount));
				connection.commit();
				return "SuccessFully Deposit";
			
			} catch (Exception e) {
				return "Error from Catch block";
			}

		}
		
	}

	@Override
	public String withdraw(int accNo, double amount) {
		try {
			Connection connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			List<AccountDTO> account = accountDetailsDAO.getAccount(accNo);
			if (account.isEmpty()) {
				return "Account not found";
			}
			double blance = account.get(0).getBlance();
			if (blance <amount) {
				connection.rollback();
				return"Insufficient Balance";
			}
			double newBalance=blance-amount;
			accountDetailsDAO.updateBalance(accNo, newBalance);
			accountDetailsDAO.saveTransaction(new TransactionDTO(accNo, "withdraw", amount));
			connection.commit();
			return "Successfully Withdraw Cash";
			
		} catch (Exception e) {
			return "Error from Catch block";
		}
		
	}

	@Override
	public List<TransactionDTO> getAllTransactionDetails(int accNo) {
		
		
		return accountDetailsDAO.getAllTransactionDetails(accNo);
	}

}
