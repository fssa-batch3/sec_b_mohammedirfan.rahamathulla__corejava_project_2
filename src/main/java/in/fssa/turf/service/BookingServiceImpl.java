package in.fssa.turf.service;

import java.util.List;

import in.fssa.turf.dao.BookingDAO;
import in.fssa.turf.dao.BookingDAOImpl;
import in.fssa.turf.model.Booking;
import in.fssa.turf.model.User;

public class BookingServiceImpl implements BookingService {

    private BookingDAOImpl bookingDAO;

    public BookingServiceImpl() {
        this.bookingDAO = new BookingDAOImpl();
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingDAO.findById(id);
    }

    @Override
    public List<Booking> getAllBookings(int id) {
        return bookingDAO.findAllById(id);
    }
  
    @Override
    public void saveBooking(Booking booking) {
        bookingDAO.save(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDAO.update(booking);
    }

    @Override
    public void deleteBooking(int id) {
        bookingDAO.delete(id);
    }

    @Override
    public void saveBooking1(Booking booking) {
        bookingDAO.save(booking);
    }

    @Override
    public void updateBooking1(Booking booking) {
        bookingDAO.update(booking);
    }

    @Override
    public void updateBookingStatus(int bookingid, String status) {
        bookingDAO.updatestatus(bookingid, status);
    }
    public List<Booking> findUserBookings(int userid) {
        return bookingDAO.findUserBookings(userid);
  
    }
    public List<Booking> findUserEmail(String userEmail) {
        return bookingDAO.findUserEmail(userEmail);
  
    }

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getAllBookings(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
