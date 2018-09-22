package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name", required = false, defaultValue = "kiki") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge", "/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value="a", required=false) Integer a, @RequestParam(value="b", required=false) Integer b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		if(a<=1 && b<=1 ) {
			model.addAttribute("hasil", "hm");
		}
		else {
			String temp = "h";
			String hasil= "";
			while(a>=1) {
				temp+="m";
				a--;
			}
			while(b>=1) {
				hasil = hasil + " "+ temp;
				b--;
			}
			model.addAttribute("hasil", hasil);
		}
		return "generator";
	}
}

