package com.linkedin.angular2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.linkedin.angular2.Entity.RoomEntity;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long>{
	
	RoomEntity findById(Long id);
	

}
