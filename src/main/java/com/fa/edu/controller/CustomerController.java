package com.fa.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fa.edu.dto.CustomerDto;
import com.fa.edu.service.CustomerSevice;

@Controller
@RequestMapping("/home/customer")
public class CustomerController {
	@Autowired
	private CustomerSevice customerSevice;

	@GetMapping("/list")
	public ModelAndView showCustomer() {
		ModelAndView view = new ModelAndView("customer-list");
		view.addObject("customers", customerSevice.getAll());
		return view;
	}

	@GetMapping("/create")
	public ModelAndView createCustomer() {
		ModelAndView view = new ModelAndView("create-customer");
		view.addObject("customerDto", new CustomerDto());
		return view;
	}

	@PostMapping("/create")
	public String saveCustomer(Model model, @ModelAttribute @Valid CustomerDto customerDto, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("customerDto", customerDto);
			return "create-customer";
		}
		CustomerDto createObj = customerSevice.createObj(customerDto);
		if (createObj != null) {
			return "redirect:/home/customer/list";
		} else {
			model.addAttribute("message", "Can't create new customer because duplicate Identity card!");
			return "create-customer";
		}
	}

	@GetMapping("/update/{id}")
	public ModelAndView updateCustomer(@PathVariable("id") String id) {
		ModelAndView view = new ModelAndView("update-customer");
		view.addObject("customerDto", customerSevice.getById(id));
		return view;
	}

	@PostMapping("/update")
	public String updateCustomer(Model model, @ModelAttribute @Valid CustomerDto customerDto, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("employeeDto", customerDto);
			return "update-customer";
		}
		customerSevice.updateObj(customerDto);
		return "redirect:/home/customer/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam(value = "id") List<String> ids) {
		ids.forEach(e -> {
			customerSevice.deleteById(e);
		});
		return "redirect:/home/customer/list";
	}
}
