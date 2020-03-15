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

public class ManageExaminationPortalQuestions {

	//STATIC VARIABLES
			private static final Logger fLogger = Util.getLogger(ManageLogin.class);
			private static SessionFactory factory;
			private static String sEntityName = "ExaminationPortalQuestions";

			public ManageExaminationPortalQuestions()
			{

				factory = Factory.initiate("app.examinationportal.ExaminationPortalQuestions");
				
			}
			
			public String Insert(app.examinationportal.ExaminationPortalQuestions objExaminationPortalQuestions) throws HibernateException
			{
			
				String key="";
				for (int i = 0; i < 100; i++)
				{
					
					String result;
					
					key = objExaminationPortalQuestions.getsTestId();
					result = Factory.SELECT(factory, "sQuestionNumber", sEntityName, "sQuestionNumber = '" + key + "'");
					
					if(result.length()<=2)
					{
						break;
					}
					else
					{
						continue;
					}

				}
				String result = Factory.SAVE(factory, objExaminationPortalQuestions);
				factory.close();
				return result;
			}
    public List<app.examinationportal.ExaminationPortalQuestions> fetchExamQuestions(String strTestId)
		{	
    	    List<app.examinationportal.ExaminationPortalQuestions> returnList = Factory.GETWHERERAND(factory, "ExaminationPortalQuestions", "test_id", "=", strTestId);
			factory.close();
    	    return returnList; 
		}
	public String checkIfCorrectAnswer(String strQuestionNumber, String selectedOption){
				factory.close();
		        String result = "false";
				app.examinationportal.ManageExaminationPortalQuestions objManage = new ManageExaminationPortalQuestions();
				List<ExaminationPortalQuestions> returnObj = null;
				String strWhereCondition = "question_number='"+strQuestionNumber+"'";
				returnObj = Factory.GETWHERE(factory, sEntityName, strWhereCondition);
				factory.close();
				for(int i=0;i<returnObj.size();i++){
					 app.examinationportal.ExaminationPortalQuestions eachObj = returnObj.get(i);
					 String right_option = eachObj.getsRightAnswer();
					 if(right_option.equalsIgnoreCase(selectedOption))
					 {
						 result = "true";
						 return result;
					 }
					}
				 
				return result;
			}
	
}
