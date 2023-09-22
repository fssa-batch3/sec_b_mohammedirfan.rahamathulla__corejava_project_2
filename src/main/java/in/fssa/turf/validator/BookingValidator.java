package in.fssa.turf.validator;

import in.fssa.turf.model.Booking;

public class BookingValidator {

    public static boolean validateBooking(Booking booking) {
        return isNotEmpty(booking.getUseremail()) &&
               isNotEmpty(booking.getOpeninghours()) &&
               isNotEmpty(booking.getClosinghours());
    }

    private static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
