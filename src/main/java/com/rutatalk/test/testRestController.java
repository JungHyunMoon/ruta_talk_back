package com.rutatalk.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testRestController {

	@GetMapping("/test")
	public String test() {
		return "/polygon";
	}
}
