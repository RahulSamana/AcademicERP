package webapp.exchange;

import java.util.ArrayList;
import java.util.List;

import app.studentportal.StudentPortal;
import app.studentportal.ManageStudentPortal;
import app.common.*;
import app.examinationportal.ManageExaminationPortalResults;


public class Studentportal {
	
	public List<StudentPortal> getPreviousRequests(String strDepartment) {
		
		List<StudentPortal> requestsList = null;
	    app.studentportal.ManageStudentPortal objManage = new ManageStudentPortal();
	    requestsList =  objManage.getAllPreviousRequests(strDepartment);
		return requestsList;
	}
	
	public ArrayList<String> registerNewRequest(ArrayList<String> fieldNames,ArrayList<String> fieldValues){
   
		ArrayList<String> returnResult = new ArrayList<String>();
		String result = "false";
		app.studentportal.StudentPortal obj = new StudentPortal();
		for(int i=0;i<fieldNames.size();i++)
		{
		    if(fieldNames.get(i).equalsIgnoreCase("category"))
		    {
		       obj.setsRequestCategory(fieldValues.get(i));
		    }
		    else if(fieldNames.get(i).equalsIgnoreCase("department"))
		    {
		    	obj.setsDepartment(fieldValues.get(i));
		    }
		    else if(fieldNames.get(i).equalsIgnoreCase("student-name"))
		    {
		    	obj.setsStudentName(fieldValues.get(i));
		    }
		    else if(fieldNames.get(i).equalsIgnoreCase("student-name"))
		    {
		    	obj.setsStudentName(fieldValues.get(i));
		    }
		    else if(fieldNames.get(i).equalsIgnoreCase("select-target-faculty"))
		    {
		    	obj.setsFacultyName(fieldValues.get(i));
		    }
		    else if(fieldNames.get(i).equalsIgnoreCase("registration-number"))
		    {
		    	obj.setsRegistrationNumber(fieldValues.get(i));
		    }
		    else if(fieldNames.get(i).equalsIgnoreCase("request-details"))
		    {
		    	obj.setsRequest(fieldValues.get(i));
		    }
		    else if(fieldNames.get(i).equalsIgnoreCase("todays-date"))
		    {
		    	obj.setsDateOfRequest(fieldValues.get(i));
		    }
		}
		String request_id =KeyGenerator.randomAlphaNumeric(10);
		obj.setsRequestId(request_id);
		app.studentportal.ManageStudentPortal objManage = new ManageStudentPortal();
		result = objManage.Insert(obj);
		returnResult.add(result);
		returnResult.add(request_id);
		System.gc();
		return returnResult;
	}
	public String sendReply(String strRequestId, String strReply)
	{
		String result = "false";
		app.common.Email email = new app.common.Email();
		ArrayList<String> toList = new ArrayList<String>();
		//GET EMAIL ID WITH REQUEST ID
		app.studentportal.ManageStudentPortal objManage = new ManageStudentPortal();
		String email_id = objManage.getEmailWithRequestId(strRequestId);
		toList.add(email_id);
		String subject = "Reply To Your Request "+strRequestId;
		String body = strReply;
		result = email.sendEmail(toList, subject, body);
		return result;
	}
	public String getTotalPostedRequests(String strRegistrationNumber)
	{
		String result = "";
		app.studentportal.ManageStudentPortal objManage = new ManageStudentPortal();
		result = objManage.getTotalPostedRequests(strRegistrationNumber);
		System.gc();
		return result;
	}

}
