package in.fssa.turf.service;
import java.util.Set;

import in.fssa.turf.dao.*;
import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.TurfOwner;
import in.fssa.turf.validator.TurfOwnerValidator;

	public class TurfOwnerService {
	/** 
	 * 
	 * @param newTurfOwner
	 * @throws ValidationException
	 */
		public void create(TurfOwner newTurfOwner) throws ValidationException{
			
			TurfOwnerValidator.validateForCreate(newTurfOwner);
			
			TurfOwnerDAO TurfOwnerDAO = new TurfOwnerDAO();
			TurfOwnerDAO.create(newTurfOwner);
			
			
		}
		
		public Set<TurfOwner> getAll() {
			TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			Set<TurfOwner> turfOwnerArray = turfOwnerDAO.findAll();
			return turfOwnerArray;
		}
		/** 
		 * 
		 * @param id
		 * @param TurfnewOwner
		 * @throws ValidationException
		 */
		
		public static void update(int id , TurfOwnerService  turfowner) throws ValidationException {
			TurfOwnerValidator.validateForUpdate(id , turfowner);
			 TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			
			 turfOwnerDAO.update(id, turfowner);
		}
		/** 
		 * 
		 * @param id
		 * @throws ValidationException
		 */
		public void delete(int id) throws ValidationException {
			TurfOwnerValidator.validateForId(id);
			TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			turfOwnerDAO.delete(id);
		}
		/** 
		 * 
		 * @param turfOwnerId
		 * @return 
		 * @return
		 * @throws ValidationException
		 */
		public static TurfOwner TurfOwner(int turfOwnerId) throws ValidationException {
			TurfOwnerValidator.validateForId(turfOwnerId);
			TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			return turfOwnerDAO.findById(turfOwnerId);
			
		}
		/** 
		 * 
		 * @param email
		 * @return
		 * @throws ValidationException
		 */
		
		public static TurfOwner getByEmail(String email) throws ValidationException{
			TurfOwnerValidator.validateForEmail(email);
			System.out.println("Validation Success");
			TurfOwnerDAO turfOwnerDAO = new TurfOwnerDAO();
			return turfOwnerDAO.findByEmail(email);
		}

		public void setName(String name) {
			// TODO Auto-generated method stub
			
		}

		public void setEmail(String email) {
			// TODO Auto-generated method stub
			
		}

		public void setPassword(String password) {
			// TODO Auto-generated method stub
			
		}

		public void setId(int id) {
			// TODO Auto-generated method stub
			
		}

		public int getId() {
			// TODO Auto-generated method stub
			return TurfOwner.getId();
		}

		public static in.fssa.turf.model.TurfOwner getById(int turfownerId) {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		
	}
