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
			
			 TurfDAO turfDAO = new TurfDAO();
			 turfDAO.create(newUser);
			
			
		}
		
		public Set<TurfEntity> getAll() {
			TurfDAO turfDAO = new TurfDAO();
			Set<TurfEntity> turfArray = turfDAO.findAll();
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
			TurfDAO turfDAO = new TurfDAO();
			
			turfDAO.update(id, newTurf);
		}
		
		/** 
		 * 
		 * @param id
		 * @throws ValidationException
		 */
		public void delete(int id) throws ValidationException {
			TurfValidator.validateForId(id);
			TurfDAO turfDAO = new TurfDAO();
			turfDAO.delete(id);
		}
		/** 
		 * 
		 * @param turfArea
		 * @return
		 * @throws ValidationException
		 */
	
		
		public static Set<TurfEntity> getByArea(String turfArea) throws ValidationException {
			 StringUtil.rejectIfInvalidString(turfArea, "turfArea");
			 TurfDAO turfDAO = new TurfDAO();
			return turfDAO.findAllByArea(turfArea);
			
		}
		/** 
		 * 
		 * @param turfcity
		 * @return
		 * @throws ValidationException
		 */
		public static Set<TurfEntity> getByCity(String turfcity) throws ValidationException {
			 StringUtil.rejectIfInvalidString(turfcity, "turfCity");
			 TurfDAO turfDAO = new TurfDAO();
			return turfDAO.findAllByCity(turfcity);
		}
		
		
		
	}
	
