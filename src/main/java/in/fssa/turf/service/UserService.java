package in.fssa.turf.service;
import java.util.Set;

import in.fssa.turf.dao.*;
import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.UserEntity;
import in.fssa.turf.validator.UserValidator;

	public class UserService {
	/** 
	 * 
	 * @param newUser
	 * @throws ValidationException
	 */
		public void create(UserEntity newUser) throws ValidationException{
			
			 UserValidator.validateForCreate(newUser);
			
			UserDAO userDAO = new UserDAO();
			userDAO.create(newUser);
			
			
		}
		
		public Set<UserEntity> getAll() {
			UserDAO userDAO = new UserDAO();
			Set<UserEntity> userArray = userDAO.findAll();
			return userArray;
		}
		/** 
		 * 
		 * @param id
		 * @param newUser
		 * @throws ValidationException
		 */
		
		public static void update(int id , UserEntity  newUser) throws ValidationException {
			 UserValidator.validateForUpdate(id , newUser);
			UserDAO userDAO = new UserDAO();
			
			userDAO.update(id, newUser);
		}
		/** 
		 * 
		 * @param id
		 * @throws ValidationException
		 */
		public void delete(int id) throws ValidationException {
			 UserValidator.validateForId(id);
			UserDAO userDAO = new UserDAO();
			userDAO.delete(id);
		}
		/** 
		 * 
		 * @param userId
		 * @return
		 * @throws ValidationException
		 */
		public static UserEntity getById(int userId) throws ValidationException {
			 UserValidator.validateForId(userId);
			UserDAO userDAO = new UserDAO();
			return userDAO.findById(userId);
			
		}
		/** 
		 * 
		 * @param email
		 * @return
		 * @throws ValidationException
		 */
		
		public static UserEntity getByEmail(String email) throws ValidationException{
			 UserValidator.validateForEmail(email);
			UserDAO userDAO = new UserDAO();
			return userDAO.findByEmail(email);
		}
	}

