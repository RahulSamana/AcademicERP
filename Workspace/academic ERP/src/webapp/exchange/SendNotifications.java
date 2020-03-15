package webapp.exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Date;

import app.register.Registration;
import app.register.ManageRegistration;

public class SendNotifications {

	public String sendNotification(ArrayList<String> fieldNames, ArrayList<String> fieldValues)
	{
		app.common.Email email = new app.common.Email();
		ArrayList<String> toList = new ArrayList<String>();
		Date date = new Date();
		int System_year = date.getYear()+1900;
		String result = "false";
		String department = null;
		String year=null;
		String semester=null;
		String message = null;
		String faculty_name = null;
		String academic_year = "";
        
		// get all email ids of students
		
		for(int i=0;i<fieldNames.size();i++)
		{
			if(fieldNames.get(i).equalsIgnoreCase("year-sem"))
			 {
			     StringTokenizer st = new StringTokenizer(fieldValues.get(i),"_");
			     while (st.hasMoreTokens()) {
			          year = st.nextToken();
			          semester = st.nextToken();
			     }
			 
			 }
			else if(fieldNames.get(i).equalsIgnoreCase("department"))
			{
				department = fieldValues.get(i);
			}
			else if(fieldNames.get(i).equalsIgnoreCase("message"))
			{
				message = fieldValues.get(i);
			}
			else if(fieldNames.get(i).equalsIgnoreCase("faculty-name"))
			{
				faculty_name = fieldValues.get(i);
			}
		}
		
		
		academic_year = year;
		
		
		//Get Student Emails
		app.register.ManageRegistration objManage  = new ManageRegistration();
		List<app.register.Registration> studentList =  objManage.getAllStudentEmailIdsWithAcademicYear(department,academic_year);
		for(int i=0;i<studentList.size();i++)
		{
			Registration eachObj = studentList.get(i);
			toList.add(eachObj.getsEmailAddress());
		}

		String subject = "Mail Notification From Tutor, "+faculty_name;
		String body = message;
		result =email.sendEmail(toList,subject, body);
		return result;
	}
	
	public String sendPermissionRequest(String strCandidateType, String strTutorName, ArrayList<String> recipientList, String strRequest)
	{
		String result = null;
		app.common.Email email = new app.common.Email();
		ArrayList<String> toList = new ArrayList<String>();
		String subject = "Permission Request From "+strCandidateType+" , "+strTutorName;
		String body = strRequest;
		toList = recipientList;
		System.out.println(subject);
		System.out.println(body);
		for(int i=0;i<toList.size();i++)
		{
			System.out.println(toList.get(i));
		}
		result =email.sendEmail(toList,subject, body);
		return result;
	}
}
