package br.com.application.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeConverterXsd extends XmlAdapter<String, LocalDateTime> {

	@Override
	public LocalDateTime unmarshal(String inputDate) throws Exception {
		try {
            LocalDateTime result = LocalDateTime.parse(inputDate, DateTimeFormatter.ISO_DATE_TIME);
            return result;
        } catch (DateTimeParseException ex) {
            return null;
        }
	}
	
	@Override
	public String marshal(LocalDateTime inputDateTime) throws Exception {
		return inputDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
	}
}