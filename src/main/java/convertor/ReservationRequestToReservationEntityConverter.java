package convertor;

import org.springframework.core.convert.converter.Converter;

import com.linkedin.angular2.Entity.ReservationEntity;
import com.linkedin.angular2.Entity.RoomEntity;
import com.linkedin.angular2.model.request.ReservationRequest;

public class ReservationRequestToReservationEntityConverter
		implements Converter<ReservationRequest, ReservationEntity> {

	@Override
	public ReservationEntity convert(ReservationRequest source) {

		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCheckin(source.getCheckin());
		reservationEntity.setCheckout(source.getCheckout());
		reservationEntity.setRoomEntity(new RoomEntity());

		if (source.getId() != null)
			reservationEntity.setId(source.getId());

		return null;
	}

}
