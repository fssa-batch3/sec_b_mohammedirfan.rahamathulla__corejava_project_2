package in.fssa.turf.util;
import in.fssa.turf.exception.*;
public class StringUtil {
	/** 
	 * 
	 * @param input
	 * @param inputName
	 * @throws ValidationException
	 */
     public static void rejectIfInvalidString(String input, String inputName) throws ValidationException{
    	 if(input == null || "".equals(input.trim())) {
    		 throw new ValidationException(inputName.concat(" cannot be null or empty"));
    	 }
     }
    /** 
     * 
     * @param input
     * @return
     */
     public static boolean isValidString(String input) {
 		if(input == null || "".equals(input.trim())) {
 			return true;
 		}
 		else {
 			return false;
 		}
 	}
     /** 
      * 
      * @param input
      * @return
      */
 	public static boolean isInvalidString(String input) {
 		if(input == null || "".equals(input.trim())) {
 			return false;
 		}
 		else {
 			return true;
 		}
 	}
}