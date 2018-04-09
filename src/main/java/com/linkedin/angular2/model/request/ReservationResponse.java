package com.linkedin.angular2.model.request;

import java.time.LocalDate;

public class ReservationResponse {

	private Long id ;
	
	private LocalDate checkin;
	
	private LocalDate checkout;
	
	
	public ReservationResponse() {
		super();
	}

	public ReservationResponse(LocalDate checkin, LocalDate checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	
	
}
