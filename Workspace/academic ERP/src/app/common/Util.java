/*
 * ************************ Util.java **********************
 * @Module		 	: Common util.
 * @Module Purpose	: Static convenience methods for common tasks, which eliminate code duplication.
 * @Outputs		  	: --
 * @Throws			: --  
 * @author			: Saurabh S Jain
 * @Revision	  	: 1.0
 * @Created on	  	: 06 June, 2015
 * **********************************************************************
 */

package app.common;

import java.util.logging.Logger;


public final class Util {

	// PRIVATE
	/** Prevent object construction.  */
	private Util() {
		throw new AssertionError();
	}
	  
	/* The application's date format. */
	@SuppressWarnings("unused")
	private static final String DATE_FORMAT = "yyyy-MM-dd";  
	  
	/**
	 * gets application log file. 
	 * @param aClass
	 * @return
	 */
	public static Logger getLogger(Class<?> aClass){
	     return Logger.getLogger(aClass.getPackage().getName());  
	}
	
	
	/**
    * Return true only if aText is not null,
    * and is not empty after trimming. (Trimming removes both
    * leading/trailing whitespace and ASCII control characters.) 
    * @param aText possibly-null.
    * @return boolean
   */
   public static boolean textHasContent(String aText) {
     return (aText != null) && (aText.trim().length() > 0);
   }

  /*
   Return true only if aNumber is in the range 
   @param aLow less than or equal to <tt>aHigh</tt>.
  */
  static public boolean isInRange( int aNumber, int aLow, int aHigh ){
    if (aLow > aHigh) {
      throw new IllegalArgumentException("Low is greater than High.");
    }
    return (aLow <= aNumber && aNumber <= aHigh);
  }
  
  public static boolean isInLengthRange(String aText, int aLow, int aHigh) {
	  if(aLow>aHigh) {
		  throw new IllegalArgumentException("Invalid code for range of length.");
	  }
	  return (aText.length()>aLow && aText.length()<aHigh) ? true : false;
  }
  
  public static String removeAllSpaces(String argString) {
	  if(argString!=null && argString.length()>0) {
		  return argString.replace("\\s+", "");
	  }
	  else {
		  throw new IllegalArgumentException("String is empty of null.");
	  }
  }

}
