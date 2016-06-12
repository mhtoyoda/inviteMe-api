package br.com.application.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateConverterXsd extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String inputDate) throws Exception {
		try {
            LocalDate result = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
            return result;
        } catch (DateTimeParseException ex) {
            return null;
        }
	}

	@Override
	public String marshal(LocalDate inputDate) throws Exception {		
		return inputDate.format(DateTimeFormatter.ISO_DATE);
	}
}