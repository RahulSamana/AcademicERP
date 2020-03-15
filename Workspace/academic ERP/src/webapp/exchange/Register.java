package webapp.exchange;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Iterator;
import java.util.Calendar;





import app.common.*;
import app.login.Login;
import app.login.ManageLogin;
import app.register.ManageRegistration;
import app.register.Registration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.commons.io.FileUtils;

import com.google.gson.JsonArray;

public class Register {
	private static Properties properties = null;

	public ArrayList<String> registerNewUser( ArrayList<String> fieldNames, ArrayList<String> fieldValues)  throws IOException 
	{
		 ArrayList<String> returnResult = new ArrayList<String>();
		 String institute_code = null;
		 int academic_year_start = 0;
		 int academic_year_end = 0;
		 String academic_year_start_string =null;
		 String academic_year_end_string = null;
		 app.register.Registration obj = new app.register.Registration();
		 for(int i=0;i<fieldNames.size();i++)
		 {	 
			 if(fieldNames.get(i).equalsIgnoreCase("institute-code"))
			 {
				 institute_code = fieldValues.get(i);
			 }
		     else if(fieldNames.get(i).equalsIgnoreCase("candidate-type"))
			 {
				 obj.setsCandidateType(fieldValues.get(i));
		     }
			 else if(fieldNames.get(i).equalsIgnoreCase("course-name-student") || fieldNames.get(i).equalsIgnoreCase("course-name-tutor") || fieldNames.get(i).equalsIgnoreCase("course-name-supporting-staff"))
			 {
				 obj.setsCourseName(fieldValues.get(i));
		     }
			 else if(fieldNames.get(i).equalsIgnoreCase("sub-course-name-student") || fieldNames.get(i).equalsIgnoreCase("sub-course-name-tutor") || fieldNames.get(i).equalsIgnoreCase("sub-course-name-supporting-staff"))
			 {
				obj.setsSubCourseName(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("duration-of-course"))
			 {
				obj.setsDurationOfCourse(fieldValues.get(i));
			 }
			else if(fieldNames.get(i).equalsIgnoreCase("boarding-type"))
			 {
				 obj.setsBoardingType(fieldValues.get(i));
			 }
			else if(fieldNames.get(i).equalsIgnoreCase("year"))
			{
				int year = Integer.parseInt(fieldValues.get(i));
				obj.setsAcademicYear(year);
			}
			else if(fieldNames.get(i).equalsIgnoreCase("semester"))
			{
				obj.setsAcademicSemester(fieldValues.get(i));
			}
			 
			 else if(fieldNames.get(i).equalsIgnoreCase("student-full-name") || fieldNames.get(i).equalsIgnoreCase("tutor-full-name") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-full-name") || fieldNames.get(i).equalsIgnoreCase("others-full-name"))
			 {
				 obj.setsFullName(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("admission-type"))
			 {
				 obj.setsAdmissionType(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("tutor-designation") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-designation") || fieldNames.get(i).equalsIgnoreCase("others-designation")  )
			 {
				 obj.setsDesignation(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-date-of-birth") || fieldNames.get(i).equalsIgnoreCase("tutor-date-of-birth") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-date-of-birth") || fieldNames.get(i).equalsIgnoreCase("others-date-of-birth"))
			 {
				 obj.setsDateOfBirth(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("father-full-name") || fieldNames.get(i).equalsIgnoreCase("tutor-father-full-name") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-full-name") || fieldNames.get(i).equalsIgnoreCase("others-father-full-name"))
			 {
				 obj.setsFatherFullName(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("father-occupation") || fieldNames.get(i).equalsIgnoreCase("tutor-father-occupation") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-father-occupation") || fieldNames.get(i).equalsIgnoreCase("others-father-occupation"))
			 {
				 obj.setsFatherOccupation(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("mothers-maiden-name") || fieldNames.get(i).equalsIgnoreCase("tutor-mothers-maiden-name") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-mothers-maiden-name") || fieldNames.get(i).equalsIgnoreCase("others-mothers-maiden-name"))
			 {
				 obj.setsMotherMaidenName(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-religion") || fieldNames.get(i).equalsIgnoreCase("tutor-religion") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-religion") || fieldNames.get(i).equalsIgnoreCase("others-religion"))
			 {
				 obj.setsReligion(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-nationality")|| fieldNames.get(i).equalsIgnoreCase("tutor-nationality") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-nationality") || fieldNames.get(i).equalsIgnoreCase("others-nationality"))
			 {
				 obj.setsNationality(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-gender") || fieldNames.get(i).equalsIgnoreCase("tutor-gender") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-gender") || fieldNames.get(i).equalsIgnoreCase("others-gender"))
			 {
				 obj.setsGender(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-marital-status") || fieldNames.get(i).equalsIgnoreCase("tutor-marital-status") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-marital-status") || fieldNames.get(i).equalsIgnoreCase("others-marital-status"))
			 {
				 obj.setsMaritalStatus(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-mobile-number") || fieldNames.get(i).equalsIgnoreCase("tutor-mobile-number") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-mobile-number") || fieldNames.get(i).equalsIgnoreCase("others-mobile-number"))
			 {
				 obj.setsMobileNumber(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-email-address") || fieldNames.get(i).equalsIgnoreCase("tutor-email-address") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-email-address") || fieldNames.get(i).equalsIgnoreCase("others-email-address"))
			 {
				 obj.setsEmailAddress(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-temporary-address") || fieldNames.get(i).equalsIgnoreCase("tutor-temporary-address") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-temporary-address") || fieldNames.get(i).equalsIgnoreCase("others-temporary-address"))
			 {
				 obj.setsTemporaryAddress(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-permanent-address") || fieldNames.get(i).equalsIgnoreCase("tutor-permanent-address") || fieldNames.get(i).equalsIgnoreCase("supporting-staff-permanent-address") || fieldNames.get(i).equalsIgnoreCase("others-permanent-address"))
			 {
				 obj.setsPermanentAddress(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-eamcet-rank"))
			 {
				 obj.setsEamcetRank(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-plus-two-marks"))
			 {
				 obj.setsIntermediateMarks(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("student-ssc-marks"))
			 {
				 obj.setsSSCMarks(fieldValues.get(i));
			 } 	 
		 }
		 
		 if(obj.getsCandidateType().equalsIgnoreCase("Student"))
		 {
			String fee_amount =  getJsonValue("fee-structure.json", "items", "fee_type","Tuition Fee","fee_in_Rs");
			obj.setsFeePaymentStatus1stYear("payment-pending");
			obj.setsFeePaymentStatus2ndYear("payment-pending");
			obj.setsFeePaymentStatus3rdYear("payment-pending");
			obj.setsFeePaymentStatus4thYear("payment-pending");
			obj.setsFeePaymentStatus5thYear("payment-pending");
			obj.setsFeePaymentStatus6thYear("payment-pending");
			obj.setsFeePaymentStatus7thYear("payment-pending");
			obj.setsFeePaymentStatus8thYear("payment-pending");
			obj.setsFeePaymentStatus9thYear("payment-pending");
			obj.setsFeePaymentStatus10thYear("payment-pending");
			obj.setsFeePaymentStatus11thYear("payment-pending");
			obj.setsFeePaymentStatus12thYear("payment-pending");
			obj.setsFeeAmount(fee_amount);
			if(obj.getsAcademicSemester().equalsIgnoreCase("1st-Sem"))
			{
				obj.setiSemesterChangeCount(0);
			}
			else if(obj.getsAcademicSemester().equalsIgnoreCase("2nd-Sem"))
			{
				obj.setiSemesterChangeCount(1);
			}
		 }
		 else if(obj.getsCandidateType().equalsIgnoreCase("Tutor") || obj.getsCandidateType().equalsIgnoreCase("Supporting-Staff") || obj.getsCandidateType().equalsIgnoreCase("Others"))
		 {
			 if(obj.getsDesignation().equalsIgnoreCase("Head of the Department"))
			 {
				 String salary_amount =  getJsonValue("Head of the Department.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Assistant Professor"))
			 {
				 String salary_amount =  getJsonValue("Assistant Professor.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Associate Professor"))
			 {
				 String salary_amount =  getJsonValue("Associate Professor.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Lab Assistant"))
			 {
				 String salary_amount =  getJsonValue("Lab Assistant.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Lab Programmer"))
			 {
				 String salary_amount =  getJsonValue("Lab Programmer.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Lab Technician"))
			 {
				 String salary_amount =  getJsonValue("Lab Technician.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Cleaner"))
			 {
				 String salary_amount =  getJsonValue("Cleaner.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Attender"))
			 {
				 String salary_amount =  getJsonValue("Attender.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			 else if(obj.getsDesignation().equalsIgnoreCase("Peon"))
			 {
				 String salary_amount =  getJsonValue("Peon.json", "items", "pay_and_allowances", "Total", "amount_in_Rs");
			     obj.setsSalaryAmount(salary_amount);
			 }
			obj.setsSalaryCreditedStatus("not-credited");
		 }
		 
		 
			
		 app.common.KeyGenerator keygen = new KeyGenerator();
		 String unique_reference_id = keygen.randomAlphaNumeric(10);
		 obj.setsUniqueReferenceNumber(unique_reference_id);
		 app.register.ManageRegistration objManage = new ManageRegistration();
		 String result = objManage.Insert(obj);
		 if(obj.getsCandidateType().equalsIgnoreCase("Student"))
		 {
			 returnResult.add(result); 
			 returnResult.add(unique_reference_id);
			 returnResult.add(obj.getsCandidateType());
			 returnResult.add(obj.getsFullName());
			 returnResult.add(obj.getsCourseName());
			 returnResult.add(obj.getsSubCourseName());
			 returnResult.add(obj.getsFeePaymentStatus1stYear());
		 }
		 else if(obj.getsCandidateType().equalsIgnoreCase("Tutor") || obj.getsCandidateType().equalsIgnoreCase("Supporting-Staff"))
		 {
			 returnResult.add(result); 
			 returnResult.add(unique_reference_id);
			 returnResult.add(obj.getsCandidateType());
			 returnResult.add(obj.getsFullName());
			 returnResult.add(obj.getsCourseName());
			 returnResult.add(obj.getsSubCourseName());
			 returnResult.add(obj.getsDesignation());
			 
		 }
		 else if(obj.getsCandidateType().equalsIgnoreCase("Others"))
		 {
			 returnResult.add(result); 
			 returnResult.add(unique_reference_id);
			 returnResult.add(obj.getsCandidateType());
			 returnResult.add(obj.getsFullName());
			 returnResult.add(obj.getsDesignation());
		 }
		 return returnResult;
	}
	
	public List<Registration> getAllExistingAdmissions(String strCandidateType, String strCourseName, String strSubCourseName,String strYear)
	{
		
		List<Registration> result = null;
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.getAllExistingAdmissions(strCandidateType,strCourseName,strSubCourseName,strYear);
		System.gc();
		return result;
	}
	public List<Registration> getAllExistingAdmissions(String strRegistrationNumber)
	{
		List<Registration> result = null;
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.getAllExistingAdmissions(strRegistrationNumber);
		System.gc();
		return result;
	}
	
	
	public String deleteExistingAdmission(String strUniqueReferenceID)
	{
		String appDirectory = System.getProperty("catalina.base"); 	
		//appDirectory += "/domains/digitalmvsr.com/ROOT/app/files/";
		appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";
        String destination = appDirectory+strUniqueReferenceID;
		FileUtils.deleteQuietly(new File(destination));
	    String result = "false";
	    app.register.ManageRegistration objManage = new ManageRegistration();
	    boolean booleanresult = objManage.deleteExistingAdmission(strUniqueReferenceID);
		if(booleanresult == true)
		{
			result = "true";
		}
		else if(booleanresult == false)
		{
			result = "false";
		}
	    return result;
	}
	public String allotRollNumber(String strRegistrationNumber, String strUniqueReferenceID)
	{
		String result = "false";
		app.register.ManageRegistration objManage = new ManageRegistration();
	    result = objManage.allotRollNumber(strRegistrationNumber,strUniqueReferenceID);
		return result;
	}

	public String changeAllotedRollNumber(String strRegistrationNumber, String strUniqueReferenceID)
	{
		String result = "false";
		app.register.ManageRegistration objManage = new ManageRegistration();
	    result = objManage.changeAllotedRollNumber(strRegistrationNumber,strUniqueReferenceID);
		return result;
	}
	
	public String updateFeePaymentStatus(String strUniqueReferenceNumber, String strFeePaymentStatus)
	{
		String result = "false";
		app.register.ManageRegistration objManage = new ManageRegistration();
	    result = objManage.updateFeePaymentStatus(strUniqueReferenceNumber,strFeePaymentStatus);
		return result;
	}
	
	public String sendLoginDetails(String strUniqueReferenceID)
	{
		String result = "false";
		app.register.ManageRegistration objManage =  new ManageRegistration();

		String registered_email_address = null;
		String registrered_mobile_number = null;
		String candidate_type = null;
		app.common.KeyGenerator keygen = new KeyGenerator();
		String password = keygen.randomAlphaNumeric(6);
		
		List<Registration> returnObj = objManage.getRegisteredDetailsWithUniqueID(strUniqueReferenceID);
		for(int i=0;i<returnObj.size();i++)
		{
		   app.register.Registration eachObj = returnObj.get(i);
		   registered_email_address = eachObj.getsEmailAddress();
		   registrered_mobile_number = eachObj.getsMobileNumber();
		   candidate_type = eachObj.getsCandidateType();
		   break;
		}	
		
		String storage_status = storeLoginDetailsInDatabase(registered_email_address,password,candidate_type);
        if(storage_status.equalsIgnoreCase("true"))
        {
        	// SEND EMAIL
        	app.common.Email email = new app.common.Email();
    		ArrayList<String> toList = new ArrayList<String>();
    		String subject = "Academic ERP :- MVSR - Login Details";
    		String body = "Dear User,\nWelcome to Academic ERP :- MVSR. Your Account is Activated Successfully By the Administrator\nHere are your Login Details.\nUsername:"+registered_email_address+"\nPassword:"+password+"\nHave a Nice day\nThanks & Regards,\nTeam Academic ERP :- MVSR.";
    		toList.add(registered_email_address);
    		email.sendEmail(toList, subject, body);
    		
    		// SEND SMS
    		app.common.SMS sms = new SMS();
            String message = "Dear User,\nWelcome to Academic ERP :- MVSR.\nUsername:"+registered_email_address+"\nPassword:"+password+"\nThanks & Regards,Team Digital MVSR.";
          //  sms.sendsms(registrered_mobile_number, message);
            
        }
        else
        {
        	result = "false";
        }
     return result;
      }
	
        
		
	public String storeLoginDetailsInDatabase(String strRegisteredEmailAddress, String strPassword, String strCandidateType)
	{
	String result = "false";
	app.login.Login obj = new Login();
    obj.setsUsername(strRegisteredEmailAddress);
    obj.setsPassword(strPassword);
    strCandidateType = strCandidateType.toLowerCase();
    obj.setsRole(strCandidateType);
	app.login.ManageLogin objManage = new ManageLogin();
	result = objManage.Insert(obj);
	return result;	
	}	
	
	public ArrayList<String> getStudentDetailsFeeRelated(String strCandidateType, String strCourseName, String strSubCourseName, String strYear)
	{
		ArrayList<String> result = new ArrayList<String>();
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.getStudentDetailsFeeRelated(strCandidateType,strCourseName,strSubCourseName,strYear);
		return result;
	}
	
	public ArrayList<String> getStudentDetailsFeeRelated(String strCandidateType)
	{
		ArrayList<String> result = new ArrayList<String>();
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.getStudentDetailsFeeRelated(strCandidateType);
		return result;
	}
	
	public String getJsonValue(String strJsonFileName, String strJsonArrayLabel, String strJsonItemLabel, String strJsonKeyLabel,String strJsonValueLabel) throws FileNotFoundException
	{
		String return_result = null;
		properties = new Properties();
		String appDirectory = System.getProperty("catalina.base"); 	
		//appDirectory += "/domains/digitalmvsr.com/ROOT/app/database/DBConfig.properties";
		appDirectory = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";
		try
		{
		JSONParser parser = new JSONParser();
		FileReader fileReader = new FileReader(appDirectory);
		JSONObject json = (JSONObject) parser.parse(fileReader);
		String array = json.toJSONString();
		 JSONArray items = (JSONArray) json.get(strJsonArrayLabel);
		 Iterator<JSONObject> iterator = items.iterator();
		 while (iterator.hasNext()) {
		 JSONObject eachObj = (JSONObject) iterator.next();
		 String tempString = (String) eachObj.get(strJsonItemLabel);
		 if(tempString.equalsIgnoreCase(strJsonKeyLabel))
		 {
			 return_result = (String) eachObj.get(strJsonValueLabel);
		     break;
		 }
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return return_result;
		}
	
	public List<Registration> getAllEmployees(String strDesignation)
	{
		List<Registration> returnObj = null;
		app.register.ManageRegistration objManage = new ManageRegistration();
		returnObj = objManage.getAllEmployees(strDesignation);
		return returnObj;
	}
	public ArrayList<String> getEmployeeDetailsSalaryRelated(String strCandidateType1, String strCandidateType2, String strCandidateType3)
	{
		ArrayList<String> result = new ArrayList<String>();
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.getEmployeeDetailsSalaryRelated(strCandidateType1,strCandidateType2,strCandidateType3);
		return result;
	}
	public ArrayList<String> getDetailsForIDCard(String strEmail){
		ArrayList<String> result = new ArrayList<String>();
		app.register.ManageRegistration objManage = new ManageRegistration();
	 	result = objManage.getDetailsForIDCard(strEmail);
	 	System.gc();
		return result;
	}
	public ArrayList<String> getDetailsForCustodian(String strEmail){
		ArrayList<String> result = new ArrayList<String>();
		app.register.ManageRegistration objManage = new ManageRegistration();
	 	result = objManage.getDetailsForCustodian(strEmail);
	 	System.gc();
		return result;
	}
    
	public String getHODEmail(String strDepartment)
	{
		String result = "false";
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.getHODEmail(strDepartment);
		return result;
	}
	
	public List<Registration> getDetailsForPermissionRequest(String strDepartment){
		List<Registration> result = null;
		app.register.ManageRegistration objManage = new ManageRegistration();
	 	result = objManage.getDetailsForPermissionRequest(strDepartment);
	 	System.gc();
		return result;
	}
	
	public List<Registration> getStudentDetailsStudentPortalRequestRelated(String strDepartment){
		List<Registration> result = null;
		app.register.ManageRegistration objManage = new ManageRegistration();
	 	result = objManage.getStudentDetailsStudentPortalRequestRelated(strDepartment);
	 	System.gc();
		return result;
	}
	
	public String getDepartmentofRegisteredUser(String strEmail)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
	    String result = objManage.getDepartmentofRegisteredUser(strEmail);
	    System.gc();
		return result;
	}
	
	public String getRegistrationNumber(String strEmail)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
	    String result = objManage.getRegistrationNumber(strEmail);
		System.gc();
		return result;
	}
	
	public String getRegisteredFullName(String strEmail)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
	    String result = objManage.getRegisteredFullName(strEmail);
		System.gc();
		return result;
	}
	public String getUniqueIDUsingEmail(String strEmail)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
	    String result = objManage.getUniqueIDUsingEmail(strEmail);
		System.gc();
		return result;
	}
	public String getUniqueIDUsingRollNo(String strRollNo)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
	    String result = objManage.getUniqueIDUsingRollNo(strRollNo);
		System.gc();
		return result;
	}
	public String removeAllotedNumber( String strUniqueReferenceID)
	{
		String result ="false";
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.removeAllotedRollNumber(strUniqueReferenceID); 
		return result;
	}
	public String changeFrom2ndSemto1stSem()
	{
		String result = "false";
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.changeFrom2ndSemto1stSem();
		return result;
	}
	
	public String changeFrom1stSemto2ndSem()
	{
		String result = "false";
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.changeFrom1stSemto2ndSem();
		return result;
	}
	public List<Registration> getDetailsWithUniqueReferenceNumber(String strUniqueReferenceNumber)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
		List<Registration> returnList = objManage.getDetailsWithUniqueReferenceNumber(strUniqueReferenceNumber);
		return returnList;
	}
	public List<Registration> getFeePaymentStatus(String strUniqueReferenceNumber)
	{
		app.register.ManageRegistration objManage = new ManageRegistration();
		List<Registration> returnList = objManage.getDetailsWithUniqueReferenceNumber(strUniqueReferenceNumber);
		return returnList;
	}
	public String updateFeePaymentStatus(String strUniqueReferenceNumber, ArrayList<String> fieldNames, ArrayList<String> fieldValues)
	{
		String result = "false";
		app.register.ManageRegistration objManage = new ManageRegistration();
		result = objManage.updateFeePaymentStatus(strUniqueReferenceNumber,fieldNames,fieldValues);
		return result;
	}
	
}
