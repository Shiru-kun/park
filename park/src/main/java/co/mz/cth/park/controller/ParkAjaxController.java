package co.mz.cth.park.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.mz.cth.park.model.Car;
import co.mz.cth.park.model.Room;
import co.mz.cth.park.model.enums.Brand;
import co.mz.cth.park.repository.CarRepository;
import co.mz.cth.park.repository.IRoom;
import co.mz.cth.park.repository.IRoomDay;
import co.mz.cth.park.service.RoomService;

@Controller
public class ParkAjaxController {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private IRoom iroom;
	@Autowired
	private IRoomDay iroomday;
	@Autowired
	private RoomService room_service;
	
	@RequestMapping("/file")
	public  ModelAndView quest() {
		ModelAndView mv = new ModelAndView("car/teste");
		mv.addObject("car", new Car());
		return mv;
		
	}

	
	
	@PostMapping("testeajax")
	public  String showCar(Model model ,@RequestParam("nameId") String input) {
		Car car= carRepository.findById(Integer.parseInt(input));
		Car carTemp = new Car();
		carTemp.setPlate(car.getPlate());
		model.addAttribute("car", car);
	    return "car/teste::temp";
		
		
	}
	
//	@PostMapping("/roomd")
//	public  String showModal(Model model ,@RequestParam("name") Long id) {
//		Room room = iroom.findById(id);
//		model.addAttribute("days",room_service.getRoomDays(room));
//	    return "room_management/room_management_2::temp";
//		
//		
//	}
	
}
