package in.fssa.turf.testCreate;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.fssa.turf.exception.ValidationException;
import in.fssa.turf.model.Booking;
import in.fssa.turf.service.BookingService;
import in.fssa.turf.service.BookingServiceImpl;
import in.fssa.turf.service.UserService;

public class TestCreateBooking {
	@Test
	public void testCreateBookingWithValidData() {
		BookingService bookingService = new BookingServiceImpl();
		Booking booking = new Booking();
		
		booking.setUseremail("saranya@gmail.com");
		booking.setTurfid(9);
		 booking.setGameDate(java.time.LocalDate.now().toString());
		booking.setOpeninghours("9.00");
		booking.setClosinghours("10.00");
		booking.setStatus("BOOKED");
		
		Assertions.assertDoesNotThrow(() ->{
			bookingService.saveBooking(booking);
		});
			
	}
}
