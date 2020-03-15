package app.register;

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
import app.register.Registration;


public class ManageRegistration {
	//STATIC VARIABLES
			private static final Logger fLogger = Util.getLogger(ManageRegistration.class);
			private static SessionFactory factory;
			private static String sEntityName = "Registration";

			public ManageRegistration()
			{

				factory = Factory.initiate("app.register.Registration");
				
			}
			/**
			 * Method used to Insert and save data to PropertyRegistration
			 * @param propertyRegistrationObj
			 * @return String true or false
			 * @author Rahul Samana
			 * <p> Version 1.0
			 * <p>Created on Date 31 Oct, 2015.
			 */
			public String Insert(app.register.Registration registrationObj) throws HibernateException
			{
			
				String key="";
				for (int i = 0; i < 100; i++)
				{
					
					String result;
					
					key = registrationObj.getsUniqueReferenceNumber();
					
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
				String result = Factory.SAVE(factory, registrationObj);
				factory.close();
				return result;
			}
			
			@SuppressWarnings("unchecked")
			public int getLastInsertedIDNumber(String argUser,String argSubCourseName,String argAcademicYearStart)
			{
				System.out.println(argUser);
				System.out.println(argSubCourseName);
				System.out.println(argAcademicYearStart);
				int max_count = 0;
				String strWhereCondition = "sub_course_name='"+argSubCourseName+"' AND academic_year_start='"+argAcademicYearStart+"' AND candidate_type='"+argUser+"'";
				List<app.register.Registration> returnObj =null;
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				max_count = returnObj.size();
			    return max_count++;
				
			}
			@SuppressWarnings("unchecked")
			public List<app.register.Registration> getAllExistingAdmissions( String argCandidateType, String argCourseName, String argSubCourseName, String argYear ) throws HibernateException
			{

				String strWhereCondition =null;
				if(argCandidateType.equalsIgnoreCase("Others"))
				{
					strWhereCondition = "candidate_type='"+argCandidateType+"'";
				}
				else if(argYear.isEmpty())
				{
					strWhereCondition = "candidate_type='"+argCandidateType+"' AND course_name ='"+argCourseName+"' AND sub_course_name = '"+argSubCourseName+"'";
				}
				else 
				{
					strWhereCondition = "candidate_type='"+argCandidateType+"' AND course_name ='"+argCourseName+"' AND sub_course_name = '"+argSubCourseName+"' AND academic_year = '"+argYear+"'";	
				}
				
				List<app.register.Registration> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			    factory.close();
				return returnList;
			}
			@SuppressWarnings("unchecked")
			public List<app.register.Registration> getAllExistingAdmissions( String argRegistrationNumber ) throws HibernateException
			{
				String strWhereCondition = "registration_number LIKE'%"+argRegistrationNumber+"%'";
				List<app.register.Registration> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				return returnList;
			}
			
			
			public boolean deleteExistingAdmission( String argUniqueReferenceNumber )
					throws HibernateException
			{
				boolean result = Factory.DELETEFOREVER(factory, sEntityName, "sUniqueReferenceNumber", argUniqueReferenceNumber); 
			    factory.close();
				return result;
			}
			@SuppressWarnings("unchecked")
			public List<Registration> checkIfAlreadyExists(String argVerificationColumn,String argVerificationID)
					throws HibernateException
			{
				String strWhereCondition =null;
			 if(argVerificationColumn.equalsIgnoreCase("email"))
			 {
				 strWhereCondition = "email_address='"+argVerificationID+"'"; 
			 }
			 else if(argVerificationColumn.equalsIgnoreCase("mobile"))
			 {
				 strWhereCondition = "mobile_number='"+argVerificationID+"'";
			 }
			 List<Registration>  returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition); 
  			 factory.close();
			 return returnList;
				
			}
			public String allotRollNumber(String argRegistrationNumber, String argUniqueReferenceNumber )
					throws HibernateException
			{
				String result = Factory.UPDATE(factory, sEntityName, "sRegistrationNumber", argRegistrationNumber, "sUniqueReferenceNumber", argUniqueReferenceNumber); 
				factory.close();
				return result; 
  			}
			
			public String changeAllotedRollNumber(String argRegistrationNumber, String argUniqueReferenceNumber )
					throws HibernateException
			{
				String result = Factory.UPDATE(factory, sEntityName, "sRegistrationNumber", argRegistrationNumber, "sUniqueReferenceNumber", argUniqueReferenceNumber); 
				factory.close();
				return result;
  			}
			
			public String updateFeePaymentStatus(String argUniqueReferenceNumber, String argFeePaymentStatus )
					throws HibernateException
			{
				String result = Factory.UPDATE(factory, sEntityName, "sFeePaymentStatus", argFeePaymentStatus, "sUniqueReferenceNumber", argUniqueReferenceNumber);
				factory.close();
				return result;
  			}
			
			@SuppressWarnings("unchecked")
			public List<Registration> getRegisteredDetailsWithUniqueID( String argUniqueReferenceID ) throws HibernateException
			{
				List<Registration> returnList =  Factory.GETWHERE(factory, sEntityName,"unique_reference_number", "=", argUniqueReferenceID);
				factory.close();
				return returnList;
			
			}
			@SuppressWarnings("unchecked")
			public List<Registration> getRegisteredStudentDetailsWithRegistrationNumber( String argRegistrationNumber ) throws HibernateException
			{
				List<Registration> returnList = Factory.GETWHERE(factory, sEntityName,"registration_number", "=", argRegistrationNumber); 
				factory.close();
				return returnList;
			
			}
			@SuppressWarnings("unchecked")
			public List<Registration> getRegisteredDetailsWithEmailID( String argEmailID ) throws HibernateException
			{
				List<Registration> returnList = Factory.GETWHERE(factory, sEntityName,"email_address", "=", argEmailID); 
				factory.close();
				return returnList; 
			
			}
			@SuppressWarnings("unchecked")
			public List<Registration> getRegisteredDetailsWithMobile( String argMobileNumber ) throws HibernateException
			{
				List<Registration> returnList = Factory.GETWHERE(factory, sEntityName,"mobile_number", "=", argMobileNumber); 
				factory.close();
				return returnList; 
			
			}
			@SuppressWarnings("unchecked")
			public String getNumberofStudentsWithFeePaid(String argCandidateType) throws HibernateException
			{
				String strWhereCondition = "candidate_type='"+argCandidateType+"' AND fee_payment_status='payment-completed'";
				List<Registration> returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			    factory.close();
				int size_of_list = returnObj.size();
			    String result = Integer.toString(size_of_list);
			    return result;    
			}
			@SuppressWarnings("unchecked")
			public String getNumberofStudentsWithFeePending(String argCandidateType) throws HibernateException
			{
				String strWhereCondition = "candidate_type='"+argCandidateType+"' AND fee_payment_status='payment-pending'";
				List<Registration> returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
			    factory.close();
				int size_of_list = returnObj.size();
			    String result = Integer.toString(size_of_list);
			    return result;    
			}
			@SuppressWarnings("unchecked")
			public ArrayList<String> getStudentDetailsFeeRelated(String argCandidateType,String argCourseName, String argSubCourseName, String argYear) throws HibernateException
			{
				
				String strWhereCondition =null;
			   
					strWhereCondition = "candidate_type='"+argCandidateType+"' AND course_name ='"+argCourseName+"' AND sub_course_name = '"+argSubCourseName+"' AND academic_year = '"+argYear+"'";	
				
				
				ArrayList<String> result = new ArrayList<String>();				
				List<Registration> returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				int size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
				String strWhereCondition1 = strWhereCondition+ " AND fee_payment_status_"+argYear+"_year='payment-completed'";
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition1);
				size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
				String strWhereCondition2 = strWhereCondition+ "AND fee_payment_status_"+argYear+"_year='payment-pending'";
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition2);
				factory.close();
				size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
			    return result;    
			}
			
			@SuppressWarnings("unchecked")
			public ArrayList<String> getStudentDetailsFeeRelated(String argCandidateType) throws HibernateException
			{
				ArrayList<String> result = new ArrayList<String>();
				String strWhereCondition = "candidate_type='"+argCandidateType+"'";
				List<Registration> returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				int size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
				strWhereCondition = "candidate_type='"+argCandidateType+"' AND registration_number is not null";
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
				strWhereCondition = "candidate_type='"+argCandidateType+"' AND registration_number is null";
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
			    return result;    
			}

			@SuppressWarnings("unchecked")
			public List<Registration> getAllEmployees( String argDesignation ) throws HibernateException
			{
				List<Registration> returnList =  Factory.GETWHERE(factory, sEntityName,"designation", "=", argDesignation);
				factory.close();
				return returnList;
			
			}
			
			public String scheduler() throws HibernateException
			{
				String result = Factory.UPDATE(factory, sEntityName, "salary_credited_status", "not-credited", "salary_credited_status", "credited"); 
				factory.close();
				return result;
			}
			
			public String getEmailFromUniqueReferenceNumber(String strUniqueReferenceID)
			{
				String result = null;
				String strWhereCondition = "unique_reference_number='"+strUniqueReferenceID+"'";
			    List<Registration> returnObj = Factory.GETWHERE(factory,sEntityName, strWhereCondition);
			    factory.close();
			    for(int i=0;i<returnObj.size();i++)
			    {
			    	app.register.Registration eachObj = returnObj.get(i);
			    	result = eachObj.getsEmailAddress();
			    	break;
			    }
			    return result;
			}
			
			@SuppressWarnings("unchecked")
			public ArrayList<String> getEmployeeDetailsSalaryRelated(String argCandidateType1,String argCandidateType2,String argCandidateType3) throws HibernateException
			{
				ArrayList<String> result = new ArrayList<String>();
				String strWhereCondition = "candidate_type='"+argCandidateType1+"' OR candidate_type='"+argCandidateType2+"' OR candidate_type='"+argCandidateType3+"'";
				List<Registration> returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				int size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
				strWhereCondition = "(candidate_type='"+argCandidateType1+"' OR candidate_type='"+argCandidateType2+"' OR candidate_type='"+argCandidateType3+"') AND salary_credited_status='credited'";
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
				strWhereCondition = "(candidate_type='"+argCandidateType1+"' OR candidate_type='"+argCandidateType2+"' OR candidate_type='"+argCandidateType3+"') AND salary_credited_status='not-credited'";
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				size_of_list = returnObj.size();
				result.add(Integer.toString(size_of_list));	
			    return result;    
			}
			
			public ArrayList<String> getDetailsForIDCard(String strEmail)
			{
				factory.close();
				ArrayList<String> result = new ArrayList<String>();
					app.register.ManageRegistration objManage= new ManageRegistration();
			        List<Registration> returnObj = null;
					returnObj = objManage.getRegisteredDetailsWithEmailID(strEmail);
					for(int i=0;i<returnObj.size();i++){
					 app.register.Registration eachObj = returnObj.get(i);
					 result.add(eachObj.getsSubCourseName());
					 result.add(eachObj.getsRegistrationNumber());
					 result.add(eachObj.getsFullName());
					 result.add(eachObj.getsMobileNumber());
					 result.add(eachObj.getsDateOfBirth());
					 result.add(eachObj.getsPermanentAddress());
					}
					factory.close();
					return result;
				
			}
			
			public ArrayList<String> getDetailsForCustodian(String strEmail)
			{
				factory.close();
				ArrayList<String> result = new ArrayList<String>();
					app.register.ManageRegistration objManage= new ManageRegistration();
			        List<Registration> returnObj = null;
					returnObj = objManage.getRegisteredDetailsWithEmailID(strEmail);
					for(int i=0;i<returnObj.size();i++){
					 app.register.Registration eachObj = returnObj.get(i);
					 result.add(eachObj.getsFullName());
					 result.add(eachObj.getsFatherFullName());
					 result.add(eachObj.getsRegistrationNumber());
					 result.add(eachObj.getsDateOfBirth());
					 result.add(eachObj.getsCourseName());
					 result.add(eachObj.getsSubCourseName());
					 result.add(eachObj.getsSubCourseName());
					}
					factory.close();
					return result;
				
			}
			
			public List<Registration> getStudentDetailsStudentPortalRequestRelated(String strEmail)
			{
				
				String strWhereCondition = "email_address='"+strEmail+"'";
				List<Registration> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				return returnList;
				
			}
			
			public List<Registration> getDetailsForPermissionRequest(String strDepartment)
			{
				
				String strWhereCondition = "sub_course_name='"+strDepartment+"' AND (candidate_type='tutor' AND designation!='Head of the Department')";
				List<Registration> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				return returnList;
			}

			
			public String getDepartmentofRegisteredUser(String argEmail)
			{
				String result = null;
				String strWhereCondition = "email_address='"+argEmail+"'";
				List<Registration> returnObj = Factory.GETWHERE(factory,sEntityName, strWhereCondition);
			    factory.close();
				for(int i=0;i<returnObj.size();i++)
			    {
			    	app.register.Registration eachObj = returnObj.get(i);
			    	result = eachObj.getsSubCourseName();
			    	break;
			    }
			    return result;
			}
			
			public String getRegistrationNumber(String argEmail)
			{
				String result = null;
				String strWhereCondition = "email_address='"+argEmail+"'";
				List<Registration> returnObj = Factory.GETWHERE(factory,sEntityName, strWhereCondition);
			    factory.close();
				for(int i=0;i<returnObj.size();i++)
			    {
			    	app.register.Registration eachObj = returnObj.get(i);
			    	result = eachObj.getsRegistrationNumber();
			    	break;
			    }
			    return result;
			}
			public String getRegisteredFullName(String argEmail)
			{
				String result = null;
				String strWhereCondition = "email_address='"+argEmail+"'";
				List<Registration> returnObj = Factory.GETWHERE(factory,sEntityName, strWhereCondition);
			    factory.close();
				for(int i=0;i<returnObj.size();i++)
			    {
			    	app.register.Registration eachObj = returnObj.get(i);
			    	result = eachObj.getsFullName();
			    	break;
			    }
			    return result;
			}
			
			public String getHODEmail(String argDepartment)
			{
				String result = null;
				String strWhereCondition = "sub_course_name='"+argDepartment+"' AND designation='Head of the Department'";
				List<Registration> returnObj = Factory.GETWHERE(factory,sEntityName, strWhereCondition);
			    factory.close();
				for(int i=0;i<returnObj.size();i++)
			    {
			    	app.register.Registration eachObj = returnObj.get(i);
			    	result = eachObj.getsEmailAddress();
			    	break;
			    }
			    return result;
			}
			
			public String getUniqueIDUsingEmail(String argEmail)
			{
				String result = null;
				String strWhereCondition = "email_address='"+argEmail+"'";
				List<Registration> returnObj = Factory.GETWHERE(factory,sEntityName, strWhereCondition);
			    factory.close();
				for(int i=0;i<returnObj.size();i++)
			    {
			    	app.register.Registration eachObj = returnObj.get(i);
			    	result = eachObj.getsUniqueReferenceNumber();
			    	break;
			    }
			    return result;
			}
			public String getUniqueIDUsingRollNo(String argRollNo)
			{
				String result = null;
				String strWhereCondition = "registration_number='"+argRollNo+"'";
				List<Registration> returnObj = Factory.GETWHERE(factory,sEntityName, strWhereCondition);
			    factory.close();
				for(int i=0;i<returnObj.size();i++)
			    {
			    	app.register.Registration eachObj = returnObj.get(i);
			    	result = eachObj.getsUniqueReferenceNumber();
			    	break;
			    }
			    return result;
			}
			
			
			
			public ArrayList<String> getRegisteredTutorDetailsNamesWithDepartment(String strDepartment)
			{
				ArrayList<String> tutorNamesList =  new ArrayList<String>();
				String strWhereCondition = "sub_course_name='"+strDepartment+"' AND candidate_type='tutor'";
				List<Registration> facultyList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				for(int i=0;i<facultyList.size();i++)
				{
					Registration eachObj = facultyList.get(i);
					tutorNamesList.add(eachObj.getsFullName());
				}
				return tutorNamesList;
			}
			public List<Registration> getAllStudentEmailIdsWithAcademicYear(String department, String strAcademicYear)
			{
					String strWhereCondition = "sub_course_name ='"+department+"' AND academic_year ='"+strAcademicYear+"' AND candidate_type='Student'";
					List<Registration> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition); 
					factory.close();
					return returnList;
			}
			public List<app.register.Registration> checkIfIDNumberAlreadyAlloted(String argRollNo)
					throws HibernateException
			{
				 String strWhereCondition = "registration_number='"+argRollNo+"'"; 
				 List<app.register.Registration> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition); 
				 factory.close();
				 return returnList;
			}
			public String removeAllotedRollNumber( String argUniqueReferenceNumber )
					throws HibernateException
			{
				String result = null;
				try
				{
					String strSetStatement = "registration_number=null";
					String strWhereCondition = "unique_reference_number = '"+argUniqueReferenceNumber+"'";
					 result = Factory.UPDATE(factory, sEntityName, strSetStatement, strWhereCondition);
					 
				}catch(Exception e)
				{
					System.out.println("Exception in Main Package :: "+e);
				}
				 
				factory.close();
				return result;
			}
			
            public String changeFrom2ndSemto1stSem()
            {
            	String result;
            	String strWhereCondition = "academic_semester='2nd-Sem'";
            	String strSetStatement = "academic_semester='1st-Sem' , semester_change_count=semester_change_count+1";
                String result_1 = Factory.UPDATE(factory, sEntityName, strSetStatement, strWhereCondition);
                strWhereCondition = "semester_change_count = 2";
                strSetStatement = "academic_year = academic_year+1 , semester_change_count = 0";
               
                String result_2 =  Factory.UPDATE(factory, sEntityName, strSetStatement, strWhereCondition);
                
                
                strWhereCondition ="course_name='B.E-B.Tech' AND academic_year>4";
                strSetStatement = "academic_year = '4',academic_semester='2nd-Sem'";
                String result_3 =  Factory.UPDATE(factory, sEntityName, strSetStatement, strWhereCondition);
               
                strWhereCondition ="course_name='M.E-M.Tech' AND academic_year>2";
                strSetStatement = "academic_year = '2' , academic_semester='2nd-Sem'";
                String result_4 =  Factory.UPDATE(factory, sEntityName, strSetStatement, strWhereCondition);
                factory.close();
                
                if(result_1=="true" && result_2 =="true")
                {
                	result="true";
                }
                else
                {
                	result="false";
                }
                return result;
            }
            
            public String changeFrom1stSemto2ndSem()
            {
            	String result;
            	String strWhereCondition = "academic_semester='1st-Sem'";
            	String strSetStatement = "academic_semester='2nd-Sem' , semester_change_count=semester_change_count+1";
                result = Factory.UPDATE(factory, sEntityName, strSetStatement, strWhereCondition);
                factory.close();
                return result;
            }
            public List<Registration> getDetailsWithUniqueReferenceNumber(String argUniqueReferenceNumber)
        	{
            	 String strWhereCondition = "unique_reference_number='"+argUniqueReferenceNumber+"'"; 
            	 List<Registration> returnList = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
            	 factory.close();
            	 return returnList;
        	}
            public String updateFeePaymentStatus(String argUniqueReferenceNumber, ArrayList<String> fieldNames, ArrayList<String> fieldValues)
            {
           
            	String result ="false";
            	String strWhereCondition = "unique_reference_number='"+argUniqueReferenceNumber+"'";
            	String strSetStatement = "";
            	for(int i=0;i<fieldNames.size();i++)
        		{
        			if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-1"))
        			{
        				strSetStatement += "fee_payment_status_1_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-2"))
        			{
        				strSetStatement += "fee_payment_status_2_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-3"))
        			{
        				strSetStatement += "fee_payment_status_3_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-4"))
        			{
        				strSetStatement += "fee_payment_status_4_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-5"))
        			{
        				strSetStatement += "fee_payment_status_5_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-6"))
        			{
        				strSetStatement += "fee_payment_status_6_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-7"))
        			{
        				strSetStatement += "fee_payment_status_7_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-8"))
        			{
        				strSetStatement += "fee_payment_status_8_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-9"))
        			{
        				strSetStatement += "fee_payment_status_9_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-10"))
        			{
        				strSetStatement += "fee_payment_status_10_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-11"))
        			{
        				strSetStatement += "fee_payment_status_11_year = '"+fieldValues.get(i)+"',";
        			}
        			else if(fieldNames.get(i).equalsIgnoreCase("fee-payment-status-12"))
        			{
        				strSetStatement += "fee_payment_status_12_year = '"+fieldValues.get(i)+"'";
        			}
        		
        		}
        		
                result = Factory.UPDATE(factory, sEntityName, strSetStatement, strWhereCondition);
                factory.close();
                return result;
            }
}

        

        