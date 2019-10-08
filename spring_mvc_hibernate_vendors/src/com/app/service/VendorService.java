package com.app.service;

import java.util.List;

import com.app.pojos.*;

public interface VendorService {
	Vendor validateVendor(String em,String pass);
	List<Vendor> listVendors();
	String registerVendor(Vendor transientVendor);
	String deleteVendorDetails(int vid);
	Vendor getVendorDetails(int vendorId);
	Vendor getCompleteVendorDetails(int vendorId);//vendor + account details

	String updateVendor(Vendor detachedVendor);
	//Bank account related methods
	String createAccount(Vendor detachedVendor,BankAccount transientAccount);

}
