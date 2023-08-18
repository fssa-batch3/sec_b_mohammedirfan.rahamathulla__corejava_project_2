package in.fssa.turf.service;
import java.util.Set;

import in.fssa.turf.dao.*;
import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.TurfEntity;
import in.fssa.turf.model.UserEntity;
import in.fssa.turf.util.StringUtil;
import in.fssa.turf.validator.TurfValidator;
import in.fssa.turf.validator.UserValidator;

	public class TurfService {
		/** 
		 * 
		 * @param newUser
		 * @throws ValidationException
		 */
		public void create(TurfEntity newUser) throws ValidationException{
			
			 TurfValidator.validateForCreate(newUser);
			
			 TurfDAO turfObj = new TurfDAO();
			turfObj.create(newUser);
			
			
		}
		
		public Set<TurfEntity> getAll() {
			TurfDAO turfObj = new TurfDAO();
			Set<TurfEntity> turfArray = turfObj.findAll();
			return turfArray;
		}
		
		/** 
		 * 
		 * @param id
		 * @param newTurf
		 * @throws ValidationException
		 */
		public static void update(int id , TurfEntity  newTurf) throws ValidationException {
			TurfValidator.validateForUpdate(id , newTurf);
			TurfDAO turfObj = new TurfDAO();
			
			turfObj.update(id, newTurf);
		}
		
		/** 
		 * 
		 * @param id
		 * @throws ValidationException
		 */
		public void delete(int id) throws ValidationException {
			TurfValidator.validateForId(id);
			TurfDAO turfObj = new TurfDAO();
			turfObj.delete(id);
		}
		/** 
		 * 
		 * @param turfArea
		 * @return
		 * @throws ValidationException
		 */
	
		
		public static Set<TurfEntity> getByArea(String turfArea) throws ValidationException {
			 StringUtil.rejectIfInvalidString(turfArea, "turfArea");
			 TurfDAO turfObj = new TurfDAO();
			return turfObj.findAllByArea(turfArea);
			
		}
		/** 
		 * 
		 * @param turfcity
		 * @return
		 * @throws ValidationException
		 */
		public static Set<TurfEntity> getByCity(String turfcity) throws ValidationException {
			 StringUtil.rejectIfInvalidString(turfcity, "turfCity");
			 TurfDAO turfObj = new TurfDAO();
			return turfObj.findAllByCity(turfcity);
		}
		
		
		
	}
	
