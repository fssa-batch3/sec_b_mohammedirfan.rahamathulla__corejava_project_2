package in.fssa.turf.dao;

import java.util.List;

import in.fssa.turf.model.Booking;

public interface BookingDAO {
    Booking findById(int id);
    List<Booking> findAll();
    void save(Booking booking);
    void update(Booking booking);
    void delete(int id);
	void updatestatus(int bookingid, String status);
	List<Booking> findUserBookings(int userId);
	List<Booking> findUserEmail(String userEmail);
	List<Booking> findAllByEmail(String email);
}

