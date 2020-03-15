package app.examinationportal;

import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import common.db.Factory;
import app.common.Util;
import app.login.ManageLogin;
import app.register.Registration;
import app.register.ManageRegistration;

public class ManageExaminationPortalExam {
	
	//STATIC VARIABLES
		private static final Logger fLogger = Util.getLogger(ManageLogin.class);
		private static SessionFactory factory;
		private static String sEntityName = "ExaminationPortalExam";

		public ManageExaminationPortalExam()
		{

			factory = Factory.initiate("app.examinationportal.ExaminationPortalExam");
			
		}
	
	public String getDepartmentofRegisteredUser(String strEmail)
	{
		String result = "false";

			app.register.ManageRegistration objManage= new ManageRegistration();
	        List<Registration> returnObj = null;
			returnObj = objManage.getRegisteredDetailsWithEmailID(strEmail);
			for(int i=0;i<returnObj.size();i++){
			 app.register.Registration eachObj = returnObj.get(i);
			 result = eachObj.getsSubCourseName();
			}
			System.gc();
			 
			return result;
	}
	public String Insert(app.examinationportal.ExaminationPortalExam objExaminationPortalExam) throws HibernateException
	{
	
		String key="";
		for (int i = 0; i < 100; i++)
		{
			
			String result;
			
			key = objExaminationPortalExam.getsTestId();
			
			result = Factory.SELECT(factory, "sTestId", sEntityName, "sTestId = '" + key + "'");
			
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
		 String result = Factory.SAVE(factory, objExaminationPortalExam);
		 factory.close();
		 return result;
	}
	public ArrayList<String> searchAvailableTests(String strSubject)
	{
		ArrayList<String> result = new ArrayList<String>();
		List<ExaminationPortalExam> returnObj = null;
		String strWhereCondition = "subject LIKE '%"+strSubject+"%'";
		returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		factory.close();
		for(int i=0;i<returnObj.size();i++)
		{
			app.examinationportal.ExaminationPortalExam eachObj = returnObj.get(i);
			result.add(eachObj.getsTestId());			
		}
		if(result.size()==0)
		{
			result.add("null");
		}
		System.gc();
		 
		return result;
	}
	public List<app.examinationportal.ExaminationPortalExam> fetchRegisteredExams(String strSubject)
	{
		
	String strWhereCondition = "subject LIKE '%"+strSubject+"%'";
	List<app.examinationportal.ExaminationPortalExam> returnList =  Factory.GETWHERE(factory, sEntityName, strWhereCondition);
	factory.close();
	return returnList; 
	}
	public List<ExaminationPortalExam> fetchCreatedTests(String strRegistrationNumber, String strFacultyName)
	{
		String strWhereCondition = "faculty_registration_number='"+strRegistrationNumber+"' AND faculty_name='"+strFacultyName+"'";
		List<ExaminationPortalExam> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		factory.close();
		return returnList; 
	}
	
	public String getTotalCreatedTests(String argRegistrationNumber)
	{
		String strWhereCondition = "faculty_registration_number='"+argRegistrationNumber+"'";
		List<ExaminationPortalExam> returnList=  Factory.GETWHERE(factory, sEntityName, strWhereCondition);
	    factory.close();
		int size_of_list = returnList.size();
	    String result = String.valueOf(size_of_list);	     
	    return result;
	}
	
	
}
