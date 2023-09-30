package in.fssa.turf.service;

import java.util.List;

import in.fssa.turf.model.Booking;

public interface BookingService {
    Booking getBookingById(int id);
    List<Booking> getAllBookings();
    List <Booking> findUserBookings(int userid);
    void saveBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(int id);
	void updateBooking1(Booking booking);
	void saveBooking1(Booking booking);
	void updateBookingStatus(int bookingid, String status);
	List<Booking> getAllBookings(String email);
	List<Booking> getAllBookings(int id);
}

