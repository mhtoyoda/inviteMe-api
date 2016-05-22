package br.com.application.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.application.business.UserBusiness;
import br.com.application.data.GenderData;
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
			userUpdated = new Users(user.getName(), user.getLastName(), user.getPhoneNumber(),
									user.getEmail(), GenderData.valueOf(String.valueOf(user.getGender())));						
			return save(userUpdated);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}
	
	@Override
	public Users activeUser(Users user) throws ErrorRepositoryException{
		try{
			Users userUpdated = findOne(user.getId());
			if(null == userUpdated){
			   return null;	
			}
			userUpdated.activeUser();									
			return save(userUpdated);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}
	
	@Override
	public Users inactiveUser(Users user) throws ErrorRepositoryException{
		try{
			Users userUpdated = findOne(user.getId());
			if(null == userUpdated){
			   return null;	
			}
			userUpdated.inactiveUser();									
			return save(userUpdated);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}
	
	@Override
	public Users blockUser(Users user) throws ErrorRepositoryException{
		try{
			Users userUpdated = findOne(user.getId());
			if(null == userUpdated){
			   return null;	
			}
			userUpdated.blockUser();									
			return save(userUpdated);
		}catch(Exception e){
			throw new ErrorRepositoryException(e.getMessage());
		}	
	}
	
	@Override
	public Users alterPasswordUser(Users user, String password) throws ErrorRepositoryException{
		try{
			Users userUpdated = findOne(user.getId());
			if(null == userUpdated){
			   return null;	
			}
			userUpdated.alterPassword(password);					
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