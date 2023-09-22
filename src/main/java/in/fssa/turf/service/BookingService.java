package in.fssa.turf.service;

import java.util.List;

import in.fssa.turf.model.Booking;

public interface BookingService {
    Booking getBookingById(int id);
    List<Booking> getAllBookings();
    void saveBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(int id);
	void updateBooking1(Booking booking);
	void saveBooking1(Booking booking);
	void updateBookingStatus(int bookingid, String status);
}

