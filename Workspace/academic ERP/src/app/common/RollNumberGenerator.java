package app.common;

import app.register.ManageRegistration;

public class RollNumberGenerator {

	public String generateUniqueRollNumber(String argInstituteCode, String argUser, String argYearOfJoining, String argSubCourseName)
	{
	    String roll_number = "";
	    int last_inserted_number = getLastInsertedIDNumber(argUser, argSubCourseName, argYearOfJoining);
	    roll_number = argInstituteCode+"-"+argYearOfJoining+"-"+argInstituteCode+"-";
	    return roll_number;
	}
	
	public int getLastInsertedIDNumber(String argUser,String argSubCourseName,String argYearOfJoining)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
		int result = objManage.getLastInsertedIDNumber(argUser,argSubCourseName,argYearOfJoining);
		return result;
	}
	
	
}
