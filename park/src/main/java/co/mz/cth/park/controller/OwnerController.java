package co.mz.cth.park.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.cth.park.model.Owner;
import co.mz.cth.park.repository.OwnerRepository;

@Controller
public class OwnerController {
	@Autowired
	private OwnerRepository ownerRepository;

//    @RequestMapping("/")
//	public String starterPage() {
//		return "index";
//	}
	@RequestMapping(value="/register")
	public ModelAndView ownRegister(Owner owner) {
		ModelAndView modelAndViewer = new ModelAndView("owner/register");
		modelAndViewer.addObject("owner", new Owner());
		return modelAndViewer;
	}
	@PostMapping("/registerOwner")
	public ModelAndView ownReg(@Valid Owner owner, BindingResult rs, RedirectAttributes redirectAtrributes) {
    ModelAndView mAndVier= new ModelAndView("owner/register");
		if (rs.hasErrors()) {
	    return ownRegister(owner);    
	
        } else {
		ownerRepository.save(owner);
		redirectAtrributes.addFlashAttribute("msg", "Owner Saved successfully");
		return mAndVier;
        }
	}
	@RequestMapping("/search")
	public ModelAndView ownShow() {
		ModelAndView mv = new ModelAndView("owner/search");
		Iterable<Owner> owns = ownerRepository.findAll(); // search database; 
		mv.addObject("owners",owns ); // salva no model and view a lista e guarda na lista html
		return mv;
	}
	@RequestMapping("/delete")	
	public String delete(long id) {
		Owner device = ownerRepository.findById(id);
		ownerRepository.delete(device);
		return "redirect:/search";



	}
	@GetMapping("/update/{id}")
	public String updateform( @PathVariable("id") long id, Model model) {		
		Owner owner = ownerRepository.findById(id);
		model.addAttribute("owner", owner);
		return "owner/update";
	}

	@PostMapping("/update/{id}")
	public String updateOwner(@PathVariable("id") long id, @Valid Owner owner, BindingResult result, Model model) {
		if(result.hasErrors()) {
			owner.setId(id);
			return "owner/update";

		}
		ownerRepository.save(owner);
		model.addAttribute("owner",ownerRepository.findAll());
		return "redirect:/search";



	}	


}
