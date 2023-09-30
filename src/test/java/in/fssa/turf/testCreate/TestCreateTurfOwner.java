package in.fssa.turf.testCreate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.TurfOwner;
import in.fssa.turf.service.TurfOwnerService;

public class TestCreateTurfOwner {
		
		@Test
		public void testCreateTurfOwnerWithValidData() {
			TurfOwnerService turfOwnerService = new TurfOwnerService();
			TurfOwner turfowner = new TurfOwner();
			
			turfowner.setName("logesh");
			turfowner.setEmail("logesh@gmail.com");
			turfowner.setPassword("Logesh@1");
			
			assertDoesNotThrow(() ->{
				turfOwnerService.create(turfowner);
			});
			
		}
		
		@Test
		public void testCreateUserWithInvalidData() {
			TurfOwnerService turfOwnerService = new TurfOwnerService();
			Exception exception = assertThrows(ValidationException.class,() ->{
				turfOwnerService.create(null);
			});
			String expectedMessage = "TurfOwner cannot be null";
			String receivedMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(receivedMessage));
		}
		
		@Test
		public void testCreateTurfOwnerWithNameNull() {
			TurfOwnerService to = new TurfOwnerService();
			TurfOwner turfowner = new TurfOwner();
			
			turfowner.setName(null);
			turfowner.setEmail("logesh@gmail.com");
			turfowner.setPassword("Logesh@1");
			
			
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				to.create(turfowner);
			});
			
			String m1 = "name cannot be null or empty";
			String m2 = excp.getMessage();
			System.out.println(m2);
			assertTrue(m1.equals(m2));
		}
		
		
		
		
		@Test
		public void testCreateTurfOwnerWithNameEmpty() {
			TurfOwnerService to = new TurfOwnerService();
			TurfOwner turfowner = new TurfOwner();
			
			turfowner.setName("");
			turfowner.setEmail("logesh@gmail.com");
			turfowner.setPassword("Logesh@1");
			
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				to.create(turfowner);
			});
			
			String m1 = "name cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateTurfOwnerWithEmailNull() {
			TurfOwnerService to = new TurfOwnerService();
			TurfOwner turfowner = new TurfOwner();
			
			turfowner.setName("logesh");
			turfowner.setEmail(null);
			turfowner.setPassword("Logesh@1");
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				to.create(turfowner);
			});
			
			String m1 = "email cannot be null or empty";
			String m2 = excp.getMessage();
			System.out.println(m2);
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateTurfOwnerWithEmailEmpty() {
			TurfOwnerService to = new TurfOwnerService();
			TurfOwner turfowner = new TurfOwner();
			
			turfowner.setName("logesh");
			turfowner.setEmail("");
			turfowner.setPassword("Logesh@1");
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				to.create(turfowner);
			});
			
			String m1 = "email cannot be null or empty";
			String m2 = excp.getMessage();
			System.out.println(m2);
			assertTrue(m1.equals(m2));
		}
		
		
		@Test
		public void testCreateTurfOwnerWithIncorrectEmail() {
			TurfOwnerService to = new TurfOwnerService();
			TurfOwner turfowner = new TurfOwner();
			
			turfowner.setName("logesh");
			turfowner.setEmail("mnhbgf");
			turfowner.setPassword("Logesh@1");
			
			Exception excp = assertThrows(ValidationException.class , ()->{
				to.create(turfowner);
			});
			String m1 = "email doesn't match the required format";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		 @Test
		    public void testCreateTurfOwnerWithExistingEmail() {
		        TurfOwnerService to = new TurfOwnerService();
		        TurfOwner turfowner = new TurfOwner();
		        
		        turfowner.setName("kareem");
		        turfowner.setEmail("kareem@gmail.com");
		        turfowner.setPassword("Kareem@12");
		        
		        // Assuming TurfOwnerService.create() throws ValidationException for existing email
		        Exception excp = assertThrows(ValidationException.class , () -> {
		            to.create(turfowner);
		        });
		        
		        String m1 = "Turfowner already exists";
		        String m2 = excp.getMessage();
		        
		        assertTrue(m1.equals(m2));
		    }
		
		@Test
		public void testCreateTurfOwnerWithpasswordNull() {
			TurfOwnerService to = new TurfOwnerService();
	        TurfOwner turfowner = new TurfOwner();
	        
	        turfowner.setName("kareem");
	        turfowner.setEmail("kareem@gmail.com");
	        turfowner.setPassword(null);
			
	        Exception excp = assertThrows(ValidationException.class , ()->{
				to.create(turfowner);
			});
			String m1 = "password cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		
		
		
		@Test
		public void testCreateUserWithpasswordEmpty() {
			TurfOwnerService to = new TurfOwnerService();
	        TurfOwner turfowner = new TurfOwner();
	        
	        turfowner.setName("kareem");
	        turfowner.setEmail("kareem@gmail.com");
	        turfowner.setPassword(null);
			
			
			Exception excp = assertThrows(ValidationException.class , () ->{
				to.create(turfowner);
			});
			String m1 = "password cannot be null or empty";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		@Test
		public void testCreateUserWithincorrectPassword() {
			TurfOwnerService to = new TurfOwnerService();
	        TurfOwner turfowner = new TurfOwner();
	        
	        turfowner.setName("kareem");
	        turfowner.setEmail("kareem@gmail.com");
	        turfowner.setPassword("dgsfhgj");
			
			
	        Exception excp = assertThrows(ValidationException.class , () ->{
				to.create(turfowner);
			});
			String m1 = "Password doesn't match the required format";
			String m2 = excp.getMessage();
			assertTrue(m1.equals(m2));
		}
		
		
	}









