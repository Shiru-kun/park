package co.mz.cth.park.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AutentController {

	@RequestMapping("/login")
	public ModelAndView index(ModelAndView model, @AuthenticationPrincipal User user) {
	
		model = new ModelAndView ("login/loginPage");
	return model;
		
	
	}

	
	

//	@GetMapping("")
//	public ModelAndView home(ModelAndView model) {
//		model = new ModelAndView(HOME);
//
//		model.addObject("mapping", "");
//		try {
//			String redirect = "redirect:";
//			String username = SecurityContextHolder.getContext().getAuthentication().getName();
//			UserAccount userAccount = iUserAccount.findUserAccountByUsername(username);
//
//			switch (userAccount.getAccount_type()) {
//			case DRIVER:
//				redirect =redirect + "/car/home";
//				return new ModelAndView(redirect);
//			case PASSENGER:
//				redirect = redirect + "/booking/home";
//				return new ModelAndView(redirect);
//			case ADMIN:
//				redirect = redirect + "/user/home";
//				return new ModelAndView(redirect);
//			case MANAGER:
//				redirect = redirect + "/user/home";
//				return new ModelAndView(redirect);
//
//			case DRIVERMINIVAN:
//				redirect = redirect + "/races/home";
//				return new ModelAndView(redirect);
//			}
//		} catch (NullPointerException e) {
//			// TODO: handle exception
//		}
//		return model;
//	}
	
}
