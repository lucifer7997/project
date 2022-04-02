package com.fa.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fa.edu.dto.VaccineDto;
import com.fa.edu.service.VaccineService;
import com.fa.edu.service.VaccineTypeService;

@Controller
@RequestMapping("/home/vaccine")
public class VaccineController {

	@Autowired
	private VaccineService vaccineService;

	@Autowired
	private VaccineTypeService vaccineTypeService;

	@GetMapping("/list")
	public ModelAndView showListOfVaccine() {

		ModelAndView view = new ModelAndView("vaccine-list");
		view.addObject("vaccines", vaccineService.getAll());
		return view;
	}

	@GetMapping("/create")
	public ModelAndView showCreateVaccine() {
		ModelAndView view = new ModelAndView("create-vaccine");
		view.addObject("vaccine", new VaccineDto());
		view.addObject("vaccineTypes", vaccineTypeService.getAll());
		return view;
	}

	@PostMapping("/create")
	public String postCreateVaccine(Model model, @ModelAttribute  VaccineDto vaccineDto) {		
		VaccineDto vaccine = vaccineService.createObj(vaccineDto);
		if (vaccine != null) {
			return "redirect:/home/vaccine/list";
		}
		model.addAttribute("message", "Can't create new Vaccine because duplicate Id!");
		model.addAttribute("vaccine", vaccineDto);
		return "create-vaccine";
	}

	@GetMapping("/update/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") String id) {
		ModelAndView view = new ModelAndView("update-vaccine");
		view.addObject("vaccine", vaccineService.getById(id));
		view.addObject("vaccineTypes", vaccineTypeService.getAll());
		return view;
	}

	@PostMapping("/update")
	public String postUpdateVaccine(@ModelAttribute VaccineDto vaccineDto) {
		vaccineService.updateObj(vaccineDto);

		return "redirect:/home/vaccine/list";

	}

	@GetMapping("/inactive")
	public String deleteEmployee(@RequestParam(value = "id") List<String> ids) {
		ids.forEach(e -> {
			try {
				VaccineDto byId = vaccineService.getById(e);
				byId.setStatus(false);
				vaccineService.updateObj(byId);
			} catch (Exception e2) {
				// TODO: handle exception
			}

		});
		return "redirect:/home/vaccine/list";
	}
}
