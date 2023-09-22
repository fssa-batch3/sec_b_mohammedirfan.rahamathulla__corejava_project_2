package in.fssa.turf.testUpdate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.User;
import in.fssa.turf.service.UserService;

public class TestUpdateUser {
		
		@Test
		public void testCreateUserWithValidData() {
			UserService userService = new UserService();
			User user = new User();
			
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("abi@gmail.com");
			user.setPassword("Santh@12");
			
			assertDoesNotThrow(() ->{
				userService.update(1, user);
			});
			
		}
		
		@Test
		public void testCreateUserWithInvalidData() {
			UserService userService = new UserService();
			Exception exception = assertThrows(ValidationException.class,() ->{
				userService.update(1, null);
			});
			String expectedMessage = "user cannot be null";
			String receivedMessage = exception.getMessage();
			System.out.println(receivedMessage);
			assertTrue(expectedMessage.equals(receivedMessage));
		}
		
		@Test
		public void testCreateUserWithFirstNameNull() {
			UserService us = new UserService();
			User user = new User();
			
			user.setFirstName(null);
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.update(1,user);
			});
			
			String m1 = "first name cannot be null or empty";
			String m2 = excp.getMessage();
			System.out.println(m2);
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithFirstNameEmpty() {
			UserService us = new UserService();
			User user = new User();
			
			user.setFirstName("");
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.update(1,user);
			});
			
			String m1 = "first name cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithLastNameNull() {
			UserService us = new UserService();
			User user = new User();
			
			user.setFirstName("san");
			user.setLastName(null);
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.update(1,user);
			});
			
			String m1 = "last name cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithLastNameEmpty() {
			UserService us = new UserService();
			User user = new User();
			
			user.setFirstName("san");
			user.setLastName("");
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.update(1,user);
			});
			
			String m1 = "last name cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithnullArea() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea(null);
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.update(1,user);
			});
			String m1 = "area cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithEmptyArea() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea("");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.update(1,user);
			});
			String m1 = "area cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		
		
		@Test
		public void testCreateUserWithnullCity() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity(null);
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.update(1,user);
			});
			String m1 = "city cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
			
		}
		
		@Test
		public void testCreateUserWithemptyCity() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity("");
			user.setEmailId("santhoshasadasdasd@gmail");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.update(1,user);
			});
			String m1 = "city cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		
		
		
		@Test
		public void testCreateUserWithpasswordNull() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail");
			
			user.setPassword(null);
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.update(1,user);
			});
			String m1 = "password cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithpasswordEmpty() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail");
			
			user.setPassword("");
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.update(1,user);
			});
			String m1 = "password cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithincorrectPassword() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setArea("vadalur");
			user.setCity("Kadalur");
			user.setEmailId("santhoshasadasdasd@gmail");
			user.setPassword("123456789");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.update(1,user);
			});
			String m1 = "Password doesn't match the required format";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		
	}









