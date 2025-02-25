package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/library")
public class LibraryController {

	@GetMapping({"/",""})
	public String getIndex() {
		return "library";
	}
	
}
