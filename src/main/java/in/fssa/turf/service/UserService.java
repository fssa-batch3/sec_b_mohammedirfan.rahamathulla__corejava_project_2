package in.fssa.turf.service;
import java.util.Set;

import in.fssa.turf.dao.*;
import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.UserEntity;
import in.fssa.turf.validator.UserValidator;

	public class UserService {
		
		public void create(UserEntity newUser) throws ValidationException{
			
			 UserValidator.validateForCreate(newUser);
			
			UserDAO userObj = new UserDAO();
			userObj.create(newUser);
			
			
		}
		
		public Set<UserEntity> getAll() {
			UserDAO userObj = new UserDAO();
			Set<UserEntity> userArray = userObj.findAll();
			return userArray;
		}
		
		
		public static void update(int id , UserEntity  newUser) throws ValidationException {
			 UserValidator.validateForUpdate(id , newUser);
			UserDAO userObj = new UserDAO();
			
			 userObj.update(id, newUser);
		}
		
		
		public void delete(int id) throws ValidationException {
			 UserValidator.validateForId(id);
			UserDAO userObj = new UserDAO();
			userObj.delete(id);
		}
		
		public static UserEntity getById(int userId) throws ValidationException {
			 UserValidator.validateForId(userId);
			UserDAO userObj = new UserDAO();
			return userObj.findById(userId);
			
		}
		
		public static UserEntity getByEmail(String email) throws ValidationException{
			 UserValidator.validateForEmail(email);
			UserDAO ud = new UserDAO();
			return ud.findByEmail(email);
		}
	}

