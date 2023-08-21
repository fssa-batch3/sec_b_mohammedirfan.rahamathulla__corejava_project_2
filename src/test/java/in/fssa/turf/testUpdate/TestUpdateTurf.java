package in.fssa.turf.testUpdate;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.TurfEntity;
import in.fssa.turf.service.TurfService;

public class TestUpdateTurf {	
			@Test
			public void testCreateUserWithValidData() {
				TurfService turfService = new TurfService();
				TurfEntity turf = new TurfEntity();
				
				turf.setName("san");
				turf.setAddress("mahalakshmi nagar");
				turf.setArea("vadalur");
				turf.setCity("Kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				assertDoesNotThrow(() ->{
					turfService.update(1,turf);
				});
				
			}
			
			@Test
			public void testCreateUserWithInvalidData() {
				TurfService turfService = new TurfService();
				Exception exception = assertThrows(ValidationException.class,() ->{
					turfService.update(1, null);
				});
				String expectedMessage = "turf cannot be null";
				String receivedMessage = exception.getMessage();
				assertTrue(expectedMessage.equals(receivedMessage));
			}
			
			@Test
			public void testCreateUserWithNameNull() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				
				turf.setName("san");
				turf.setAddress("mahalakshmi nagar");
				turf.setArea("vadalur");
				turf.setCity("Kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				
				String m1 = "name cannot be null or empty";
				String m2 = excp.getMessage();
				System.out.println(m2);
				assertTrue(m1.equals(m2));
			}
			
			@Test
			public void testCreateTurfWithNameEmpty() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("");
				turf.setAddress("mm nagar");
				turf.setArea("saidapet");
				turf.setCity("chennai");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				
				String m1 = "name cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithNameNull() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName(null);
				turf.setAddress("mahalakshmi nagar");
				turf.setArea("vadalur");
				turf.setCity("Kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				
				String m1 = "name cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithAddressEmpty() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("");
				turf.setArea("vadalur");
				turf.setCity("Kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				
				String m1 = "address cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithAddressNull() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("naveen");
				turf.setAddress(null);
				turf.setArea("pallavaram");
				turf.setCity("chennai");
				turf.setOpeningHours("10.00AM");
				turf.setClosingHours("9.00PM");
				
				

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				
				String m1 = "address cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithEmptyArea() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("");
				turf.setCity("Kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "area cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			
			@Test
			public void testCreateTurfWithnullArea() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("");
				turf.setCity("Kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "area cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			
			
			
			@Test
			public void testCreateTurfWithnullCity() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity(null);
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "city cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			
			
			@Test
			public void testCreateTurfWithemptyCity() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("surya academy");
				turf.setAddress("kamaraj nagar");
				turf.setArea("avadi");
				turf.setCity("");
				turf.setOpeningHours("8.00AM");
				turf.setClosingHours("8.00PM");
				

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "city cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			
			@Test
			public void testCreateTurfWithemptyOpeningHours() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity("kadalur");
				turf.setOpeningHours("");
				turf.setClosingHours("9.00PM");
				

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "opening hours cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithNullOpeningHours() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity("kadalur");
				turf.setOpeningHours(null);
				turf.setClosingHours("9.00PM");
				

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "opening hours cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithEmptyClosingHours() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity("kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("");
				

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "closing hours cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithNullClosingHours() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity("kadalur");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours(null);

				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.update(1, turf);
				});
				String m1 = "closing hours cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}

}
