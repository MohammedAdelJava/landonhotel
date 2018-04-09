package com.linkedin.angular2.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "Room")
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Integer roomNumber;
	
	@NotNull
	private String price;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	List<ReservationEntity> reservationEntityList ;
	
	public void addReservationEntity(ReservationEntity reservationEntity){
		if(reservationEntityList == null)
			reservationEntityList = new ArrayList<>();
		
		reservationEntityList.add(reservationEntity);
		
		
	}
	

	public RoomEntity() {
		super();
	}

	

	public RoomEntity(Long id, Integer roomNumber, String price) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.price = price;
	}


	public RoomEntity(Integer roomNumber, String price) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



	public List<ReservationEntity> getReservationEntityList() {
		return reservationEntityList;
	}



	public void setReservationEntityList(List<ReservationEntity> reservationEntityList) {
		this.reservationEntityList = reservationEntityList;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((reservationEntityList == null) ? 0 : reservationEntityList.hashCode());
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomEntity other = (RoomEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (reservationEntityList == null) {
			if (other.reservationEntityList != null)
				return false;
		} else if (!reservationEntityList.equals(other.reservationEntityList))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RoomEntity [id=" + id + ", roomNumber=" + roomNumber + ", price=" + price + ", reservationEntityList="
				+ reservationEntityList + "]";
	}
	
	
	
	
	
	
	
}
