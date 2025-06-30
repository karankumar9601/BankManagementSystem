package com.mainapp;

import java.util.List;
import java.util.Scanner;

import com.DTO.AccountDTO;
import com.DTO.TransactionDTO;
import com.controller.MyController;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyController myController = new MyController();

		while (true) {
			System.out.println("***********Bank App*************");
			System.out.println(" 1.Create Account \n 2.View Account Detail \n 3.Deposit Cash \n 4.Withdraw Cash \n 5.Show History \n 6.Exit");
			System.out.println("*********************************");
			System.out.println("Enter Youe Choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Account Holder Name: ");
				String accName = sc.next();
				System.out.println("Enter Address of Account Holder: ");
				String address = sc.next();
				System.out.println("Enter Account No: ");
				int accNo = sc.nextInt();
				System.out.println("Enter Some Balance for Opening Accoount: ");
				double blance = sc.nextDouble();
				try {
					String account = myController.createAccount(new AccountDTO(accName, address, accNo, blance));
					System.out.println(account);
				} catch (Exception e) {
					
					e.printStackTrace();
				}

				break;
			case 2:
				System.out.println("Enter Account No: ");
				int acc_no = sc.nextInt();
				try {
					List<AccountDTO> accountDetailsByAccNo = myController.getAccountDetailsByAccNo(acc_no);
					for (AccountDTO accountDTO : accountDetailsByAccNo) {
						System.out.println(accountDTO);
					}
				} catch (Exception e) {
				 e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Enter Account No: ");
				int acc_No = sc.nextInt();
				System.out.println("Enter Amount for Deposit: ");
				double newBlance = sc.nextDouble();
				String deposit = myController.deposit(acc_No, newBlance);
				System.out.println(deposit);

				break;
			case 4:
				System.out.println("Enter Account No: ");
				int accNum = sc.nextInt();
				System.out.println("Enter Amount for Deposit: ");
				double withdrawAmount = sc.nextDouble();
				String result = myController.withdraw(accNum, withdrawAmount);
				System.out.println(result);

				break;
			case 5:
				System.out.println("Enter Account No: ");
				int accountNo = sc.nextInt();
				List<TransactionDTO> allTransactionDetails = myController.getAllTransactionDetails(accountNo);
				for (TransactionDTO transactionDTO : allTransactionDetails) {
					System.out.println(transactionDTO);
				}

				break;
		
			case 6:
				System.out.println("Existing...Thanku You!");
				System.exit(0);

				break;

			default:
				System.out.println("!Invalid Choice!....Please try again");

			}

		}

	}

}
