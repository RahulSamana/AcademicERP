package app.library;

import java.util.List;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import common.db.Factory;
import app.common.KeyGenerator;
import app.common.Util;
import app.register.ManageRegistration;
import app.register.Registration;
import app.login.Login;

public class ManageLibrary {
	//STATIC VARIABLES
	private static final Logger fLogger = Util.getLogger(ManageLibrary.class);
	private static SessionFactory factory;
	private static String sEntityName = "Library";

	public ManageLibrary()
	{

		factory = Factory.initiate("app.library.Library");
		
	}
	/**
	 * Method used to Insert and save data to PropertyRegistration
	 * @param propertyRegistrationObj
	 * @return String true or false
	 * @author Rahul Samana
	 * <p> Version 1.0
	 * <p>Created on Date 31 Oct, 2015.
	 */
	public String Insert(app.library.Library libraryObj) throws HibernateException
	{
	
		String key="";
		for (int i = 0; i < 100; i++)
		{
			
			String result;
			
			key = libraryObj.getsUniqueReferenceNumber();
			
			result = Factory.SELECT(factory, "sUniqueReferenceNumber", sEntityName, "sUniqueReferenceNumber = '" + key + "'");
			
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
		String result = Factory.SAVE(factory, libraryObj);
		factory.close();
		return result;
	}
	
	public List<app.library.Library> checkIfLibraryBookUniqueReferenceNumberAlreadyExists(String argUniqueReferenceNumber)
			throws HibernateException
	{
		 String strWhereCondition = "unique_reference_number='"+argUniqueReferenceNumber+"'"; 
		 List<app.library.Library> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		 factory.close();
		 return returnList;
	}
	
	public List<app.library.Library> getBooksWithReferenceNumber(String argUniqueReferenceNumber)
			throws HibernateException
	{
		 String strWhereCondition = "unique_reference_number='"+argUniqueReferenceNumber+"'"; 
		 List<app.library.Library> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		 factory.close();
		 return returnList;
	}
	
	public List<app.library.Library> getBooksWithRollNumber(String argRollNumber)
			throws HibernateException
	{
		 String strWhereCondition = "issued_to_registration_number='"+argRollNumber+"'"; 
		 List<app.library.Library> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		 factory.close();
		 return returnList;
	}
	
	public List<app.library.Library> getBooksWithBookName(String argBookName)
			throws HibernateException
	{
		 String strWhereCondition = "book_name LIKE'%"+argBookName+"%'";
		 List<app.library.Library> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		 factory.close();
		 return returnList;
	}
	
	public List<app.library.Library> getBooksWithAuthorName(String argAuthorName)
			throws HibernateException
	{
		String strWhereCondition = "author_1 LIKE'%"+argAuthorName+"%' OR author_2 LIKE '%"+argAuthorName+"%' OR author_3 LIKE '%"+argAuthorName+"%' ";
	     List<app.library.Library> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		 factory.close();
		 return returnList;
	}
    
	public String issueLibraryBookToStudent(String argBookReferenceNumber, String argStudentRollNumber,String argDateOfIssue,String argRenewalDate)
	{
		String strSetCondition = "issued_status='issued', issued_to_registration_number='"+argStudentRollNumber+"' , issued_date='"+argDateOfIssue+"' , renewal_date='"+argRenewalDate+"'";
		String strWhereCondition = "unique_reference_number='"+argBookReferenceNumber+"'";
		String result = Factory.UPDATE(factory, sEntityName, strSetCondition, strWhereCondition);
		factory.close();
		return result;
	}
	
	public String renewLibraryBookToStudent(String argBookReferenceNumber,String argRenewalDate)
	{
		String strSetCondition =  "renewal_date='"+argRenewalDate+"'";
		String strWhereCondition = "unique_reference_number='"+argBookReferenceNumber+"'";
		String result =  Factory.UPDATE(factory, sEntityName, strSetCondition, strWhereCondition);
		factory.close();
		return result;
	}
	
	public String returnLibraryBookToLibrary(String argBookReferenceNumber)
	{
		String strSetCondition = "issued_status='available', issued_to_registration_number=NULL , issued_date=NULL , renewal_date=NULL";
		String strWhereCondition = "unique_reference_number='"+argBookReferenceNumber+"'";
		String result = Factory.UPDATE(factory, sEntityName, strSetCondition, strWhereCondition);
		factory.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getLibraryBooksRelatedData() throws HibernateException
	{
		ArrayList<String> result = new ArrayList<String>();
		String strWhereCondition = "unique_reference_number is NOT NULL";
		List<Library> returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		int size_of_list = returnObj.size();
		result.add(Integer.toString(size_of_list));	
		strWhereCondition = "issued_status='issued'";
		returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
		factory.close();
		size_of_list = returnObj.size();
		result.add(Integer.toString(size_of_list));	
	    return result;    
	}

	
}
