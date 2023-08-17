package in.fssa.turf.validator;

 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.util.StringUtil;
import in.fssa.turf.dao.*;
import in.fssa.turf.model.*;


	
	public class TurfValidator {
		public static void validateForCreate(TurfEntity turf) throws ValidationException {
			if(turf == null) {
				throw new ValidationException("Turf cannot be null or empty");
			}
			if(turf.getId()<0) {
				throw new ValidationException("id cannot be negative");
			}
			
			StringUtil.rejectIfInvalidString(turf.getName(), "name");
			StringUtil.rejectIfInvalidString(turf.getAddress(), "address");
			StringUtil.rejectIfInvalidString(turf.getArea(), "area");
			StringUtil.rejectIfInvalidString(turf.getCity(), "city");
			StringUtil.rejectIfInvalidString(turf.getOpeningHours(), "opening hours");
			StringUtil.rejectIfInvalidString(turf.getClosingHours(), "closing hours");		
		}
		
		public static void validateForUpdate(int id,TurfEntity turf) throws ValidationException{
			if(turf == null) {
				throw new ValidationException("turf cannot be null or empty");
			}
			if(turf.getId()<0) {
				throw new ValidationException("id cannot be negative");
			}
			
			
			TurfDAO turfDao = new TurfDAO();
			TurfEntity turf1 = turfDao.findById(id);
			if(turf1==null) {
				throw new ValidationException("Turf doesn't exists");
			}
			
			StringUtil.rejectIfInvalidString(turf.getName(), "name");
			StringUtil.rejectIfInvalidString(turf.getAddress(), "address");
			StringUtil.rejectIfInvalidString(turf.getArea(), "area");
			StringUtil.rejectIfInvalidString(turf.getCity(), "city");
			StringUtil.rejectIfInvalidString(turf.getOpeningHours(), "opening hours");
			StringUtil.rejectIfInvalidString(turf.getClosingHours(), "closing hours");
			
		}
		
		public static void validateForId(int id) throws ValidationException {
			if(id <=0) {
				throw new ValidationException("id cannot be negative");
			}
			TurfDAO turfDAO = new TurfDAO();
			TurfEntity turf1 = turfDAO.findById(id);
			if(turf1==null) {
				throw new ValidationException("Turf doesn't exists");
			}
			
		}
		
}
