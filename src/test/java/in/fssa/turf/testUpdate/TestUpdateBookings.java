package in.fssa.turf.testUpdate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import in.fssa.turf.model.Booking;
import in.fssa.turf.model.TurfEntity;
import in.fssa.turf.service.BookingService;
import in.fssa.turf.service.BookingServiceImpl;
import in.fssa.turf.service.TurfService;

public class TestUpdateBookings {
	@Test
	public void testUpdateBooking() {
		BookingService bookingService = new BookingServiceImpl();
		Booking booking = new Booking();
		booking.setId(4);
		booking.setUseremail("naresh@gmail.com");
		booking.setTurfid(8);
		booking.setGameDate(LocalDate.now());
		booking.setOpeninghours("16.56");
		booking.setClosinghours("19.54");
		booking.setStatus("CANCELLED");
		
			bookingService.updateBooking(booking);
		
	}
}
