package kr.co.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.IataService;


@Controller
public class HomeController {
	
	@Resource(name="iataService")
	private IataService service;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {

		JSONArray iataList = service.selectKRIataList();
		model.addAttribute("iataList", iataList);
		
		return "home";
	}
	
}
