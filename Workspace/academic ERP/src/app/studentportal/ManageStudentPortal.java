package app.studentportal;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import app.register.Registration;
import app.register.ManageRegistration;
import common.db.Factory;
import app.common.KeyGenerator;
import app.common.Util;

public class ManageStudentPortal {

	//STATIC VARIABLES
	private static final Logger fLogger = Util.getLogger(ManageStudentPortal.class);
	private static SessionFactory factory;
	private static String sEntityName = "StudentPortal";

	public ManageStudentPortal()
	{

		factory = Factory.initiate("app.studentportal.StudentPortal");
		
	}
	/**
	 * Method used to Insert and save data to PropertyRegistration
	 * @param propertyRegistrationObj
	 * @return String true or false
	 * @author Rahul Samana
	 * <p> Version 1.0
	 * <p>Created on Date 31 Oct, 2015.
	 */
	public String Insert(app.studentportal.StudentPortal studentPortalObj) throws HibernateException
	{
	
		String key ="";
		for (int i = 0; i < 100; i++)
		{
			
			String result;
			
			key = studentPortalObj.getsRequestId();
			
			result = Factory.SELECT(factory, "sRequestId", sEntityName, "sRequestId = '" + key + "'");
			
			if(result.length()<=2)
			{
				break;
			}
			else
			{
				continue;
			}

		}
		System.gc();
		String result = Factory.SAVE(factory, studentPortalObj);
		factory.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<StudentPortal> getAllPreviousRequests(String strDepartment) throws HibernateException
	{
		
		String strWhereCondition = "(department='"+strDepartment+"') AND (request_category='request-book' OR request_category='request-support')";
		List<StudentPortal> returnList = Factory.GETWHEREORDERBYCOLUMN(factory, sEntityName, strWhereCondition, "date_of_request"); 
		factory.close();
		return returnList;
	
	}
	
	public List<StudentPortal> getStudentRequestsToFaculty(String strDepartment,String strFacultyName) throws HibernateException
	{
		String strWhereCondition = "department='"+strDepartment+"' AND faculty_name='"+strFacultyName+"'";
		List<StudentPortal> returnList =  Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		factory.close();
		return returnList;
	}
	public String getEmailWithRequestId(String strRequestId)
	{
		String result="false";
		// GET REGISTRATION NUMBER FROM REQUEST ID
		String registration_number = null;
		String strWhereCondition = "request_id='"+strRequestId+"'";
		List<StudentPortal> studentRequestDetails = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		factory.close();
		for(int i=0;i<studentRequestDetails.size();i++)
		{
			StudentPortal eachObj = studentRequestDetails.get(i);
			 registration_number = eachObj.getsRegistrationNumber();
			break;
		}
		// GET EMAIL FROM REGISTRATION NUMBER 
		app.register.ManageRegistration objManage = new ManageRegistration();
		List<Registration> studentList = objManage.getRegisteredStudentDetailsWithRegistrationNumber(registration_number);
		for(int i=0;i<studentList.size();i++)
		{
			Registration eachObj = studentList.get(i);
			result = eachObj.getsEmailAddress();
			break;
		}
		return result;
	}
	public String getTotalStudentRequests(String argDepartment, String argFullName)
	{
		String strWhereCondition = "department='"+argDepartment+"' AND faculty_name='"+argFullName+"'";
	    List<StudentPortal> returnList =  Factory.GETWHERE(factory, sEntityName, strWhereCondition);
	    factory.close();
	    int size_of_list = returnList.size();
	    String result = String.valueOf(size_of_list);
	    return result;
	}
	
	public String getTotalPostedRequests(String argRegistrationNumber)
	{
		String strWhereCondition = "registration_number='"+argRegistrationNumber+"'";
	    List<StudentPortal> returnList =  Factory.GETWHERE(factory, sEntityName, strWhereCondition);
	    factory.close();
	    int size_of_list = returnList.size();
	    String result = String.valueOf(size_of_list);
	    return result;
	}
}
