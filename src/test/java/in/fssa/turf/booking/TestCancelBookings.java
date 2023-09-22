package in.fssa.turf.booking;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import in.fssa.turf.model.Booking;
import in.fssa.turf.service.BookingService;
import in.fssa.turf.service.BookingServiceImpl;

public class TestCancelBookings {
	@Test
	public void testCancelBooking() {
		BookingService bookingService = new BookingServiceImpl();
		
			bookingService.updateBookingStatus(2,"CANCELLED");
		
	}
}


