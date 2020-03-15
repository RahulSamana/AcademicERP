package app.resetpassword;

import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import app.login.Login;
import app.register.Registration;
import app.register.ManageRegistration;
import app.common.KeyGenerator;
import app.common.Util;
import app.common.Email;
import app.common.Encrypt;
import app.common.SMS;
import common.db.Factory;

public class ManageResetPassword {
	
	//STATIC VARIABLES
	private static final Logger fLogger = Util.getLogger(ManageResetPassword.class);
	private static SessionFactory factory;
	private static String sEntityName = "ResetPassword";

	public ManageResetPassword()
	{

		factory = Factory.initiate("app.resetpassword.ResetPassword");
		
	}
	/**
	 * Method used to Insert and save data to PropertyRegistration
	 * @param propertyRegistrationObj
	 * @return String true or false
	 * @author Rahul Samana
	 * <p> Version 1.0
	 * <p>Created on Date 31 Oct, 2015.
	 */
	public String Insert(app.resetpassword.ResetPassword resetPasswordObj) throws HibernateException
	{
	
		String key="";
		for (int i = 0; i < 100; i++)
		{
			
			String result;
			
			key = resetPasswordObj.getsEmail();
			
			result = Factory.SELECT(factory, "sEmail", sEntityName, "sEmail = '" + key + "'");
			
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
		String result = Factory.SAVE(factory, resetPasswordObj);
		factory.close();
		return result;
	}
	public String checkPass(String strCode){
		factory.close();
		String result = "false";

			app.resetpassword.ManageResetPassword objManage = new ManageResetPassword();
	        List<ResetPassword> returnObj = null;
			returnObj = objManage.getDetailsFromTable(strCode);
			for(int i=0;i<returnObj.size();i++){
			 app.resetpassword.ResetPassword eachObj = returnObj.get(i);
			 String retrieved_code = eachObj.getsCode();
			 if(retrieved_code.equals(strCode))
			 {
				 result = "true";
				 System.gc();
				 return result;
			 }
			}
			System.gc();
			factory.close();
			return result;
}
	
	@SuppressWarnings("unchecked")
	public List<ResetPassword> getDetailsFromTable( String argCode) throws HibernateException
	{
		List<ResetPassword> returnList = Factory.GETWHERE(factory, sEntityName, 
				"code", "=", argCode);
        factory.close();
		return returnList;
	
	}
	
	public String getEmail(String strCode)
	{
		factory.close();
		String result = "false";
			app.resetpassword.ManageResetPassword objManage = new ManageResetPassword();
	        List<ResetPassword> returnObj = null;
			returnObj = objManage.getDetailsFromTable(strCode);
			for(int i=0;i<returnObj.size();i++){
			 app.resetpassword.ResetPassword eachObj = returnObj.get(i);
			 result = eachObj.getsEmail();
			}
		System.gc();
		return result;
        
	}
}