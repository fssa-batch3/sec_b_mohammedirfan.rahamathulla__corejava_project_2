package in.fssa.turf.testCreate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.User;
import in.fssa.turf.service.UserService;

public class TestCreateUser {
		
		@Test
		public void testCreateUserWithValidData() {
			UserService userService = new UserService();
			User user = new User();
			
			user.setFirstName("log");
			user.setLastName("esh");
			user.setEmailId("logesh@gmail.com");
			user.setPassword("Logesh@1");
			
			assertDoesNotThrow(() ->{
				userService.create(user);
			});
			
		}
		
		@Test
		public void testCreateUserWithInvalidData() {
			UserService userService = new UserService();
			Exception exception = assertThrows(ValidationException.class,() ->{
				userService.create(null);
			});
			String expectedMessage = "User cannot be null";
			String receivedMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(receivedMessage));
		}
		
		@Test
		public void testCreateUserWithFirstNameNull() {
			UserService us = new UserService();
			User user = new User();
			
			user.setFirstName(null);
			user.setLastName("thosh");
			user.setEmailId("santhoshasadasdasd@gmail.com");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.create(user);
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
			user.setLastName("box");
			user.setEmailId("bakyalakshmi@gmail.com");
			user.setPassword("Bakya@12");
			
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.create(user);
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
			user.setEmailId("bakya@gmail.com");
			user.setPassword("Bakya@12");
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.create(user);
			});
			
			String m1 = "last name cannot be null or empty";
			String m2 = excp.getMessage();
			System.out.println(m2);
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithLastNameEmpty() {
			UserService us = new UserService();
			User user = new User();
			
			user.setFirstName("san");
			user.setLastName("");
			user.setEmailId("bakya@gmail.com");
			user.setPassword("Bakya@12");
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				us.create(user);
			});
			
			String m1 = "last name cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		
		@Test
		public void testCreateUserWithIncorrectEmail() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setEmailId(";lkjhgfds");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.create(user);
			});
			String m1 = "email doesn't match the required format";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithExistingEmail() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setEmailId("santhosh@gmail.com");
			user.setPassword("Santh@12");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.create(user);
			});
			String m1 = "User already exists";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		@Test
		public void testCreateUserWithemailNull() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setEmailId(null);
			
			user.setPassword("Wqer@#@1234");
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.create(user);
			});
			String m1 = "email cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		@Test
		public void testCreateUserWithemailEmpty() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setEmailId("");
			
			user.setPassword("Wqer@#@1234");
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.create(user);
			});
			String m1 = "email cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		
		@Test
		public void testCreateUserWithpasswordNull() {
			UserService us = new UserService();
			User user = new User();
			user.setFirstName("san");
			user.setLastName("thosh");
			user.setEmailId("santhoshasadasdasd@gmail");
			
			user.setPassword(null);
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.create(user);
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
			user.setEmailId("santhoshasadasdasd@gmail");
			
			user.setPassword("");
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.create(user);
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
			user.setEmailId("santhoshasadasdasd@gmail");
			user.setPassword("123456789");
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				us.create(user);
			});
			String m1 = "Password doesn't match the required format";
			String m2 = excp.getMessage();
			System.out.println(m2);
			assertTrue(m1.equals(m2));
		}
		
		
	}









