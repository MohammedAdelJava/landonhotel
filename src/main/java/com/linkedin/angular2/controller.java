package com.linkedin.angular2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linkedin.angular2.Entity.RoomEntity;
import com.linkedin.angular2.repository.RoomRepository;

@Controller
public class controller {
	
	 @Autowired
	  RoomRepository roomRepository;
	 
	@RequestMapping("/hello")
	@ResponseBody
	public String index(){

		   System.out.println("Bootstrapping data: ");
				
				roomRepository.save(new RoomEntity(1l, 405, "200"));
				roomRepository.save(new RoomEntity(2l, 406, "220"));
				roomRepository.save(new RoomEntity(3l, 407, "250"));
				
				Iterable<RoomEntity> itr = roomRepository.findAll();
				
				System.out.println("Printing out data: ");
				for(RoomEntity room : itr) {
					System.out.println(room.getRoomNumber());
				}
		
		return "Hello from the other side";
	}

}
