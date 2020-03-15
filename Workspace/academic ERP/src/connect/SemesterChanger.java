package connect;
import javax.servlet.http.HttpServlet;

import org.apache.poi.hssf.record.chart.DatRecord;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import app.register.ManageRegistration;

public final class SemesterChanger extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5580865842425462008L;
	
	
	/** 
	 * Private Constructor to prevent object creation
	 */
	public SemesterChanger()
	{ 
	}

	
	/*
	 * Override to protect it from garbage collection
	 */
	/*
	@Override
	protected void finalize() throws Throwable 
	{
	}
	*/
	
	
	/**
	 * Static Block for Semester Changer 
	 */
	static 
	{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        String todays_date = dateFormat.format(calendar.getTime());
        Date date_today = new Date(todays_date);
        Date date = new Date();
        int year = date.getYear() + 1900;
        try
        {
        	 Date compare_date_sem_1_part1 = dateFormat.parse(""+year+"/06/01"); 
        	 Date compare_date_sem_1_part2 = dateFormat.parse(""+year+"/11/31");
        	 Date compare_date_sem_2_part1 = dateFormat.parse(""+year+"/00/01");
        	 Date compare_date_sem_2_part2 = dateFormat.parse(""+year+"/05/31");
      	 
        	 
        	 if((date_today.compareTo(compare_date_sem_1_part1)>=1 || date_today.compareTo(compare_date_sem_1_part1) ==0 )  && (date_today.compareTo(compare_date_sem_1_part2)<=0 || date_today.compareTo(compare_date_sem_1_part2)==0  ))
        	 {
        		app.register.ManageRegistration objManage = new ManageRegistration();
        		objManage.changeFrom2ndSemto1stSem();			 
        	 }

        	 if((date_today.compareTo(compare_date_sem_2_part1)>=1 || date_today.compareTo(compare_date_sem_2_part1) ==0 )  && (date_today.compareTo(compare_date_sem_2_part2)<=0 || date_today.compareTo(compare_date_sem_2_part2)==0  ))
        	 {
        		app.register.ManageRegistration objManage = new ManageRegistration();
        		objManage.changeFrom1stSemto2ndSem();
        	 }
        	 
        	 
        	 
        }catch(ParseException e)
        {
        	System.out.println("Error in Parsing ::"+e);
        }
       
		
	} // ends Semester Changer


}