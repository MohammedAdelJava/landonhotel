package com.linkedin.angular2.repository;

import org.springframework.data.repository.CrudRepository;

import com.linkedin.angular2.Entity.ReservationEntity;

public interface ReservationRespository extends CrudRepository<ReservationEntity, Long> {
	
	

}
