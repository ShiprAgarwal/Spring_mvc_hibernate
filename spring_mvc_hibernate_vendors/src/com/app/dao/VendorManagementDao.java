package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface VendorManagementDao {
	Vendor validateUser(String em,String pass);
	List<Vendor> listVendors();
	String registerVendor(Vendor transientVendor);
	String deleteVendorDetails(Vendor detachedVendor);
	String updateVendorDetails(Vendor detachedVendor);
	Vendor getVendorDetails(int vendorId);//only vendor details
	Vendor getCompleteVendorDetails(int vendorId);//vendor + account details
	
	//Bank account related methods
	String createAccount(Vendor detachedVendor,BankAccount transientAccount);
}
