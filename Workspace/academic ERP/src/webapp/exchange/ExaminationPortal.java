package webapp.exchange;

import java.util.ArrayList;
import java.util.List;

import app.common.KeyGenerator;
import app.examinationportal.ExaminationPortalExam;
import app.examinationportal.ExaminationPortalQuestions;
import app.examinationportal.ExaminationPortalResults;
import app.examinationportal.ManageExaminationPortalExam;
import app.examinationportal.ManageExaminationPortalQuestions;
import app.examinationportal.ManageExaminationPortalResults;


public class ExaminationPortal {
	
	public String getDepartmentofRegisteredUser(String strEmail,String strUser){
		String result = "false";
		app.examinationportal.ManageExaminationPortalExam objManage = new app.examinationportal.ManageExaminationPortalExam();
	 	result = objManage.getDepartmentofRegisteredUser(strEmail);
	 	System.gc();
		return result;
	}
	
	public ArrayList<String> getSubjects(String strDepartment,String strYear, String strSemester)
	{
		ArrayList<String> result = new ArrayList<String>();
		if(strYear.equalsIgnoreCase("1st-year") && (strSemester.equalsIgnoreCase("1st-sem") ||(strSemester.equalsIgnoreCase("2nd-sem"))))
		{
			result.add("English");
			result.add("Mathematics - I");
			result.add("Mathematics - II");
			result.add("Engineering Physics");
			result.add("Engineering Chemistry");
			result.add("Programming in C & C++");
			result.add("Engineering Mechanics");
			result.add("Engineering Graphics");
		}
		
		if(strDepartment.equalsIgnoreCase("automobile"))
		{
			if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Mathematics 3");
				result.add("Metallurgy and Material Science");
				result.add("Machine Drawing");
				result.add("Mechanics of Materials");
				result.add("Automative Electrical and Electronics");
				result.add("Managerial Economics and Accountancy");
				return result;
			}
			else if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Mathematics 4");
				result.add("Kinematics of Materials");
				result.add("Environmental Studies");
				result.add("Thermal Engineering");
				result.add("Fluid Mechanics and Machinery");
				result.add("Automotive Petrol Engines");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Automotive Diesel Engines");
				result.add("Dynamics of Machines");
				result.add("Design of Machine Elements");
				result.add("Automotive Chassis Components");
				result.add("Production Technology");
				result.add("Automotive Transmission");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Design of Automotive Components");
				result.add("Performance & Testing of Automotive Vehicles");
				result.add("Finite Element Analysis");
				result.add("Heat Transfer");
				result.add("CAD/CAM");
				result.add("Automotive Air-Conditioning");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Automotive Pollution & Control");
				result.add("Transport Management");
				result.add("Vehicle Maintenance");
				result.add("Operations Research");
				result.add("Metrology And Instrumentation");
				result.add("Elective - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Quality Control & Reliability Engineering");
				result.add("Alternative Fuels & Energy Systems for Automobiles");
				result.add("Elective - II");
				result.add("Elective - I");
				return result;
			}
		}
		else if(strDepartment.equalsIgnoreCase("civil"))
		{
			if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Mathematics 3");
				result.add("Building Drawing");
				result.add("Engineering Materials and Construction");
				result.add("Engineering Geology");
				result.add("Strength of Materials - I");
				result.add("Surveying - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Strength of Materials – II");
				result.add("Surveying - II");
				result.add("Fluid Mechanics – I ");
				result.add("Environmental Studies");
				result.add("Electrical Technology");
				result.add("Mechanical Technology");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Reinforced Cement Concrete");
				result.add("Fluid Mechanics – II");
				result.add("Theory of Structures – I");
				result.add("Building Technology and Services");
				result.add("Transportation Engineering");
				result.add("Managerial Economics & Accountancy");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Soil Mechanics");
				result.add("Steel Structures");
				result.add("Theory of Structures – II");
				result.add("Structural Engg. – Design & Detailing – I (RCC)");
				result.add("Water Resources Engg. And Management – I");
				result.add("Water & Waste Water Engineering");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Structural Engineering Design &Detailing –II(Steel)");
				result.add("Estimating and Specifications");
				result.add("Foundation Engineering");
				result.add("Water Resources Engineering And Management – II");
				result.add("Concrete Technology");
				result.add("Elective - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Construction Management And Administration");
				result.add("Disaster Mitigation And Management");
				result.add("Elective - II");
				result.add("Elective - III");
				return result;
			}
		}
		
		else if(strDepartment.equalsIgnoreCase("computer-science"))
		{
			if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Mathematics 3");
				result.add("Data Structures Using C++");
				result.add("Discrete Structures");
				result.add("Logic and Switching Theory");
				result.add("Computer Organization & Architecture");
				result.add("Basic Electronics");
				return result;
			}
			else if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Mathematics – IV");
				result.add("Object oriented Programming Using Java");
				result.add("Microprocessors and Interfacing ");
				result.add("Principles of Programming Languages");
				result.add("Electrical Circuits and Machines");
				result.add("Environmental Studies");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Database Management Systems");
				result.add("Operating Systems");
				result.add("Automata, Languages and Computation");
				result.add("Software Engineering");
				result.add("Managerial Economics and Accountancy");
				result.add("Design & Analysis of Algorithms");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Web Programming & Services");
				result.add("Compiler Construction");
				result.add("Principles of Programming Languages");
				result.add("Object Oriented System Development");
				result.add("Computer Networks");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Distributed Systems");
				result.add("Artificial Intelligence");
				result.add("Information Security");
				result.add("Principles & Applications of Embedded Systems");
				result.add("Elective - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Data Mining");
				result.add("Elective - II");
				result.add("Elective - III");
				return result;
			}
		}
		else if(strDepartment.equalsIgnoreCase("electronics-and-communication"))
		{
			if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Mathematics 3");
				result.add("Basic Circuit Analysis");
				result.add("Electromagnetic Theory");
				result.add("Electronic Devices");
				result.add("Elements of Mechanical Engineering");
				result.add("Electrical Technology");
				return result;
			}
			else if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Mathematics – IV");
				result.add("Analog Electronic Circuits");
				result.add("Network and Transmission Lines");
				result.add("Signal Analysis and Transform Techniques");
				result.add("Pulse, Digital and Switching Circuits");
				result.add("Environmental Studies");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Linear Integrated Circuits and Applications");
				result.add("Digital Integrated Circuits and Applications");
				result.add("Analog Communications");
				result.add("Automatic Control Systems");
				result.add("Microprocessors and Microcontrollers");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Digital Communications");
				result.add("Digital Signal Processing");
				result.add("Antennas and Propagation");
				result.add("Computer Organization and Architecture");
				result.add("Electronic Instrumentation");
				result.add("Managerial Economics and Accountancy");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Microwave Engineering");
				result.add("VLSI Design");
				result.add("Computer Networks");
				result.add("Mobile Cellular Communication");
				result.add("Industrial Administration and Financial Management");
				result.add("Elective - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Radar and Satellite Communication Systems");
				result.add("Elective - II");
				result.add("Elective - III");
				return result;
			}
		}
		else if(strDepartment.equalsIgnoreCase("electrical-and-electronics"))
		{
			if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Mathematics 3");
				result.add("Electrical Circuits – I");
				result.add("Environmental Studies");
				result.add("Electrical Measurements and Instruments");
				result.add("Electronic Engineering – I");
				result.add("Principles of Mechanical Engineering");
				return result;
			}
			else if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Electrical Circuits – II");
				result.add("Solid Mechanics");
				result.add("Power Systems-I	");
				result.add("Electronic Engineering – II	");
				result.add("Electromagnetic Theory");
				result.add("Electrical Machinery – I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Power Systems – I");
				result.add("Electrical Machinery – II");
				result.add("Power Electronics");
				result.add("Digital Electronics and Logic Design");
				result.add("Linear Integrated Circuits");
				result.add("Linear Control Systems");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Digital Signal Processing");
				result.add("Electrical Machinery – III");
				result.add("Switchgear and Protection");
				result.add("Microprocessors & Microcontrollers");
				result.add("Managerial Economics and Accountancy");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Power System Operation And Control");
				result.add("Electric Drives and Static Control");
				result.add("Electronic Machine Design");
				result.add("Elective - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Utilization");
				result.add("Industrial Administration & Financial Management");
				result.add("Elective - II");
				result.add("Elective - III");
				return result;
			}
		}
		else if(strDepartment.equalsIgnoreCase("information-technology"))
		{
			if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Discrete Mathematics");
				result.add("Micro Electronics");
				result.add("Digital Electronics and Logic Design");
				result.add("Data Structures");
				result.add("Electrical Circuits and Machines");
				result.add("Environmental Studies");
				return result;
			}
			else if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Probability & Random Processes");
				result.add("Signals & Systems");
				result.add("Web Technologies");
				result.add("Computer Organization & Microprocessors");
				result.add("OOPS Using JAVA");
				result.add("Data Communications");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Managerial Economics & Accountancy");
				result.add("Software Engineering");
				result.add("Digital Signal Processing");
				result.add("Database Systems");
				result.add("Operating Systems");
				result.add("Theory of Automata");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Computer Networks");
				result.add("Compiler Construction");
				result.add("Object Oriented Systems Development");
				result.add("Artificial Intelligence");
				result.add("Design & Analysis of Algorithms");
				result.add("Elective - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("VLSI");
				result.add("Middleware Technologies");
				result.add("Information Security");
				result.add("Elective - II");
				result.add("Elective - III");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Embedded Systems Design");
				result.add("Elective - IV");
				result.add("Elective - V");
				return result;
			}
		}
		else if(strDepartment.equalsIgnoreCase("mechanical"))
		{
			if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Mathematics 3");
				result.add("Metallurgy and Material Science");
				result.add("Machine Drawing");
				result.add("Mechanics of Materials");
				result.add("Environmental Studies");
				result.add("Managerial Economics and Accountancy");
				return result;
			}
			else if(strYear.equalsIgnoreCase("2nd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Mathematics – IV");
				result.add("Kinematics of Machines");
				result.add("Electrical Circuits and Machines");
				result.add("Thermo Dynamics");
				result.add("Applied Electronics");
				result.add("Fluid Dynamics");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Applied Thermodynamics");
				result.add("Dynamics of Machines");
				result.add("Design of Machine Elements");
				result.add("Hydraulic Machinery & Systems");
				result.add("Manufacturing Process");
				return result;
			}
			else if(strYear.equalsIgnoreCase("3rd-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Machine Design");
				result.add("Metal Cutting & Machine Tool Engineering");
				result.add("CAD/CAM");
				result.add("Heat Transfer");
				result.add("Control Systems");
				result.add("Refrigeration & Air Conditioning");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("1st-sem"))
			{
				result.add("Thermal Turbo Machines");
				result.add("Metrology And Instrumentation");
				result.add("Finite Element Analysis");
				result.add("Operations Research");
				result.add("Elective - I");
				return result;
			}
			else if(strYear.equalsIgnoreCase("4th-year") && strSemester.equalsIgnoreCase("2nd-sem"))
			{
				result.add("Production Drawing");
				result.add("Production And Operations Management");
				result.add("Elective - II");
				result.add("Elective - III");
				return result;
			}
		}
		return result;
	}
	public ArrayList<String> registerNewTest(ArrayList<String> fieldNames, ArrayList<String> fieldValues)
    {
   	ArrayList<String> finalresult = new ArrayList<String>();
   	app.examinationportal.ExaminationPortalExam obj = new ExaminationPortalExam();
   	for(int i=0;i<fieldNames.size();i++)
   	{
   	 if(fieldNames.get(i).equalsIgnoreCase("department"))
		 {
   		 obj.setsDepartment(fieldValues.get(i));
	     }
		 else if(fieldNames.get(i).equalsIgnoreCase("year"))
		 {
			obj.setsYear(fieldValues.get(i));
		 }
		 else if(fieldNames.get(i).equalsIgnoreCase("semester"))
		 {
			obj.setsSemester(fieldValues.get(i));
		 }
		 else if(fieldNames.get(i).equalsIgnoreCase("subject"))
		 {
			obj.setsSubject(fieldValues.get(i));
		 }
		 else if(fieldNames.get(i).equalsIgnoreCase("faculty-name"))
		 {
			obj.setsFacultyName(fieldValues.get(i));
		 }
		 else if(fieldNames.get(i).equalsIgnoreCase("faculty-registration-number"))
		 {
			 obj.setsFacultyRegistrationNumber(fieldValues.get(i));
		 }
   	}
   	String test_id =KeyGenerator.randomAlphaNumeric(10);
    obj.setsTestId(test_id);
    app.examinationportal.ManageExaminationPortalExam objManage = new ManageExaminationPortalExam();
    String result = objManage.Insert(obj);
    finalresult.add(result); 
    finalresult.add(test_id);
    System.gc();
   	return finalresult;
    }
	
	public String addQuestion( ArrayList<String> fieldNames, ArrayList<String> fieldValues)
	{
		String result ="false";
		app.examinationportal.ExaminationPortalQuestions obj = new ExaminationPortalQuestions();
	
		for(int i=0;i<fieldNames.size();i++)
	   	{
			if(fieldNames.get(i).equalsIgnoreCase("question"))
			 {
	   		 obj.setsQuestion(fieldValues.get(i));
		     }
			 else if(fieldNames.get(i).equalsIgnoreCase("option-1"))
			 {
				obj.setsOption1(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("option-2"))
			 {
				obj.setsOption2(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("option-3"))
			 {
				obj.setsOption3(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("option-4"))
			 {
				obj.setsOption4(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("right-option"))
			 {
				obj.setsRightAnswer(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("test-id"))
			 {
				obj.setsTestId(fieldValues.get(i));
			 }
	   	}
		app.examinationportal.ManageExaminationPortalQuestions objManage = new ManageExaminationPortalQuestions();
		result = objManage.Insert(obj);
		System.gc();
		return result;
	}
	public ArrayList<String> searchAvailableTests(String strSubject)
	{
		ArrayList<String> result = new ArrayList<String>();
		app.examinationportal.ManageExaminationPortalExam objManage = new ManageExaminationPortalExam();
		result = objManage.searchAvailableTests(strSubject);
		System.gc();
		return result;
	}
	public List<app.examinationportal.ExaminationPortalExam> fetchRegisteredExams(String strSubject){
		System.out.println("Subject is ::"+strSubject);
		app.examinationportal.ManageExaminationPortalExam objManage = new ManageExaminationPortalExam();
		List<app.examinationportal.ExaminationPortalExam> examsList = objManage.fetchRegisteredExams(strSubject);
		System.gc();
		return examsList;	
	}
	public List<app.examinationportal.ExaminationPortalQuestions> getExamQuestions(String strTestId) {
		app.examinationportal.ManageExaminationPortalQuestions objManage = new ManageExaminationPortalQuestions();
		List<app.examinationportal.ExaminationPortalQuestions> questionsList = objManage.fetchExamQuestions(strTestId);
		System.gc();
		return questionsList;
	}	
	public String checkIfCorrectAnswer(String strQuestionNumber, String selectedOption){
		String result = "false";
		app.examinationportal.ManageExaminationPortalQuestions objManage = new ManageExaminationPortalQuestions();
		result = objManage.checkIfCorrectAnswer(strQuestionNumber, selectedOption);
		System.gc();
		return result;
	}
	public String getNumberOfAttempts(String strTestId,String strRegistrationNumber) 
	{
		String result = "2";
		app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
		result = objManage.getNumberofAttempts(strTestId, strRegistrationNumber);
		System.gc();
		return result;
	}
	public String updateNumberofAttempts(String strTestId,String strRegistrationNumber,String strAttemptNumber) 
	{
		String result = "false";
		int number_of_attempt = Integer.parseInt(strAttemptNumber);
		app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
		result = objManage.updateNumberofAttempts(strTestId,strRegistrationNumber,number_of_attempt);
		System.gc();
		return result;
	}
	public String startTest(ArrayList<String> fieldNames, ArrayList<String> fieldValues) 
	{
		String result = "false";
		app.examinationportal.ExaminationPortalResults obj = new ExaminationPortalResults();
		for(int i=0;i<fieldNames.size();i++)
		{
			if(fieldNames.get(i).equalsIgnoreCase("test-id"))
			 {
	   		 obj.setsTestId(fieldValues.get(i));
		     }
			 else if(fieldNames.get(i).equalsIgnoreCase("registration-number"))
			 {
				obj.setsRegistrationNumber(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("subject"))
			 {
				obj.setsSubject(fieldValues.get(i));;
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("faculty-name"))
			 {
				obj.setsFacultyName(fieldValues.get(i));
			 }
			 else if(fieldNames.get(i).equalsIgnoreCase("todays-date"))
			 {
				 obj.setsTestAttemptedDate(fieldValues.get(i));
			 }
			obj.setsNumberofAttempts("1");
			
		}
		app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
		result = objManage.Insert(obj);
		System.gc();
		return result;
	}
	public String checkifEntryExists(String strTestId, String strRegistrationNumber)
	{
		String result = "true";
		app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
		result=objManage.checkifEntryExists(strTestId,strRegistrationNumber);
		System.gc();
		return result;
	}
	public String updateResult(String strMarks, String strTestId, String strRegistrationNumber)
	{
		String result = "false";
        app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
        result =  objManage.updateResult(strMarks,strTestId,strRegistrationNumber);
        System.gc();
        return result;
	}
	public List<app.examinationportal.ExaminationPortalResults> getPreviousResults(String strRegistrationNumber){
		
		app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
		List<app.examinationportal.ExaminationPortalResults> resultsList = objManage.getPreviousResults(strRegistrationNumber);
		System.gc();
		return resultsList;
	}
	public List<ExaminationPortalResults> fetchResult( String strTestId, String strRegistrationNumber)
	{
		List<ExaminationPortalResults> result;
        app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
        result =  objManage.fetchResult(strTestId,strRegistrationNumber);
        System.gc();
        return result;
	}
	public List<ExaminationPortalExam> fetchCreatedTests(String strRegistrationNumber,String strFacultyName)
	{
		List<ExaminationPortalExam> result;
        app.examinationportal.ManageExaminationPortalExam objManage = new ManageExaminationPortalExam();
        result =  objManage.fetchCreatedTests(strRegistrationNumber,strFacultyName);
        System.gc();
        return result;
	}
	public List<ExaminationPortalResults> fetchResults(String strTestId)
	{
		List<ExaminationPortalResults> result;
        app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
        result =  objManage.fetchResults(strTestId);
        System.gc();
        return result;
	}
	public String getTotalCreatedTests(String strRegistrationNumber) 
	{
		String result = "";
		app.examinationportal.ManageExaminationPortalExam objManage = new ManageExaminationPortalExam();
		result = objManage.getTotalCreatedTests(strRegistrationNumber);
		System.gc();
		return result;
	}
	public String getTotalAttemptedTests(String strRegistrationNumber) 
	{
		String result = "";
		app.examinationportal.ManageExaminationPortalResults objManage = new ManageExaminationPortalResults();
		result = objManage.getTotalAttemptedTests(strRegistrationNumber);
		System.gc();
		return result;
	}
}