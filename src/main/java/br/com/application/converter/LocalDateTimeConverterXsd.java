package br.com.application.converter;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeConverterXsd extends XmlAdapter<String, LocalDateTime> {

	@Override
	public LocalDateTime unmarshal(String inputDate) throws Exception {
		return LocalDateTime.parse(inputDate);
	}

	@Override
	public String marshal(LocalDateTime inputDate) throws Exception {
		return inputDate.toString();
	}
}