package com.dev.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.model.Form;

@Controller
@RequestMapping("/form.html")
public class FormController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Form form = new Form();
		model.addAttribute("form", form);
		return "form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@Valid Form form, BindingResult result) {
//		model.addAttribute("form", form);
		String returnVal = "successForm";
		if(result.hasErrors()) {
			returnVal = "form";
//		} else {
//			model.addAttribute("form", form);
		}		
		return returnVal;
	}

}
