package in.fssa.turf.validator;

 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.util.StringUtil;
import in.fssa.turf.dao.*;
import in.fssa.turf.model.*;


	
	public class UserValidator {
		/** 
		 * 
		 * @param user
		 * @throws ValidationException
		 */
		public static void validateForCreate(User user) throws ValidationException {
			if(user == null) {
				throw new ValidationException("User cannot be null");
			}
			if(user.getId()<0) {
				throw new ValidationException("id cannot be negative");
			}
			
			
			
			
			UserDAO userDao = new UserDAO();
			User user1 = userDao.findByEmail(user.getEmailId());
			if(user1!=null) {
				throw new ValidationException("User already exists");
			}
			
			StringUtil.rejectIfInvalidString(user.getFirstName(), "first name");
			StringUtil.rejectIfInvalidString(user.getEmailId(), "email");
			StringUtil.rejectIfInvalidString(user.getPassword(), "password");
			StringUtil.rejectIfInvalidString(user.getLastName(), "last name");
			StringUtil.rejectIfInvalidString(user.getArea(), "area");
			StringUtil.rejectIfInvalidString(user.getCity(), "city");
			
			
			
			
			
			Pattern ptn2 = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
			Matcher mtch2 = ptn2.matcher(user.getEmailId());
			if(mtch2.matches()==false) {
				throw new ValidationException("email doesn't match the required format");
			}
			
			String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^*&+=])(?=\\S+$).{8,}$";
	        Pattern compiledPattern = Pattern.compile(pattern);
	        Matcher matcher = compiledPattern.matcher(user.getPassword());

	        if (!matcher.matches()) {
	            throw new ValidationException("Password doesn't match the required format");
	        }
			
			
		}
		/** 
		 * 
		 * @param id
		 * @param user
		 * @throws ValidationException
		 */
		public static void validateForUpdate(int id,User user) throws ValidationException{
			if(user == null) {
				throw new ValidationException("user cannot be null");
			}
			if(user.getId()<0) {
				throw new ValidationException("id cannot be negative");
			}
			
			
			UserDAO userDao = new UserDAO();
			User user1 = userDao.findById(id);
			if(user1==null) {
				throw new ValidationException("User doesn't exists");
			}
			
			StringUtil.rejectIfInvalidString(user.getPassword(), "password");
			StringUtil.rejectIfInvalidString(user.getFirstName(), "first name");
			StringUtil.rejectIfInvalidString(user.getLastName(), "last name");
			StringUtil.rejectIfInvalidString(user.getArea(), "area");
			StringUtil.rejectIfInvalidString(user.getCity(), "city");
			
			
			
			
			
			String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^*&+=])(?=\\S+$).{8,}$";
	        Pattern compiledPattern = Pattern.compile(pattern);
	        Matcher matcher = compiledPattern.matcher(user.getPassword());

	        if (!matcher.matches()) {
	            throw new ValidationException("Password doesn't match the required format");
	        }
		}
		/** 
		 * 
		 * @param id
		 * @throws ValidationException
		 */
		public static void validateForId(int id) throws ValidationException {
			if(id <=0) {
				throw new ValidationException("id cannot be negative");
			}
			UserDAO userDao = new UserDAO();
			User user1 = userDao.findById(id);
			if(user1==null) {
				throw new ValidationException("User doesn't exists");
			}
			
		}
		/** 
		 * 
		 * @param email
		 * @throws ValidationException
		 */
		public static void validateForEmail(String email) throws ValidationException{
			StringUtil.rejectIfInvalidString(email, "email");
			
			Pattern ptn2 = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
			Matcher mtch2 = ptn2.matcher(email);
			if(mtch2.matches()==false) {
				throw new ValidationException("email doesn't match the required format");
			}
		}
		
		
	

}
