package com.fa.edu.controller;

import java.util.List;

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

import com.fa.edu.dto.VaccineTypeDto;
import com.fa.edu.service.VaccineTypeService;

@Controller
@RequestMapping("/home/vaccine-type")
public class VaccineTypeController {
	@Autowired
	private VaccineTypeService vaccineTypeService;

	@GetMapping("/list")
	public ModelAndView showVaccineTypeList() {
		ModelAndView view = new ModelAndView("vaccine-type-list");
		view.addObject("vaccineTypes", vaccineTypeService.getAll());
		return view;
	}

	@GetMapping("/create")
	public ModelAndView createVaccineType() {
		ModelAndView view = new ModelAndView("create-vaccine-type");
		view.addObject("vaccineTypeDto", new VaccineTypeDto());
		return view;
	}

	@PostMapping("/create")
	public String saveVaccineType(Model model, @ModelAttribute VaccineTypeDto vaccineTypeDto, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("vaccineTypeDto", vaccineTypeDto);
			return "create-vaccine-type";
		}
		VaccineTypeDto createObj = vaccineTypeService.createObj(vaccineTypeDto);
		if (createObj != null) {
			return "redirect:/home/vaccine-type/list";
		} else {
			model.addAttribute("message", "Can't create new vaccine type because duplicate code!");
			return "create-vaccine-type";
		}
	}

	@GetMapping("/update/{id}")
	public ModelAndView updateVaccineType(@PathVariable("id") String id) {
		ModelAndView view = new ModelAndView("update-vaccine-type");
		view.addObject("vaccineTypeDto", vaccineTypeService.getById(id));
		return view;
	}

	@PostMapping("/update")
	public String updateVaccineType(Model model, @ModelAttribute VaccineTypeDto vaccineTypeDto, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("vaccineTypeDto", vaccineTypeDto);
			return "update-vaccine-type";
		}
		vaccineTypeService.updateObj(vaccineTypeDto);
		return "redirect:/home/vaccine-type/list";
	}

	@GetMapping("/delete")
	public String deleteVaccineType(@RequestParam(value = "id") List<String> ids) {
		ids.forEach(e -> {
			vaccineTypeService.deleteById(e);
		});
		return "redirect:/home/vaccine-type/list";
	}
}
