package com.linkedin.angular2.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.linkedin.angular2.Entity.ReservationEntity;

import convertor.ReservationEntityToReservationResponseConverter;
import convertor.ReservationRequestToReservationEntityConverter;
import convertor.RoomEntityToReservaleResponseConverter;

@Configuration
public class ConversionConfig {

	private Set<Converter> getConverters(){
		
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new RoomEntityToReservaleResponseConverter());
		converters.add(new ReservationRequestToReservationEntityConverter());
		converters.add(new ReservationEntityToReservationResponseConverter());
		return converters ;
	}
	
	@Autowired
	public ConversionService conversionService(){
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		
		return bean.getObject();
		
	}
}
