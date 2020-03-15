package webapp.exchange;

import app.common.ReadExcelSheetData;
import app.custodian.ManageCustodian;
import app.idcard.ManageIDCard;
import app.library.ManageLibrary;
import app.register.Registration;
import app.register.ManageRegistration;

import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;


public class Verify {

	
 public String checkIfAlreadyExists (String strVerificationColumn, String strVerificationID)
 {
	 String result = null;
	 app.register.ManageRegistration objManage = new ManageRegistration();
	 List<Registration> returnObj= objManage.checkIfAlreadyExists(strVerificationColumn, strVerificationID);
	 if(returnObj.size()!=0)
	 {
		 return "false";
	 }
	 else
	 {
		 return "true";
	 }
 }
 
 public String checkIfLibraryBookUniqueReferenceNumberAlreadyExists(String strUniqueReferenceNumber)
 {
	 String result = null;
	 app.library.ManageLibrary objManage = new ManageLibrary();
	 List<app.library.Library> returnObj = objManage.checkIfLibraryBookUniqueReferenceNumberAlreadyExists(strUniqueReferenceNumber);
	 if(returnObj.size()!=0)
	 {
		 return "false";
	 }
	 else
	 {
		 return "true";
	 }
 }
 
 public String checkIfIDCardRequestAlreadyExists(String strRollNo)
 {
	 String result = null;
	 app.idcard.ManageIDCard objManage = new ManageIDCard();
	 List<app.idcard.IDCard> returnObj = objManage.checkIfIDCardRequestAlreadyExists(strRollNo);
	 if(returnObj.size()!=0)
	 {
		 return "false";
	 }
	 else
	 {
		 return "true";
	 }
 }
 
 public String checkIfCustodianRequestAlreadyExists(String strRollNo)
 {
	 String result = null;
	 app.custodian.ManageCustodian objManage = new ManageCustodian();
	 List<app.custodian.Custodian> returnObj = objManage.checkIfCustodianRequestAlreadyExists(strRollNo);
	 if(returnObj.size()!=0)
	 {
		 return "false";
	 }
	 else
	 {
		 return "true";
	 }
 }
 
 public String checkIfIDNumberAlreadyAlloted(String strRollNo)
 {
	 String result = null;
	 app.register.ManageRegistration objManage = new ManageRegistration();
	 List<app.register.Registration> returnObj = objManage.checkIfIDNumberAlreadyAlloted(strRollNo);
 
	 if(returnObj.size()!=0)
	 {
		 return "false";
	 }
	 else
	 {
		 return "true";
	 }
	 
 }

}

