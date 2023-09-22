package in.fssa.turf.testCreate;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.TurfEntity;
import in.fssa.turf.service.TurfService;

public class TestCreateTurf {	
			@Test
			public void testCreateUserWithValidData() {
				TurfService turfService = new TurfService();
				TurfEntity turf = new TurfEntity();
				
				turf.setName("san");
				turf.setAddress("mahalakshmi nagar");
				turf.setArea("vadalur");
				turf.setCity("Kadalur");
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				assertDoesNotThrow(() ->{
					turfService.create(turf);
				});
				
			}
			
			@Test
			public void testCreateUserWithInvalidData() {
				TurfService turfService = new TurfService();
				Exception exception = assertThrows(ValidationException.class,() ->{
					turfService.create(null);
				});
				String expectedMessage = "Turf cannot be null or empty";
				String receivedMessage = exception.getMessage();
				
				assertTrue(expectedMessage.equals(receivedMessage));
			}
			
			
			@Test
			public void testCreateTurfWithNameEmpty() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("");
				turf.setAddress("mahalakshmi nagar");
				turf.setArea("vadalur");
				turf.setCity("Kadalur");
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.create(turf);
				});
				
				String m1 = "name cannot be null or empty";
				String m2 = excp.getMessage();
				System.out.println(m2);
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , ()->{
					tu.create(turf);
				});
				
				String m1 = "name cannot be null or empty";
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");

				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
				});
				String m1 = "city cannot be null or empty";
				String m2 = excp.getMessage();
				System.out.println(m2);
				assertTrue(m1.equals(m2));
			}
			
			
			@Test
			public void testCreateTurfWithemptyCity() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity("");
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
				});
				String m1 = "city cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			
			@Test
			public void testCreateTurfWithemptyImage() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity("kadalur");
				turf.setImage("");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
				});
				String m1 = "image cannot be null or empty";
				String m2 = excp.getMessage();
				System.out.println(m2);
				assertTrue(m1.equals(m2));
			}
			@Test
			public void testCreateTurfWithNullImage() {
				TurfService tu = new TurfService();
				TurfEntity turf = new TurfEntity();
				turf.setName("san");
				turf.setAddress("mahalakshmin nagar");
				turf.setArea("vadalur");
				turf.setCity("kadalur");
				turf.setImage(null);
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
				});
				String m1 = "image cannot be null or empty";
				String m2 = excp.getMessage();
				System.out.println(m2);
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("");
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
				});
				String m1 = "opening hours cannot be null or empty";
				String m2 = excp.getMessage();
				System.out.println(m2);
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours(null);
				turf.setClosingHours("9.00PM");
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours("");
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
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
				turf.setImage("https://wallpapers.com/images/hd/virat-kohli-in-sunglasses-yc8dfpcjssp3s4se.jpg");
				turf.setOpeningHours("9.00AM");
				turf.setClosingHours(null);
				
				
				Exception excp = assertThrows(ValidationException.class , () ->{
					tu.create(turf);
				});
				String m1 = "closing hours cannot be null or empty";
				String m2 = excp.getMessage();
				assertTrue(m1.equals(m2));
			}
			
			@Test
			public void testGetTurfById() {
				assertDoesNotThrow(() -> {
					TurfService turfService = new TurfService();
					TurfEntity turf = TurfService.findByTurfId(18);
					System.out.println(turf);
				});
			}
			

}
