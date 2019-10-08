package com.app.dao;

import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.*;

@Repository
public class VendorManagementDaoImpl implements VendorManagementDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Vendor validateUser(String em1, String pass1) {
		String jpql = "select v from Vendor v where v.email = :em and v.password = :pass";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("em", em1)
				.setParameter("pass", pass1).getSingleResult();
	}

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select v from Vendor v where v.role='vendor'";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).getResultList();
	}

	@Override
	public String registerVendor(Vendor transientVendor) {
		sf.getCurrentSession().save(transientVendor);
		return "vendor registered succesully with ID " + transientVendor.getId();

	}

	@Override
	public String deleteVendorDetails(Vendor detachedVendor) {
		sf.getCurrentSession().delete(detachedVendor);
		String mesg = "vendor deleted succesully";
		return mesg;
	}

	@Override
	public Vendor getVendorDetails(int vendorId) {
		// lifting only vendor details
		Vendor v = sf.getCurrentSession().get(Vendor.class, vendorId);
		/*
		 * // to avoid LazyInit exc System.out.println("no of accts " +
		 * v.getAccounts().size());
		 */ return v;
	}

	@Override
	public Vendor getCompleteVendorDetails(int vendorId) {
		System.out.println("dao : complete vendor  dtls "+vendorId);
		String jpql = "select v from Vendor v left outer join fetch v.accounts where v.id=:vid";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("vid", vendorId).getSingleResult();
	}

	@Override
	public String createAccount(Vendor detachedVendor, BankAccount transientAccount) {
		// re-attach detached POJO with L1 cache
		Session hs = sf.getCurrentSession();
		hs.update(detachedVendor);
		System.out.println("vendor exists in L1 cache " + hs.contains(detachedVendor));
		detachedVendor.addAccount(transientAccount);
		return "A/C created succesully with A/C ID " + transientAccount.getAcctId() + " for vendor "
				+ detachedVendor.getName();
	}

	@Override
	public String updateVendorDetails(Vendor detachedVendor) {
		sf.getCurrentSession().update(detachedVendor);
		return "Vendor updated successfully";
	}

}
