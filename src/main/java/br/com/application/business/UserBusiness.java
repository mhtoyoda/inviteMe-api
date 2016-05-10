package br.com.application.business;

import java.util.List;

import br.com.application.entity.Users;
import br.com.application.exception.ErrorRepositoryException;

public interface UserBusiness {

	Users save(Users user) throws ErrorRepositoryException;

	Users findOne(Integer id) throws ErrorRepositoryException;

	Users updateUser(Users user) throws ErrorRepositoryException;

	List<Users> listAll() throws ErrorRepositoryException;
}