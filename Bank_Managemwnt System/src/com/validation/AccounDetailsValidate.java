package com.validation;

import com.DTO.AccountDTO;

public class AccounDetailsValidate {

	public String accountDetailsValidates(AccountDTO accountDTO) {

		if (accountDTO.getName() == null || accountDTO.getName().trim().isEmpty() || accountDTO.getAddress() == null
				|| accountDTO.getAddress().trim().isEmpty() || accountDTO.getAccNo() <= 0
				|| accountDTO.getBlance() <= 0) {

			return "Invalid";
		} else {

			return "Success";
		}

	}

	public String depositValidate(int accNo, double newBalance) {
		if (accNo<=0||newBalance<=0) {
			return "Invalid";
		} else {

			return "Success";
		}
	}

}
