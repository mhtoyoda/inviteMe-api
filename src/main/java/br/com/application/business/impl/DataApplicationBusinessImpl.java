package br.com.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.DataApplicationBusiness;
import br.com.application.entity.State;
import br.com.application.repository.StateRepository;

@Component
public class DataApplicationBusinessImpl implements DataApplicationBusiness {

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public List<State> stateList(){
		return stateRepository.findAll();
	}
}
