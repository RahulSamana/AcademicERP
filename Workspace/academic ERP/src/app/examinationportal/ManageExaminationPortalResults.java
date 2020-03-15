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


public class ManageExaminationPortalResults {

	//STATIC VARIABLES
			private static final Logger fLogger = Util.getLogger(ManageExaminationPortalResults.class);
			private static SessionFactory factory;
			private static String sEntityName = "ExaminationPortalResults";

			public ManageExaminationPortalResults()
			{

				factory = Factory.initiate("app.examinationportal.ExaminationPortalResults");
				
			}
			public String Insert(app.examinationportal.ExaminationPortalResults objExaminationPortalResults) throws HibernateException
			{
			
				String key="";
				for (int i = 0; i < 100; i++)
				{
					
					String result;
					
					key = objExaminationPortalResults.getsTestId();
					
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
				String result = Factory.SAVE(factory, objExaminationPortalResults);
			    factory.close();
				return result;
			}
			
			
		public String getNumberofAttempts(String strTestId,String strRegistrationNumber)
		
		{
			factory.close();
			String result = "2";
			app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
			List<app.examinationportal.ExaminationPortalResults> returnObj;
			String strWhereCondition = "test_id='"+strTestId+"' AND registration_number='"+strRegistrationNumber+"'";
			returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			factory.close();
			for(int i=0;i<returnObj.size();i++){
				 app.examinationportal.ExaminationPortalResults eachObj = returnObj.get(i);
				 result = eachObj.getsNumberofAttempts();
			}
			return result;
		}
		public String updateNumberofAttempts(String strTestId,String strRegistrationNumber,int number_of_attempt) 
		{
			String result = "false";
			result = Factory.UPDATETWOWHERECONDITIONSAND(factory, sEntityName, "number_of_attempts", number_of_attempt, "test_id", strTestId, "registration_number", strRegistrationNumber);
			factory.close();
			return result;
		}
		public String checkifEntryExists(String strTestId, String strRegistrationNumber)
		{
			String result ="true";
			String strWhereCondition = "test_id='"+strTestId+"' AND registration_number='"+strRegistrationNumber+"'";
			List<app.examinationportal.ExaminationPortalResults> returnObj;
			returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			factory.close();
			if(returnObj.size()==0)
			{
			       result =  "false";
			}

			return result;
		}
		public String updateResult(String strMarks, String strTestId, String strRegistrationNumber)
		{
			String result = "false";
			result= Factory.UPDATETWOWHERECONDITIONSAND(factory, sEntityName, "marks_obtained", strMarks, "test_id", strTestId, "registration_number", strRegistrationNumber);
			factory.close();
			return result;
		}
		public List<app.examinationportal.ExaminationPortalResults> getPreviousResults(String strRegistrationNumber)
		{
			List<app.examinationportal.ExaminationPortalResults> returnList =  Factory.GETWHERE(factory, sEntityName, "registration_number", "=", strRegistrationNumber);
		    factory.close();
			return returnList; 
		}
		public List<ExaminationPortalResults> fetchResult(String strTestId, String strRegistrationNumber)
		{
			String strWhereCondition = "test_id='"+strTestId+"' AND registration_number='"+strRegistrationNumber+"'";
			List<ExaminationPortalResults> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition); 
			factory.close();
			return returnList; 
		}
		public List<ExaminationPortalResults> fetchResults(String strTestId)
		{
			String strWhereCondition = "test_id='"+strTestId+"'";
			List<ExaminationPortalResults> returnList = Factory.GETWHEREORDERBYCOLUMN(factory, sEntityName, strWhereCondition, "registration_number"); 
			factory.close();
			return returnList;
		}
		public String getTotalAttemptedTests(String argRegistrationNumber)
		{
			String strWhereCondition = "registration_number='"+argRegistrationNumber+"'";
			List<ExaminationPortalExam> returnList=  Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		    factory.close();
			int size_of_list = returnList.size();
		    String result = String.valueOf(size_of_list);
		    return result;
		}
		
	}
