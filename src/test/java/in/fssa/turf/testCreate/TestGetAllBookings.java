package in.fssa.turf.testCreate;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.fssa.turf.model.Booking;
import in.fssa.turf.service.BookingService;
import in.fssa.turf.service.BookingServiceImpl;

public class TestGetAllBookings {
	@Test
	public void testGetAllBooking() {
		BookingService bookingService = new BookingServiceImpl();
		
		Assertions.assertDoesNotThrow(() -> {
			List<Booking> allBookings = bookingService.getAllBookings();
			System.out.println(allBookings);
		});

	}
	
}
