package co.mz.cth.park.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.mz.cth.park.model.Car;

import co.mz.cth.park.model.Park;
import co.mz.cth.park.repository.CarRepository;
import co.mz.cth.park.repository.ParkRepository;

@Controller
public class ParkController {
	@Autowired
	ParkRepository parkRepository;
	@Autowired
	CarRepository carRepository;

	@Autowired
	HttpServletRequest httpServletRequest;

	@GetMapping("/parkRegister")
	public ModelAndView save() {
		ModelAndView mv = new ModelAndView("park/register");
		mv.addObject("cars", carRepository.findAll());
		mv.addObject("park", new Park());
		return mv;
	}
// 
	@PostMapping("/parkSave")
	public String save(Park park) {
		DateTimeFormatter sdfn = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String temp_dates=httpServletRequest.getParameter("dataID");
		
		park.setDatafinal(LocalDate.parse(temp_dates,sdfn));
		
		parkRepository.save(park);
		return "redirect:/parkRegister";
	}

	@RequestMapping("/deletePark")
	public String delete(long id) {
		Park park = parkRepository.findById(id);
		parkRepository.delete(park);
		return "redirect:/searchParkers";
	}

	@GetMapping("/searchParkers")
	public ModelAndView showParkers() {
		ModelAndView mv = new ModelAndView("park/search");
		 		mv.addObject("parks", parkRepository.findAll()); 
		 		//String temp_dates=httpServletRequest.getParameter("day");
		 		
		 		//mv.addObject("parker", new Park().getDatafinal());
	//System.out.println(new Park().getDatafinal());
	           return mv;
	}
}
