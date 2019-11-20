package co.mz.cth.park.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import co.mz.cth.park.model.Room;
import co.mz.cth.park.model.RoomDay;
import co.mz.cth.park.repository.IRoom;
import co.mz.cth.park.repository.IRoomDay;
import co.mz.cth.park.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	HttpServletRequest httpServletRequest;
	@Autowired
	private IRoom iroom;
	@Autowired
	private IRoomDay iroomday;
	@Autowired
	private RoomService room_service;
	
	final String CREATE = "room_management/room_register";
	final String EDIT = "room_management/room_edit";
	final String MANAGE = "room_management/room_management_2";

	@GetMapping("/registerRoom")
	public ModelAndView form(ModelAndView model) {
		
		model.addObject("room", new Room());
		model = new ModelAndView(CREATE);
		return model;
		}
	
	
	@PostMapping("saveRoom")
	public RedirectView save(Room room, RedirectView redirectView) {
		redirectView.setUrl("registerRoom");
		redirectView.setContextRelative(true);
		
		DateTimeFormatter sdfn = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String temp_dates=httpServletRequest.getParameter("data");
		String[] datesArray = temp_dates.split(";");
		List<RoomDay> room_day = new ArrayList<RoomDay>();
	      
		
		  for(int a = 0 ; a< datesArray.length ; a++) {
			   LocalDate localdata = LocalDate.parse(datesArray[a], sdfn);
				RoomDay day = new RoomDay();
			    day.setLocaldt(localdata);
		        day.setRoom(room);
		        iroomday.save(day);
		        room_day.add(day);
		        room.setRoomday(room_day);
			    iroom.save(room);
				
		  }
		
		
		return redirectView;
		
	}
	
	@GetMapping("rooms")
	public ModelAndView show() {
	
		
		List <Room> room_temp = new ArrayList<Room>();
		List<LocalDate> date = new ArrayList<LocalDate>();
		httpServletRequest.getSession().setAttribute("date", date);
		
		Iterable<Room> list_of_room= iroom.findAll();
		
		for(Room room :list_of_room) {
			
			room.setDays(new ArrayList<LocalDate>());
			room = room_service.getRoomDays(date, room);
		}
		
		ModelAndView model  = new ModelAndView(MANAGE);
		model.addObject("rooms",room_temp);
		
		return model;
		}
	

	@GetMapping("roomsEdit")
	public ModelAndView edited(long id) {
	Room room = iroom.findById(id);
	ModelAndView model = new ModelAndView(EDIT);
	model.addObject("room", new Room());
    model.addObject("rooms", iroom.findAll());
 //   model.addObject("daysofroom", room_service.getRoomDays(room));
	return model;
		}
	
	
	
	
	
	@GetMapping("deleteRoom")
	public String delete(long id) {
		Room room = iroom.findById(id);
		iroom.delete(room);
			return "redirect:/rooms";
			
	}
	
	
	
	
	
}
