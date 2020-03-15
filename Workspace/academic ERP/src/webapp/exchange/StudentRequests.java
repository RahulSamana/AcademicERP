package webapp.exchange;

import app.idcard.ManageIDCard;
import app.register.ManageRegistration;
import app.studentportal.StudentPortal;
import app.studentportal.ManageStudentPortal;

import java.util.ArrayList;
import java.util.List;

public class StudentRequests {

	public List<StudentPortal> getStudentRequestsToFaculty(String strDepartment,String strFacultyName)
	{
		List<StudentPortal> requestList = null;
		app.studentportal.ManageStudentPortal objManage = new ManageStudentPortal();
		requestList = objManage.getStudentRequestsToFaculty(strDepartment,strFacultyName);
	    return requestList;  
	}
	
	public ArrayList<String> getFacultyNames(String strDepartment)
	{
		ArrayList<String> facultyList =  new ArrayList<String>();
		app.register.ManageRegistration objManage = new ManageRegistration();
		facultyList = objManage.getRegisteredTutorDetailsNamesWithDepartment(strDepartment);
	    return facultyList;
	}
	
	public String getTotalStudentRequests(String strDepartment , String strFullName)
	{
		app.studentportal.ManageStudentPortal objManage = new ManageStudentPortal();
		String result = objManage.getTotalStudentRequests(strDepartment,strFullName);
		return result;
	}
	
}
