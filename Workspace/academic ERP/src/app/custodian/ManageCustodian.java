package app.custodian;

import java.util.List;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import common.db.Factory;
import app.common.KeyGenerator;
import app.common.Util;
import app.idcard.IDCard;
import app.idcard.ManageIDCard;
import app.login.ManageLogin;

public class ManageCustodian {
	

	//STATIC VARIABLES
		private static final Logger fLogger = Util.getLogger(ManageCustodian.class);
		private static SessionFactory factory;
		private static String sEntityName = "Custodian";

		public ManageCustodian()
		{

			factory = Factory.initiate("app.custodian.Custodian");
			
		}
		
		
		/**
		 * Method used to Insert and save data to PropertyRegistration
		 * @param propertyRegistrationObj
		 * @return String true or false
		 * @author Rahul Samana
		 * <p> Version 1.0
		 * <p>Created on Date 31 Oct, 2015.
		 */
		public String Insert(app.custodian.Custodian custodianObj) throws HibernateException
		{
		
			String key="";
			for (int i = 0; i < 100; i++)
			{
				
				String result;
				
				key = custodianObj.getsUniqueRequestNumber();
				
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
			String result = Factory.SAVE(factory, custodianObj);
			factory.close();
			return result;
		}
		
		public List<app.custodian.Custodian> checkIfCustodianRequestAlreadyExists(String argRollNo)
				throws HibernateException
		{
			 String strWhereCondition = "roll_no='"+argRollNo+"' AND request_status!='request-processed'"; 
			  
			 return Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		}
		public String getStatusofRequest(String argReferenceNumber)
		{
			String result = null;
			String strWhereCondition = "unique_request_number='"+argReferenceNumber+"'";
			List<Custodian> returnObj = Factory.GETWHERE(factory,"Custodian", strWhereCondition);
		    factory.close();
			if(returnObj.size()==0)
		    {
		    	result = "false";
		    }
		    else
		    {
		    	for(int i=0;i<returnObj.size();i++)
			    {
			    	app.custodian.Custodian eachObj = returnObj.get(i);
			    	result = eachObj.getsRequestStatus();
			    	break;
			    }
			  
		    }
		     
		    return result;
			
		}
		
		
		public List<Custodian> getCustodianRequestWithRequestNumber(String argRequestNumber)
		{
			String strWhereCondition = "unique_request_number = '"+argRequestNumber+"'";
			List<Custodian> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition); 
			factory.close();
			return returnList;
		}
		
		public List<Custodian> getAllCustodianRequests()
		{
			String strWhereCondition = "request_status!='custodian-delivered'";
			List<Custodian> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition); 
			factory.close();
			return returnList; 
		}
		
		public String updateCustodianRequestStatus(String argUniqueRequestNumber, String argIDCardRequestStatus )
				throws HibernateException
		{
			String result = Factory.UPDATE(factory, sEntityName, "sRequestStatus", argIDCardRequestStatus, "sUniqueRequestNumber", argUniqueRequestNumber); 
			factory.close();
			return result;
		}
		public int getNumberOfNewCustodianRequests()
		{
			String strWhereCondition = "request_status = 'request-received'";
			List<Custodian> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			factory.close();
			int result = returnList.size();
			return result;
		}

}
