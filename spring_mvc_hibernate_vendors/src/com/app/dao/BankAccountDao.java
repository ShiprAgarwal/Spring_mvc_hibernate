package com.app.dao;

import com.app.pojos.BankAccount;
import com.app.pojos.Vendor;

public interface BankAccountDao {
	String createAccount(Vendor v,BankAccount a);
	String closeAccount(int acctId);
}
