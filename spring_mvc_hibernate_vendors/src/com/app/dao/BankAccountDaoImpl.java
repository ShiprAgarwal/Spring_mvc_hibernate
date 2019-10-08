package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.BankAccount;
import com.app.pojos.Vendor;

@Repository
@Transactional
public class BankAccountDaoImpl implements BankAccountDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public String createAccount(Vendor v,BankAccount a) {
		v.addAccount(a);
		sf.getCurrentSession().update(v);
		return "A/C created successfully with ID" + a.getAcctId();
	}

	@Override
	public String closeAccount(int acctId) {
		BankAccount a=sf.getCurrentSession().get(BankAccount.class, acctId);
		if(a != null) {
			sf.getCurrentSession().delete(a);
			return "A/C Closed for ID "+acctId;
		}
		return "A/C closing failed";
	}
	

}
