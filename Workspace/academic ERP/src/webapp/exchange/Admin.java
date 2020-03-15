package webapp.exchange;

import app.common.KeyGenerator;
import app.common.SMS;
import app.custodian.Custodian;
import app.custodian.ManageCustodian;
import app.idcard.IDCard;
import app.idcard.ManageIDCard;
import app.register.ManageRegistration;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;












import org.apache.commons.io.FileUtils;

public class Admin {

	public String validateUser(String strUsername, String strPassword)
	{
		String result = "false";
		if(strUsername.equals("Administrator") && strPassword.equals("P@55ion@Click"))
		{
			result = "true";
		}
		else
		{
			result = "false";
		}
		System.gc();
		return result;
	}
	public String registerNewIDCardRequest(ArrayList<String> fieldNames, ArrayList<String> fieldValues)
	{
		String result = "false";
		app.idcard.IDCard obj = new IDCard();
		
			for(int i=0;i<fieldNames.size();i++)
			 {	 
				 if(fieldNames.get(i).equalsIgnoreCase("department"))
				 {
					 obj.setsDepartment(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("roll-no"))
				 {
					 obj.setsRollNo(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("student-blood-group"))
				 {
					 obj.setsBloodGroup(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("student-full-name"))
				 {
					 obj.setsFullName(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("student-mobile-number"))
				 {
					 obj.setsMobileNumber(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("student-date-of-birth"))
				 {
					 obj.setsDateOfBirth(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("student-address"))
				 {
					 obj.setsAddress(fieldValues.get(i));
				 }
			 }
			 app.common.KeyGenerator keygen = new KeyGenerator();
			 String unique_reference_id = keygen.randomAlphaNumeric(10);
			 obj.setsUniqueRequestNumber(unique_reference_id);
			 obj.setsRequestStatus("request-received");
			app.idcard.ManageIDCard objManage = new ManageIDCard();
			result = objManage.Insert(obj);	
			if(result.equalsIgnoreCase("true"))
			{
				result = unique_reference_id;
			}
		return result;
	}
	public String registerNewCustodianRequest(ArrayList<String> fieldNames, ArrayList<String> fieldValues)
	{
		for(int i=0;i<fieldNames.size();i++)
		{
			System.out.println(fieldNames.get(i)+"\t\t"+fieldValues.get(i));
		}
		String result = "false";
		app.custodian.Custodian obj = new Custodian();
		
			for(int i=0;i<fieldNames.size();i++)
			 {	 
				 if(fieldNames.get(i).equalsIgnoreCase("student-full-name"))
				 {
					 obj.setsStudentFullName(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("father-full-name"))
				 {
					 obj.setsFatherFullName(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("roll-no"))
				 {
					 obj.setsRollNo(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("student-date-of-birth"))
				 {
					 obj.setsDateOfBirth(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("course-name"))
				 {
					 obj.setsCourseName(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("sub-course-name"))
				 {
					 obj.setsSubCourseName(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("course-year"))
				 {
					 obj.setsCourseYear(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("course-semester"))
				 {
					 obj.setsCourseSemester(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("academic-year"))
				 {
					 obj.setsAcademicYear(fieldValues.get(i));
				 }
				 else if(fieldNames.get(i).equalsIgnoreCase("purpose"))
				 {
					 obj.setsPurpose(fieldValues.get(i));
				 }
			 }
			 app.common.KeyGenerator keygen = new KeyGenerator();
			 String unique_reference_id = keygen.randomAlphaNumeric(10);
			 obj.setsUniqueRequestNumber(unique_reference_id);
			 obj.setsRequestStatus("request-received");
			app.custodian.ManageCustodian objManage = new ManageCustodian();
			result = objManage.Insert(obj);	
			System.out.println(result);
			if(result.equalsIgnoreCase("true"))
			{
				
				result = unique_reference_id;
			}
		return result;
	}
	public String getIDCardRequestNumber(String strRegistrationNumber)
	{
		app.idcard.ManageIDCard objManage = new ManageIDCard();
	    String result = objManage.getIDCardRequestNumber(strRegistrationNumber);
		System.gc();
		return result;
	}
	
	public List<IDCard> getAllIDCardRequests()
	{
		app.idcard.ManageIDCard objManage = new ManageIDCard();
		List<IDCard> returnList = objManage.getAllIDCardRequests();
		return returnList;
	}
	
	public List<IDCard> getIDCardRequestWithRequestNumber(String strRequestNumber)
	{
		app.idcard.ManageIDCard objManage = new ManageIDCard();
		List<IDCard> returnList = objManage.getIDCardRequestWithRequestNumber(strRequestNumber);
		return returnList;
	}
 
	public String updateIDCardRequestStatus(String strUniqueRequestNumber, String strIDCardRequestStatus)
	{
		String result = "false";
		app.idcard.ManageIDCard objManage = new ManageIDCard();
	    result = objManage.updateIDCardRequestStatus(strUniqueRequestNumber,strIDCardRequestStatus);
		return result;
	}
	
	public List<Custodian> getCustodianRequestWithRequestNumber(String strRequestNumber)
	{
		app.custodian.ManageCustodian objManage = new ManageCustodian();
		List<Custodian> returnList = objManage.getCustodianRequestWithRequestNumber(strRequestNumber);
		return returnList;
	}
	
	public List<Custodian> getAllCustodianRequests()
	{
		app.custodian.ManageCustodian objManage = new ManageCustodian();
		List<Custodian> returnList = objManage.getAllCustodianRequests();
		return returnList;
	}
	
	public String updateCustodianRequestStatus(String strUniqueRequestNumber, String strIDCardRequestStatus)
	{
		String result = "false";
		app.custodian.ManageCustodian objManage = new ManageCustodian();
	    result = objManage.updateCustodianRequestStatus(strUniqueRequestNumber,strIDCardRequestStatus);
		return result;
	}
	public String getNumberOfNewIDCardRequests()
	{
		int result = 0;
		app.idcard.ManageIDCard objManage = new ManageIDCard();
		result = objManage.getNumberOfNewIDCardRequests();
		return String.valueOf(result);
	}
	public String getNumberOfNewCustodianRequests()
	{
		int result = 0;
		app.custodian.ManageCustodian objManage = new ManageCustodian();
		result = objManage.getNumberOfNewCustodianRequests();
		return String.valueOf(result);
	}
	
	public String getPhotoFilePath(String strUniqueReferenceNumber)
	{
		String filePath = System.getProperty("catalina.base"); 	
	  //filePath += "/domains/digitalmvsr.com/ROOT/app/files/"+strUniqueReferenceNumber+"/photo_scanned_copy.jpg";
		filePath = "E:/Academic ERP Software/Workspace/Local/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/academic ERP/app/database/DBConfig.properties";		
		return filePath;
	}

	
	
}
	

