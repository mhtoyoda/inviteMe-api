package br.com.application.converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		return (localDate == null ? null : Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		return (date == null ? null : Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
	}
}