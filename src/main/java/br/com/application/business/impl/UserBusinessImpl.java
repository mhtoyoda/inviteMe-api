package br.com.application.business.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.UserBusiness;
import br.com.application.entity.StatusType;
import br.com.application.entity.Users;
import br.com.application.exception.ErrorRepositoryException;
import br.com.application.repository.StatusTypeRepository;
import br.com.application.repository.UserRepository;

import com.google.common.collect.Lists;

@Component
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StatusTypeRepository statusTypeRepository;
	
	@Override
	public Users save(Users user) throws ErrorRepositoryException {
		try{
			return userRepository.save(user);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}

	@Override
	public Users findOne(Integer id) throws ErrorRepositoryException {
		try{
			Users user = userRepository.findOne(id);
			return user;
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}
	}
	
	@Override
	public Users updateUser(Users user) throws ErrorRepositoryException{
		try{
			Users userUpdated = findOne(user.getId());
			if(null == userUpdated){
			   return null;	
			}
			userUpdated.setName(user.getName());
			userUpdated.setLastName(user.getLastName());
			userUpdated.setEmail(user.getEmail());
			userUpdated.setDateUpdated(new Date());
			userUpdated.setGender(user.getGender());
			userUpdated.setPassword(user.getPassword());
			userUpdated.setPhoneNumber(user.getPhoneNumber());
			StatusType statusType = statusTypeRepository.findOne(user.getStatusType().getId());
			statusType.setId(statusType.getId());
			statusType.setDescription(statusType.getDescription());
			userUpdated.setStatusType(statusType);			
			return save(userUpdated);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}
	
	@Override
	//TODO implementar paginacao
	public List<Users> listAll() throws ErrorRepositoryException{
		try{
			Iterable<Users> list = userRepository.findAll();
			return Lists.newArrayList(list);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}
	}
}