package in.fssa.turf.validator;

 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.util.StringUtil;
import in.fssa.turf.dao.*;
import in.fssa.turf.model.*;
import in.fssa.turf.service.TurfOwnerService;


	
	public class TurfOwnerValidator {
		/** 
		 * 
		 * @param user
		 * @throws ValidationException
		 */
		public static void validateForCreate(TurfOwner turfowner) throws ValidationException {
			if(turfowner == null) {
				throw new ValidationException("TurfOwner cannot be null");
			}
			if(turfowner.getId()<0) {
				throw new ValidationException("id cannot be negative");
			}
			
			StringUtil.rejectIfInvalidString(turfowner.getName(), "name");
			StringUtil.rejectIfInvalidString(turfowner.getEmail(), "email");
			StringUtil.rejectIfInvalidString(turfowner.getPassword(), "password");
			
			Pattern ptn2 = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
			Matcher mtch2 = ptn2.matcher(turfowner.getEmail());
			if(mtch2.matches()==false) {
				throw new ValidationException("email doesn't match the required format");
			}
			
			TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			TurfOwner turfowner1 = turfOwnerDAO.findByEmail(turfowner.getEmail());
			if(turfowner1!=null) {
				throw new ValidationException("Turfowner already exists");
			}
			
			String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^*&+=])(?=\\S+$).{8,}$";
	        Pattern compiledPattern = Pattern.compile(pattern);
	        Matcher matcher = compiledPattern.matcher(turfowner.getPassword());

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
		public static void validateForUpdate(int id,TurfOwnerService turfowner) throws ValidationException{
			if(turfowner == null) {
				throw new ValidationException("turfowner cannot be null");
			}
			if(turfowner.getId()<0) {
				throw new ValidationException("id cannot be negative");
			}
			
			
			TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			TurfOwner turfowner1 = turfOwnerDAO.findById(id);
			if(turfowner1==null) {
				throw new ValidationException("TurfOwner doesn't exists");
			}
			
			StringUtil.rejectIfInvalidString(turfowner1.getName(), "name");
			StringUtil.rejectIfInvalidString(turfowner1.getEmail(), "email");
			StringUtil.rejectIfInvalidString(turfowner1.getPassword(), "password");
			
			String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^*&+=])(?=\\S+$).{8,}$";
	        Pattern compiledPattern = Pattern.compile(pattern);
	        Matcher matcher = compiledPattern.matcher(turfowner1.getPassword());

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
			TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			TurfOwner turfowner1 = turfOwnerDAO.findById(id);
			if(turfowner1==null) {
				throw new ValidationException("Turfowner doesn't exists");
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
