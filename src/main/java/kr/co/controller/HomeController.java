package kr.co.controller;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	public String home(Model model) throws Exception {

		JSONArray iataList = service.selectKRIataList();
		model.addAttribute("iataList", iataList);
		
		return "home";
	}
	
	@RequestMapping(value = "/icao", method = RequestMethod.GET)
	public String detail(Model model, String icao) throws Exception {

		JSONObject iata = service.selectOneIata(icao);
		model.addAttribute("iata", iata);
		
		return "detail";
	}
	
}
