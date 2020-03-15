package app.login;

import java.util.List;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import common.db.Factory;
import app.common.Email;
import app.common.Encrypt;
import app.common.KeyGenerator;
import app.common.Util;
import app.register.ManageRegistration;
import app.register.Registration;
import app.resetpassword.ResetPassword;
import app.resetpassword.ManageResetPassword;
import app.login.Login;

public class ManageLogin {
	//STATIC VARIABLES
	private static final Logger fLogger = Util.getLogger(ManageLogin.class);
	private static SessionFactory factory;
	private static String sEntityName = "Login";

	public ManageLogin()
	{

		factory = Factory.initiate("app.login.Login");
		
	}
	/**
	 * Method used to Insert and save data to PropertyRegistration
	 * @param propertyRegistrationObj
	 * @return String true or false
	 * @author Rahul Samana
	 * <p> Version 1.0
	 * <p>Created on Date 31 Oct, 2015.
	 */
	public String Insert(app.login.Login loginObj) throws HibernateException
	{
	
		String key="";
		for (int i = 0; i < 100; i++)
		{
			
			String result;
			
			key = loginObj.getsUsername();
			
			result = Factory.SELECT(factory, "sUsername", sEntityName, "sUsername = '" + key + "'");
			
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
		
		String result = Factory.SAVE(factory, loginObj);
		factory.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Login> validateLogin( String argUsername, String argPassword ) throws HibernateException
	{
		List<Login> returnList = Factory.GETWHERE(factory, sEntityName,"username", "=", argUsername);
		factory.close();
		return returnList;
	
	}
	public boolean removeAllotedRollNumber( String argUniqueReferenceNumber )
			throws HibernateException
	{
		//GET EMAIL FROM UNIQUE REFERENCE ID
		app.register.ManageRegistration objManage = new ManageRegistration();
		String strEmail = objManage.getEmailFromUniqueReferenceNumber(argUniqueReferenceNumber);
		boolean result = Factory.DELETEFOREVER(factory, sEntityName, "sUsername", strEmail);
		factory.close();
		return result;
		}
	public String forgotPassword(String strEmail,String strMobile){
		factory.close();
		String result = "false";

				app.common.Email obj = new Email();
				ArrayList<String> toList = new ArrayList<String>();
				String subject = "Digital MVSR - Reset Password Link";
				String body = "Dear User,\n\nPlease use below link to reset your login password.\n\n";
				app.common.Encrypt obj1 = new Encrypt();
				if(strEmail!=null && !"".equals(strEmail) && !"null".equals(strEmail))
				{
					String encryptedCode = obj1.encrypt(strEmail);
					app.resetpassword.ResetPassword obj2 = new ResetPassword();
					try {
						obj2.setsEmail(strEmail);
						obj2.setsCode(encryptedCode);
						app.resetpassword.ManageResetPassword obj3 = new ManageResetPassword();
						result = obj3.Insert(obj2);
					} catch (Exception e) {
						result = "false";
					}
					body +="http://www.digitalmvsr.com/Login/ResetPassword/?pass="+encryptedCode;
					if(strEmail != null && !"".equals(strEmail) && !"null".equals(strEmail)) {
						strEmail = strEmail.trim();
						toList.add(strEmail);
						result = obj.sendEmail(toList, subject, body);
					}
				}
				else if(strMobile != null && !"".equals(strMobile) && !"null".equals(strMobile))
				{
					String encryptedCode = null;
					app.resetpassword.ResetPassword obj2 = new ResetPassword();
					try {
						String email ="";
						app.register.ManageRegistration objManage = new ManageRegistration();
						List<Registration> returnObj = null;
						returnObj = objManage.getRegisteredDetailsWithMobile(strMobile);
						factory.close();
						for(int i=0;i<returnObj.size();i++){
							app.register.Registration eachObj = returnObj.get(i);
							 email = eachObj.getsEmailAddress();
							 encryptedCode = obj1.encrypt(email);
						}
						try {
							obj2.setsEmail(email);
							obj2.setsCode(encryptedCode);
							app.resetpassword.ManageResetPassword obj3 = new ManageResetPassword();
							result = obj3.Insert(obj2);
							body +="http://www.digitalmvsr.com/Login/ResetPassword/?pass="+encryptedCode;
							toList.add(email);
							result = obj.sendEmail(toList, subject, body);
						} catch (Exception e) {
							result = "false";
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
				System.gc();
				factory.close();
				return result;	
			

	}
	
	public String updateForgotPassword( String argEmail, String argNewPassword)
			throws HibernateException
	{
		     String result = Factory.UPDATE(factory, sEntityName, "sPassword", argNewPassword, "sUsername", argEmail); 
		     factory.close();
		     return result;
		
		}
	
}
