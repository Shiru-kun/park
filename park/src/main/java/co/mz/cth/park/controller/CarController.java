package co.mz.cth.park.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.cth.park.model.Car;
import co.mz.cth.park.model.Owner;
import co.mz.cth.park.model.Park;
import co.mz.cth.park.model.enums.Brand;
import co.mz.cth.park.repository.CarRepository;
import co.mz.cth.park.repository.OwnerRepository;
import co.mz.cth.park.repository.ParkRepository;
@Controller
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	
	
	@Autowired 
	private OwnerRepository ownerRepository;
	
	@Autowired 
	private ParkRepository parkRepository;
	@Autowired
    private ServletContext servletContext;
	
	
	@Autowired
	 private HttpServletRequest request;

		@GetMapping("/car")
		public ModelAndView novo() {
			ModelAndView mv = new ModelAndView("car/register");
		mv.addObject("owners",ownerRepository.findAll());
      mv.addObject("parks",parkRepository.findAll() );
		mv.addObject("car", new Car());
		mv.addObject("brands",Brand.values());
		return mv;
		}

		@PostMapping("carSave")
		public String novo(Car car,@RequestParam("img") MultipartFile[] fileImage,@RequestParam("ownerID")long id,BindingResult result, RedirectAttributes attributes) throws IllegalStateException, IOException {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("msg", "Car Not Saved successfully");
				
		}else {
			String srcImage = saveImageDirectory(fileImage,car.getFotoUrl());
			car.setFotoUrl(srcImage);
		
		String idparking= request.getParameter("parkID");
		long idpark = Integer.parseInt(idparking);
		Owner owner = ownerRepository.findById(id);
		Park park = parkRepository.findById(idpark);
		car.setOwner(owner);
		car.setPark(park);
        carRepository.save(car);}
		attributes.addFlashAttribute("msg", "Car Saved successfully");
		return "redirect:/car";
				
		}
		
         
		@RequestMapping("/deleteCar")	
	public String delete(long id) {
		Car car = carRepository.findById(id);
		carRepository.delete(car);
			return "redirect:/searchCar";
			
	}
		@GetMapping("/searchCar")
		public ModelAndView list( Car car) {
			ModelAndView mv = new ModelAndView("car/read_data");
		   
//	        mv.addObject("carOwners",ownerRepository.findByCar(car));
mv.addObject("cars", carRepository.findAll()); 
			return mv;
		}
		
		
		
		public String saveImageDirectory(MultipartFile[] fileImage,String urlFoto) throws IllegalStateException, IOException{
			File directory_to_createImage = new File(System.getProperty("user.dir")+File.separator+"target"+File.separator+"classes"+File.separator+servletContext.getContextPath()+File.separator+"static"+File.separator+"img"+File.separator);
			
          			String fileNameImagem = "";
              		fileNameImagem = fileImage[0].getOriginalFilename();
              		fileImage[0].transferTo(new File(directory_to_createImage+File.separator+fileNameImagem));
        			return File.separator+"img"+File.separator+fileNameImagem;
} 
		
	
		
		
		
		
		
		
				
}
