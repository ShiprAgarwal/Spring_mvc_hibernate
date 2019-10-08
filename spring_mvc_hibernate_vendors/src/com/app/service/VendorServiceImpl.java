package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VendorManagementDao;
import com.app.pojos.BankAccount;
import com.app.pojos.Vendor;

@Service //spring bean holding B.L --mandatory
@Transactional //--mandatory
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorManagementDao dao;

	@Override
	public Vendor validateVendor(String em, String pass) {
		System.out.println("in service validate : "+em+" "+pass);
		return dao.validateUser(em, pass);
	}

	@Override
	public List<Vendor> listVendors() {
		// TODO Auto-generated method stub
		return dao.listVendors();
	}

	@Override
	public String registerVendor(Vendor transientVendor) {
		// TODO Auto-generated method stub
		return dao.registerVendor(transientVendor);
	}

	@Override
	public String deleteVendorDetails(int vid) {
		Vendor v=dao.getVendorDetails(vid);
		return dao.deleteVendorDetails(v);
	}

	@Override
	public Vendor getVendorDetails(int vendorId) {
		// TODO Auto-generated method stub
		return dao.getVendorDetails(vendorId);
	}
	

	@Override
	public Vendor getCompleteVendorDetails(int vendorId) {
		// TODO Auto-generated method stub
		return dao.getCompleteVendorDetails(vendorId);
	}

	@Override
	public String createAccount(Vendor detachedVendor, BankAccount transientAccount) {
		// TODO Auto-generated method stub
		return dao.createAccount(detachedVendor, transientAccount);
	}

	@Override
	public String updateVendor(Vendor detachedVendor) {
		// TODO Auto-generated method stub
		return dao.updateVendorDetails(detachedVendor);
	}
	
	
	
	
	

}
