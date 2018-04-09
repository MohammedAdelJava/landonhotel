package convertor;

import org.springframework.core.convert.converter.Converter;

import com.linkedin.angular2.Entity.RoomEntity;
import com.linkedin.angular2.model.Links;
import com.linkedin.angular2.model.Self;
import com.linkedin.angular2.model.response.ReservableRoomResponse;
import com.linkedin.angular2.rest.ResourceConstants;

public class RoomEntityToReservaleResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
			ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
			reservationResponse.setId(source.getId());
			reservationResponse.setRoomNumber(source.getRoomNumber());
			reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
			
			Links links = new Links();
			Self self = new Self();
			self.setRef(ResourceConstants.ROOM_RESERVATION_V1  + "/" + source.getId());
			links.setSelf(self);
			
			reservationResponse.setLinks(links);
			
			return reservationResponse;
	}

}
