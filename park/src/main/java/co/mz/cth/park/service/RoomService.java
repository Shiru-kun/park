package co.mz.cth.park.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.mz.cth.park.model.Room;
import co.mz.cth.park.model.RoomDay;
import co.mz.cth.park.repository.IRoom;

@Service
public class RoomService {

	
	@Autowired
	IRoom iroom;
	
	
	
	public Room getById(Long id) {
		Room room = iroom.findById(id);
		return room;
	}
	public Room getRoomDays(List<LocalDate> date, Room room){
//		List<LocalDate> roomday = new ArrayList<LocalDate>();
//			roomday.add(room_day.getLocaldt());
//
//		} 
		List<RoomDay> room_day = room.getRoomday(); // carregando lista de dias 
	// this 
		List<LocalDate> days_list = new ArrayList<LocalDate>();
		
		for(RoomDay roomday:room_day) {
			days_list.add(roomday.getLocaldt());
		}
		
		List<LocalDate> days_list_temp = new ArrayList<LocalDate>();
		for (LocalDate localdt_temp : days_list) {
			for (LocalDate localDateTime : date) {
				
				
			if(localdt_temp.equals(localDateTime)) {
			     if (Math.abs(ChronoUnit.DAYS.between(localdt_temp,localDateTime))==0) {
					
			    	 days_list_temp.add(localdt_temp);
			    	 room.setDays(days_list_temp);
				}		
					
				}	
			}
			
			
//			if(roomday.equals(localdt_temp)) {
//				
//				
//				
//			}
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		return room;
	}
	
	
}
