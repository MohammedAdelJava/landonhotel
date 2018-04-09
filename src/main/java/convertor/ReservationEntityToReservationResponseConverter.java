package convertor;

import org.springframework.core.convert.converter.Converter;

import com.linkedin.angular2.Entity.ReservationEntity;
import com.linkedin.angular2.model.request.ReservationResponse;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(ReservationEntity source) {

		ReservationResponse reservationResponse = new ReservationResponse();
		reservationResponse.setCheckin(source.getCheckin());
		reservationResponse.setCheckout(source.getCheckout());
		
		return null;
	}

}
