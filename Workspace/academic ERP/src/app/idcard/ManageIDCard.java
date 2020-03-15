package app.idcard;

import java.util.List;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import common.db.Factory;
import app.common.KeyGenerator;
import app.common.Util;
import app.examinationportal.ExaminationPortalExam;
import app.login.ManageLogin;

public class ManageIDCard {

	//STATIC VARIABLES
		private static final Logger fLogger = Util.getLogger(ManageIDCard.class);
		private static SessionFactory factory;
		private static String sEntityName = "IDCard";

		public ManageIDCard()
		{

			factory = Factory.initiate("app.idcard.IDCard");
			
		}
		
		
		/**
		 * Method used to Insert and save data to PropertyRegistration
		 * @param propertyRegistrationObj
		 * @return String true or false
		 * @author Rahul Samana
		 * <p> Version 1.0
		 * <p>Created on Date 31 Oct, 2015.
		 */
		public String Insert(app.idcard.IDCard idCardObj) throws HibernateException
		{
		
			String key="";
			for (int i = 0; i < 100; i++)
			{
				
				String result;
				
				key = idCardObj.getsUniqueRequestNumber();
				
				result = Factory.SELECT(factory, "sUniqueRequestNumber", sEntityName, "sUniqueRequestNumber = '" + key + "'");
				
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
			String result = Factory.SAVE(factory, idCardObj);
			factory.close();
			return result;
		}
		
		public List<app.idcard.IDCard> checkIfIDCardRequestAlreadyExists(String argRollNo)
				throws HibernateException
		{
			 String strWhereCondition = "roll_no='"+argRollNo+"' AND request_status!='id-card-delivered'"; 
			 List<app.idcard.IDCard> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			 factory.close();
			 return returnList;
		}
		
		public String getIDCardRequestNumber(String argRegistrationNumber)
		{
			String result = null;
			String strWhereCondition = "roll_no='"+argRegistrationNumber+"'";
			List<IDCard> returnObj = Factory.GETWHERE(factory,"IDCard", strWhereCondition);
		    factory.close();
			for(int i=0;i<returnObj.size();i++)
		    {
		    	app.idcard.IDCard eachObj = returnObj.get(i);
		    	result = eachObj.getsUniqueRequestNumber();
		    	break;
		    }
		    return result;
		}
		
		public String getStatusofRequest(String argReferenceNumber)
		{
			String result = null;
			String strWhereCondition = "unique_request_number='"+argReferenceNumber+"'";
			List<IDCard> returnObj = Factory.GETWHERE(factory,"IDCard", strWhereCondition);
		    factory.close();
			if(returnObj.size()==0)
		    {
		    	result = "false";
		    }
		    else
		    {
		    	for(int i=0;i<returnObj.size();i++)
			    {
			    	app.idcard.IDCard eachObj = returnObj.get(i);
			    	result = eachObj.getsRequestStatus();
			    	break;
			    }
			  
		    }
		    return result;
			
		}
		
		public List<IDCard> getAllIDCardRequests()
		{
			String strWhereCondition = "request_status!='id-card-delivered'";
			List<IDCard> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition); 
			factory.close();
			return returnList;
		}
		
		public List<IDCard> getIDCardRequestWithRequestNumber(String argRequestNumber)
		{
			String strWhereCondition = "unique_request_number = '"+argRequestNumber+"'";
			List<IDCard> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			factory.close();
			return returnList;
		}
		
		public String updateIDCardRequestStatus(String argUniqueRequestNumber, String argIDCardRequestStatus )
				throws HibernateException
		{
			String result = Factory.UPDATE(factory, sEntityName, "sRequestStatus", argIDCardRequestStatus, "sUniqueRequestNumber", argUniqueRequestNumber);
		    factory.close();
			return result;
			
	    }
		
		public int getNumberOfNewIDCardRequests()
		{
			String strWhereCondition = "request_status = 'request-received'";
			List<IDCard> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			factory.close();
			int result = returnList.size();
			return result;
		}
}
