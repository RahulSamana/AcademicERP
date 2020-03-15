package webapp.exchange;

import java.util.ArrayList;
import java.util.List;

import app.login.ManageLogin;
import app.register.ManageRegistration;
import app.register.Registration; 
import app.resetpassword.ManageResetPassword;
import app.resetpassword.ResetPassword;

public class Login {
	
	public ArrayList<String> validateLogin(String strUsername, String strPassword)
	{
		ArrayList<String> result = new ArrayList<String>();
	    result.add("false");
		if(strUsername.equals("Administrator") && strPassword.equals("P@55ion@Click"))
		{
			result.remove(0);
			result.add("true");
			result.add("admin");
		}
		else 
		{
			app.login.ManageLogin objManage = new ManageLogin();
			List<app.login.Login> returnObj = objManage.validateLogin(strUsername, strPassword);
			for(int i=0;i<returnObj.size();i++){
				app.login.Login eachObj = returnObj.get(i);
				String database_email = eachObj.getsUsername();
				String database_password = eachObj.getsPassword();
				if(database_email.equals(strUsername) && database_password.equals(strPassword))
				{
					result.remove(0);
					result.add("true");
					result.add(eachObj.getsRole());
					break;
				}
		}
		
	}
		return result;
	}
	public boolean removeAllotedNumber( String strUniqueReferenceID)
	{
		System.out.println(strUniqueReferenceID);
		boolean result =false;
		app.login.ManageLogin objManage = new ManageLogin();
	    result = objManage.removeAllotedRollNumber(strUniqueReferenceID);
		return result;
	}
	
	public String forgotPassword(String strEmail, String strMobile)
	{
		String result = "false";
		app.login.ManageLogin obj = new app.login.ManageLogin();
		result = obj.forgotPassword(strEmail, strMobile);
		System.gc();
		return result;
	}
	public String checkPass(String strCode){
		String result = "false";
		app.resetpassword.ManageResetPassword objManage = new ManageResetPassword();
		result = objManage.checkPass(strCode);
		return result;
	}
	public String getEmail(String strCode){
		String result = "false";
		app.resetpassword.ManageResetPassword objManage = new ManageResetPassword();
	 	result = objManage.getEmail(strCode);
	 	System.gc();
		return result;
}
	public String updateUser(String strEmail,String strNewPassword){
		String result = "false";
		app.login.ManageLogin obj = new ManageLogin();
		result = obj.updateForgotPassword(strEmail, strNewPassword);
		System.gc();
		return result;
	}
}
