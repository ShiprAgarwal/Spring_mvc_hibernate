package com.app.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Vendor;
import com.app.service.VendorService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired // autowire=byType
	private VendorService service;

	public UserController() {
		System.out.println("in constr of " + getClass().getName());
	}

	// request handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	// request handling method to process login form
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map, HttpSession hs,
			RedirectAttributes flashMap) {
		System.out.println("in prcoess login form : " + email + " " + password);
		Vendor details = null;
		try {
			details = service.validateVendor(email, password);
		} catch (NoResultException e) {
			System.out.println("failed login "+e);
			map.addAttribute("status", "Invalid Login , Pls Retry ...");
			return "/user/login";
		}

		// authentication success --proceed to authorization
		//adding login success mesg in flas scope
		flashMap.addFlashAttribute("status", details.getRole() + " Login successful");
		//adding logged in user dtls under session scope
		hs.setAttribute("user_dtls", details);
		if (details.getRole().equals("admin")) {
			flashMap.addFlashAttribute("vendor_list", service.listVendors());
			return "redirect:/vendor/list";// admin login
		}
		// response.sendRedirect(response.encodeRedicrectURL
		// ("/vendor/details"))
		return "redirect:/vendor/details"; // vendor logged in
	}

	// request handling method to logout the Vendor
	@GetMapping("/logout")
	public String logoutVendor(Model map, HttpSession hs, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in logout");
		// copy user_dtls from session scope----->request scope(model map)
		map.addAttribute("user_info", hs.getAttribute("user_dtls"));
		// discard session
		hs.invalidate();
		// auto redirect clnt after a delay to index page
		response.setHeader("refresh", "5;url=" + request.getContextPath());
		return "/user/logout";
	}

}
