package in.fssa.turf.validator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import in.fssa.turf.dao.BookingDAOImpl;
import in.fssa.turf.model.Booking;

public class BookingValidator {

    public static boolean validateBooking(Booking booking) {
        return isNotEmpty(booking.getUseremail()) &&
               isNotEmpty(booking.getOpeninghours()) &&
               isNotEmpty(booking.getClosinghours()) &&
         isAlreadyExists(booking.getGameDate() , booking.getOpeninghours());
    }

    private static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    
    private static boolean isAlreadyExists(String string , String time) {
    	BookingDAOImpl bookingDAO = new BookingDAOImpl();
    	boolean result = false;
    	LocalTime at = LocalTime.parse(time);
    	List<Map<String,String>> timings = bookingDAO.findByDate(string);
    	for(Map<String,String>timing:timings) {
    		String startTime = timing.get("start_time");
    		String endTime = timing.get("end_time");
    		LocalTime st = LocalTime.parse(startTime);
    		LocalTime et = LocalTime.parse(endTime);
    		
    		if(at.equals(st)) {
    			result = true;
    		}if(at.isAfter(st) && at.isBefore(et)) {
    			result = true;
    		}
    	}
		return result;
    	
    } 
    
}
