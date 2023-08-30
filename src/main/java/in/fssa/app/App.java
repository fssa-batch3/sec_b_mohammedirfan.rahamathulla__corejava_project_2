package in.fssa.app;

import in.fssa.turf.dao.TurfDAO;
import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.TurfEntity;
import in.fssa.turf.model.UserEntity;
import in.fssa.turf.service.TurfService;
import in.fssa.turf.service.UserService;

public class App {
	public static void main(String[] args) throws ValidationException {
//		UserService user = new UserService();
//		UserEntity userentity = new UserEntity();
//		userentity.setFirstName("santhosh");
//		userentity.setLastName("narayana");
//		userentity.setArea("vadalur");
//		userentity.setCity("kadalur");
//		userentity.setAddress("nesamani poniya theru");
//		userentity.setEmailId("santhosh@gmail.com");
//		userentity.setPassword("Santh@12");
//		user.create(userentity);
		
//		UserService user = new UserService();
//		UserEntity userentity = new UserEntity();
//		userentity.setFirstName("santhosh");
//		userentity.setLastName("narayana");
//		userentity.setArea("vadalur");
//		userentity.setCity("kadalur");
//		userentity.setAddress("nesamani poniya theru");
//		userentity.setPassword("Santh@12");
//		user.update(1,userentity);
		
//		UserService us = new UserService();
//		System.out.println(us.getById(4));
//		System.out.println(us.getAll());
		
		TurfService ts = new TurfService();
		System.out.println(ts.getAll());
		
		TurfEntity te = new TurfEntity();
		te.setName("surya academy");
		te.setArea("guduvanchery");
		te.setCity("chennai");
		te.setAddress("mahalakshmi nagar");
		te.setOpeningHours("9:00 AM");
		te.setClosingHours("9:00 PM");
		
		ts.update(1, te);
		
		
		
		
		
		
	}
}
