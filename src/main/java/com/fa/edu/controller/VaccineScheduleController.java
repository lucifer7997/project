package com.fa.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fa.edu.dto.VaccineScheduleDto;
import com.fa.edu.service.VaccineScheduleService;
import com.fa.edu.service.VaccineService;

@Controller
@RequestMapping("/home/vaccine-schedule")
public class VaccineScheduleController {
	@Autowired
	private VaccineScheduleService vaccineScheduleService;

	@Autowired
	private VaccineService vaccineService;

	private int vaccineScheduleId;

	@GetMapping("/list")
	public ModelAndView showVaccineScheduleList() {
		ModelAndView view = new ModelAndView("vaccine-schedule-list");
		view.addObject("vaccineSchedules", vaccineScheduleService.getAll());
		return view;
	}

	@GetMapping("/create")
	public ModelAndView createVaccineSchedule() {
		ModelAndView view = new ModelAndView("create-vaccine-schedule");
		view.addObject("vaccineScheduleDto", new VaccineScheduleDto());
		view.addObject("vaccines", vaccineService.getAll());
		return view;
	}

	@PostMapping("/create")
	public String saveVaccineSchedule(Model model, @ModelAttribute VaccineScheduleDto vaccineScheduleDto) {
		VaccineScheduleDto vaccineSchedule = vaccineScheduleService.createObj(vaccineScheduleDto);
		if (vaccineSchedule != null) {
			return "redirect:/home/vaccine-schedule/list";
		}
		model.addAttribute("vaccineSchedule", vaccineScheduleDto);
		return "create-vaccine-schedule";
	}

	@GetMapping("/update/{id}")
	public ModelAndView updateVaccineType(@PathVariable("id") Integer id) {
		System.out.println(vaccineScheduleService.getById(id));
		ModelAndView view = new ModelAndView("update-vaccine-schedule");
		vaccineScheduleId = id;
		view.addObject("vaccineScheduleDto", vaccineScheduleService.getById(id));
		view.addObject("vaccines", vaccineService.getAll());
		return view;
	}

	@PostMapping("/update")
	public String updateVaccineSchedule(@ModelAttribute VaccineScheduleDto vaccineScheduleDto) {
		vaccineScheduleDto.setScheduleId(vaccineScheduleId);
		vaccineScheduleService.updateObj(vaccineScheduleDto);
		return "redirect:/home/vaccine-schedule/list";
	}
}
