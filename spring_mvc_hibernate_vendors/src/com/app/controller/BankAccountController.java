package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.BankAccountDao;
import com.app.pojos.BankAccount;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/account")

public class BankAccountController {
	@Autowired
	private BankAccountDao dao;

	@GetMapping("/create")
	public String showCreateForm(BankAccount a) {
		System.out.println("in bank acct : show create form" + a);
		return "/account/create";
	}

	@PostMapping("/create")
	public String processCreateForm(BankAccount a, HttpSession hs, RedirectAttributes flashMap) {
		Vendor v = (Vendor) hs.getAttribute("vendor_dtls");
		System.out.println("in bank acct : process create form" + a + " " + v);
		flashMap.addFlashAttribute("status", dao.createAccount(v, a));
		return "redirect:/vendor/details";
	}

	@GetMapping("/close")
	public String closeAccount(@RequestParam int acct_id, RedirectAttributes flashMap) {
		System.out.println("in bank acct : close a/c " + acct_id);

		flashMap.addFlashAttribute("status", dao.closeAccount(acct_id));
		return "redirect:/vendor/details";
	}

}
