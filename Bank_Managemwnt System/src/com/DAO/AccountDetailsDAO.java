package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.DTO.AccountDTO;
import com.DTO.TransactionDTO;
import com.connection.ConnectionFactory;

public class AccountDetailsDAO {

	public String createAccount(AccountDTO accountDTO) throws SQLException {
		String sql = "INSERT INTO account VALUES (?, ?, ?,?)";

		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accountDTO.getAccNo());
			ps.setString(2, accountDTO.getName());
			ps.setString(3, accountDTO.getAddress());
			ps.setDouble(4, accountDTO.getBlance());
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1) {
				return "Successfully create Account";
			} else {
				return "Somthing went wrong!";
			}

		} catch (Exception e) {

			e.printStackTrace();
			return "Somthing went wrong from Catch block !";
		}

	}

	public List<AccountDTO> getAccount(int accNo) throws SQLException {
		String sql = "SELECT * FROM account WHERE accNo=?";
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int acc_no = rs.getInt("accNo");
				String name = rs.getString("acc_hol_name");
				String address = rs.getString("acc_hol_add");
				double acc_balance = rs.getDouble("balance");

				AccountDTO accountDTO = new AccountDTO(name, address, acc_no, acc_balance);

				accountList.add(accountDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accountList;
	}

	public void updateBalance(int accNo, double newBalance) {
		String sql = "update account set balance=? where accNo=?";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, newBalance);
			ps.setInt(2, accNo);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveTransaction(TransactionDTO transactionDTO) {

		String sql = "INSERT INTO transaction_log(accNo, type, amount) VALUES (?, ?, ?)";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, transactionDTO.getAccountNo());
			ps.setString(2, transactionDTO.getType());
			ps.setDouble(3, transactionDTO.getAmount());
			ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public List<TransactionDTO> getAllTransactionDetails(int accNo) {
		List<TransactionDTO> accountList = new ArrayList<TransactionDTO>();
		String sql = "SELECT * FROM transaction_log WHERE accNo = ? ORDER BY dateTime DESC";
		try {
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, accNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				 int acc_no = rs.getInt("accNo");
                 String type = rs.getString("type");
                 double amount = rs.getDouble("amount");
                 Timestamp timestamp = rs.getTimestamp("dateTime");
                 
                 LocalDateTime localDateTime = timestamp.toLocalDateTime();
                 
                   TransactionDTO transactionDTO = new TransactionDTO();
                   transactionDTO.setAccountNo(acc_no);
                   transactionDTO.setType(type);
                   transactionDTO.setAmount(amount);
                   transactionDTO.setDateTime(localDateTime);
                   accountList.add(transactionDTO);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return accountList;
	}

}
