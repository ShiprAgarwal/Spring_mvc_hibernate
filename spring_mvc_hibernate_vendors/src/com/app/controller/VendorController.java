package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Vendor;
import com.app.service.VendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorService service;

	public VendorController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/details")
	public String showVendorDetails(HttpSession hs) {
		System.out.println("in vendor dtls");
		// user_dtls contain only Vendor details BUT not account dtls
		int vid = ((Vendor) hs.getAttribute("user_dtls")).getId();
		Vendor v = service.getCompleteVendorDetails(vid);
		System.out.println("accts " + v.getAccounts().size());
		// vendor_dtls --complete vendor details
		hs.setAttribute("vendor_dtls", v);
		return "/vendor/details";

	}

	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in vendor list");
		map.addAttribute("vendor_list", service.listVendors());

		return "/vendor/list";
	}

	@GetMapping("/register")
	public String showRegForm(Vendor v)
	// Vendor v = new Vendor(); getters --chk are there any MATCHING setters
	// req param names(identified by path attribute) to POJO property setters
	// ModelMap.addAttribute("vendor",v);
	{
		System.out.println("in show reg form " + v);
		return "/vendor/register";
	}

	@PostMapping("/register")
	public String processRegForm(@Valid Vendor v, BindingResult res,Model map, RedirectAttributes flashMap) {
		System.out.println("in process reg form " + v);
		if(res.hasErrors())
		{
			System.out.println("p.l validation failed....forwarding clnt to reg form");
			return "/vendor/register";
		}
		try {
			flashMap.addFlashAttribute("status", service.registerVendor(v));
			return "redirect:/vendor/list";
		} catch (RuntimeException e) {
			System.out.println("reg err " + e);
			map.addAttribute("status", "Reg Failed , pls retry ..");
			return "/vendor/register";
		}

	}

	// request handling method for deleting vendor dtls
	@GetMapping("/delete")
	public String deleteVendorDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in delete vendor dtls " + vid);
		try {
			flashMap.addFlashAttribute("status", service.deleteVendorDetails(vid));
		} catch (DataAccessException e) {
			flashMap.addFlashAttribute("status", "Vendor deletion failed " + e.getMessage());
		}
		return "redirect:/vendor/list";
	}

	// request handling method for showing update form
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int vid, Model map, RedirectAttributes flashMap) {
		System.out.println("in show update form " + vid);

		Vendor v = service.getVendorDetails(vid);
		if (v != null) {
			System.out.println("proceeding to update form");
			map.addAttribute(v);
			return "/vendor/update";
		}

		flashMap.addFlashAttribute("status", "Vendor Updation failed : invalid ID ");
		return "redirect:/vendor/list";

	}

	@PostMapping("/update")
	public String processUpdateForm(Vendor v, Model map, RedirectAttributes flashMap) {
		System.out.println("in process update form " + v);
		try {
			flashMap.addFlashAttribute("status", service.updateVendor(v));
			return "redirect:/vendor/list";
		} catch (RuntimeException e) {
			System.out.println("reg err " + e);
			map.addAttribute("status", "Reg Failed , pls retry ..");
			return "/vendor/register";
		}

	}
}
