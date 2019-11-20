package co.mz.cth.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.mz.cth.park.model.Car;
import co.mz.cth.park.model.ParkPlace;
import co.mz.cth.park.model.enums.Place;
import co.mz.cth.park.repository.CarRepository;
import co.mz.cth.park.repository.ParkPlaceRepository;

@Controller
public class ParkPlaceController{
final String SHOWFORM = "parkplace/parkplace";
@Autowired
private CarRepository carRepository;
@Autowired
private ParkPlaceRepository parkplaceRepository;

	@GetMapping("/placepark")
	public ModelAndView form() {
	
		ModelAndView modelView = new ModelAndView(SHOWFORM);
		modelView.addObject("places", Place.values());
		modelView.addObject("cars", carRepository.findAll());
		modelView.addObject("parkplace", new ParkPlace());
		return modelView;
	}
	@PostMapping("placeparkSave")
	public String placeSave(ParkPlace parkplace,@RequestParam("idOfCar")long id, Car car) {
	car =  carRepository.findById(id);
	parkplace.setCar(car);
  parkplaceRepository.save(parkplace);	
		return "redirect:/placepark";
		
		
	}

	
}