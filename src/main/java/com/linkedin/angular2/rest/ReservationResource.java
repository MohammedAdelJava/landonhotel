package com.linkedin.angular2.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.angular2.Entity.ReservationEntity;
import com.linkedin.angular2.Entity.RoomEntity;
import com.linkedin.angular2.model.request.ReservationRequest;
import com.linkedin.angular2.model.request.ReservationResponse;
import com.linkedin.angular2.model.response.ReservableRoomResponse;
import com.linkedin.angular2.repository.PageableRoomRepository;
import com.linkedin.angular2.repository.ReservationRespository;
import com.linkedin.angular2.repository.RoomRepository;

import convertor.RoomEntityToReservaleResponseConverter;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {

	@Autowired
	PageableRoomRepository pageableRoomRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ReservationRespository reservationRepository;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRoom(
			@RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
			@RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
			Pageable pageable) {

		Page<RoomEntity> rooms = pageableRoomRepository.findAll(pageable);

		return rooms.map(new RoomEntityToReservaleResponseConverter());
	}

	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {
		RoomEntity room = roomRepository.findById(roomId);
		System.out.println(room);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {

		System.out.println(reservationRequest);
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCheckin(reservationRequest.getCheckin());
		reservationEntity.setCheckout(reservationRequest.getCheckout());
		reservationEntity.setRoomEntity(roomRepository.findById(reservationRequest.getRoomId()));
		
		reservationRepository.save(reservationEntity);
		
		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setCheckin(reservationEntity.getCheckin());
		reservationResponse.setCheckout(reservationEntity.getCheckout());
		reservationResponse.setId(reservationEntity.getId());

		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);

	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateReservation(
			@RequestBody ReservationRequest reservationRequest) {

		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);

	}

	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
