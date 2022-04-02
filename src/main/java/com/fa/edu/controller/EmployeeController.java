package com.fa.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fa.edu.dto.EmployeeDto;
import com.fa.edu.service.EmployeeService;
import com.fa.edu.utils.FileUploadUtil;

@Controller
@RequestMapping("/home/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public ModelAndView showEmployeeList() {
		ModelAndView view = new ModelAndView("employee-list");
		List<EmployeeDto> employees = employeeService.getAll();
		view.addObject("employees", employees);
		return view;
	}

	@GetMapping("/create")
	public ModelAndView createNewEmployee() {
		ModelAndView view = new ModelAndView("create-employee");
		view.addObject("employeeDto", new EmployeeDto());
		return view;
	}

	@PostMapping("/create")
	public String saveEmployee(Model model, @ModelAttribute @Valid EmployeeDto employeeDto, BindingResult result,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {

		if (result.hasErrors()) {
			model.addAttribute("employeeDto", employeeDto);
			return "create-employee";
		}
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		employeeDto.setPhotos(fileName);
		EmployeeDto createObj = employeeService.createObj(employeeDto);

		if (createObj != null) {
			String uploadDir = "user-photos/" + createObj.getId();
			if (!fileName.isBlank()) {
				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			}
			return "redirect:/home/employee/list";
		} else {
			model.addAttribute("message", "Can't create new employee because duplicate Id!");
			return "create-employee";
		}

	}

	@GetMapping("/update/{id}")
	public ModelAndView updateEmployee(@PathVariable("id") String id) {
		ModelAndView view = new ModelAndView("update-employee");
		view.addObject("employeeDto", employeeService.getById(id));
		return view;
	}

	@PostMapping("/update")
	public String updateEmployee(Model model, @ModelAttribute @Valid EmployeeDto employeeDto, BindingResult result,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {

		if (result.hasErrors()) {
			model.addAttribute("employeeDto", employeeDto);
			return "update-employee";
		}
		EmployeeDto currentEmployee = employeeService.getById(employeeDto.getId());
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if (!fileName.isEmpty()) {
			System.out.println("filename = " + fileName);
			employeeDto.setPhotos(fileName);
			String uploadDir = "user-photos/" + employeeDto.getId();
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} else {
			employeeDto.setPhotos(currentEmployee.getPhotos());
		}

		employeeDto.setCreateDate(currentEmployee.getCreateDate());
		employeeService.updateObj(employeeDto);
		return "redirect:/home/employee/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam(value = "id") List<String> ids) {
		ids.forEach(e -> {
			try {
				EmployeeDto byId = employeeService.getById(e);
				byId.setActive(false);
				employeeService.updateObj(byId);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		
		});
		return "redirect:/home/employee/list";
	}
}
