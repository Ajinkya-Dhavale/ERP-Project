package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("scholarship")
public class ScholarshipController {
	@GetMapping({"/",""})
	public String getIndexPage()
	{
		return "scholarship";
	}
}
