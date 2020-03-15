package common.db;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.common.Util;;


public class Factory 
{
	
	//PRIVATE STATIC VARIABLES
	private static SessionFactory factory;
	private static final Logger fLogger = Util.getLogger(Factory.class);
	
	public static SessionFactory initiate(String className)
	{
		
	      try
	      {
	    	  
	    	  Class<?> cls = Class.forName(className);
	    	  
	          factory = new Configuration().configure().
	        		  				addAnnotatedClass(cls).buildSessionFactory();
	      }
	      catch (Throwable ex) 
	      {
	    	  
	    	  fLogger.logp(Level.SEVERE, "Factory", "initiate", " :: ", ex);
	          throw new ExceptionInInitializerError(ex);
	          
	       }
	      
		return factory;
		
	}
	
	public static String SAVE(SessionFactory factory, Object objToSave)
	{
		
		Transaction tx = null;
	    String result = null;
	    Session session = null;
	      try
	      {
	    	  
	    	  //factory = Factory.initiate(sInitiateWith);
	    	  session = factory.openSession();
	          tx = session.beginTransaction();
	          result =  (String) session.save(objToSave);
	          tx.commit();
	          
	      }
	      catch (HibernateException e) 
	      {
	    	  fLogger.logp(Level.SEVERE, "Factory", "SAVE", " ::HibernateException e:: ", e);
	    	  
	          if(tx!=null)
	          {
	        	  
	        	  tx.rollback();
	        	  fLogger.info("Save transaction rolledback. Data not saved.");
	        	  
	          }
	           
	          result = "false";
	          
	          throw new HibernateException(e);
	          
	      }
	      catch (Exception e) {

	    	  fLogger.logp(Level.SEVERE, "Factory", "SAVE", " ::Excpetion e:: ", e);
	    	  
	    	  
		}
	      
	      finally 
	      {
	    	  
	          session.close();
	           
	          System.gc();
	          
	      }	
        result="true";
		return result;
	}
	
	
	/**
	 * Overloaded. Delete data from table with certain condition
	 * @param factory session factory
	 * @param argEntityName Name of Entity class
	 * @param argWhereKey Entity Key
	 * @param argWhereValue String value
	 * @return boolean true if deleted.
	 */
	public static boolean DELETE(SessionFactory factory, String argEntityName, String argWhereKey, String argWhereValue)
	{
		
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			//factory = Factory.initiate("app.test.DatabaseTest");
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "UPDATE "+argEntityName + " set isDeleted = 1 WHERE " + argWhereKey + " = '"+argWhereValue+"'";
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			fLogger.logp(Level.SEVERE, "Factory", "DELETE", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "DELETE", " ::Excpetion e:: ", e.getMessage());
		}
		finally 
		{
			session.close(); 
			 
			System.gc();
		}

		if(result==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	
	
	/**
	 * Overloaded. Delete data from table with certain condition
	 * @param factory session factory
	 * @param argTableName Name of Entity class
	 * @param argWhereKey Entity Key
	 * @param argWhereValue int value
	 * @return boolean true if deleted.
	 */
	public static boolean DELETE(SessionFactory factory, String argTableName, String argWhereKey, int argWhereValue)
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "UPDATE "+argTableName + " set isDeleted = 1 WHERE " + argWhereKey + " = "+argWhereValue;
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			
			tx.commit();

		}
		catch (HibernateException e) 
		{
			fLogger.logp(Level.SEVERE, "Factory", "DELETE", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "DELETE", " ::Excpetion e:: ", e.getMessage());
		}
		finally 
		{
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	
	/**
	 * Deletes record permanently without any backup
	 * @param factory session factory
	 * @param argTableName Entity table name
	 * @param argWhereKey Entity key
	 * @param argWhereValue int value
	 * @return boolean true if deleted
	 * @throws HibernateException
	 */
	public static boolean DELETEFOREVER(SessionFactory factory, String argTableName, String argWhereKey, int argWhereValue) throws HibernateException
	{
		
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "DELETE from "+argTableName + " WHERE " + argWhereKey + " = "+argWhereValue;
			
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			
			tx.commit();

		}
		catch (HibernateException e) 
	    {
	    	  
			fLogger.logp(Level.SEVERE, "Factory", "DELETEFOREVER", " :: ", e);
	    	  
			if(tx!=null)
	        {
	        	  
				tx.rollback();
	        	fLogger.info("DELETEFOREVER transaction rolledback. Data not deleted.");
	        	  
	        }
	          
	        throw new HibernateException(e);          
	    }
	    finally 
	    {
	    	session.close();
	    	  
	    	 System.gc();
	    	
	    }
		if(result==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	/**
	 * Deletes record permanently without any backup
	 * @param factory session factory
	 * @param argTableName Entity table name
	 * @param argWhereKey Entity key
	 * @param argWhereValue String value
	 * @return boolean true if deleted
	 * @throws HibernateException
	 */
	public static boolean DELETEFOREVER(SessionFactory factory, String argTableName, String argWhereKey, String argWhereValue) throws HibernateException
	{
		
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "DELETE from "+argTableName + " WHERE " + argWhereKey + " = '"+argWhereValue+"'";
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			
			tx.commit();

		}
		catch (HibernateException e) 
	    {
	    	  
			fLogger.logp(Level.SEVERE, "Factory", "DELETEFOREVER", " :: ", e);
	    	  
			if(tx!=null)
	        {
	        	  
				tx.rollback();
	        	fLogger.info("DELETEFOREVER transaction rolledback. Data not deleted.");
	        	  
	        }
	          
	        throw new HibernateException(e);          
	    }
	    finally 
	    {
	    	session.close();
	    	  
	    	 System.gc();
	    }
		
		if(result==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * List all data from argFromTable
	 * @param argFromTable Entity table
	 * @return
	 */
	public static List listAll(SessionFactory factory, String argFromTable)
	{
	
		Session session = null;
		Transaction tx = null;
		List lObjectList = null;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			lObjectList = session.createQuery("FROM "+argFromTable).list();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			fLogger.logp(Level.SEVERE, "Factory", "listAll", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}
		
		return lObjectList;
	}
	

	
	/**
	 * Overloaded. List Data Where selected data from table
	 * @param factory session factory
	 * @param argFromTable Entity table name
	 * @param argWhereCondition where condition with value 
	 * @return List of Object
	 */
	public static List GETWHERE(SessionFactory factory, String argFromTable, String argWhereCondition)
	{
		
		Session session = null;
		Transaction tx = null;
		List lObjectList = null;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction(); 
			
			String hqlQuery = "FROM "+argFromTable + " WHERE "+argWhereCondition ;
			Query query = session.createQuery(hqlQuery);
			lObjectList = query.list();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::Excpetion e:: ", e.getMessage());
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}
		
		return lObjectList;
	}

	/**
	 * Overloaded. List Data Where selected data from table
	 * @param factory session factory
	 * @param argFromTable Entity table name
	 * @param argWhereCondition where condition with value 
	 * @return List of Object
	 */
	public static List GETWHEREORDERBYCOLUMN(SessionFactory factory, String argFromTable, String argWhereCondition, String argOrderByColumn)
	{
		
		Session session = null;
		Transaction tx = null;
		List lObjectList = null;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction(); 
			
			String hqlQuery = "FROM "+argFromTable + " WHERE "+argWhereCondition + " ORDER BY " +argOrderByColumn ;
			Query query = session.createQuery(hqlQuery);
			
			lObjectList = query.list();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::Excpetion e:: ", e.getMessage());
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}
		
		return lObjectList;
	}
	
	
	/**
	 * Overloaded. List Data Where selected data from table
	 * @param factory session factory
	 * @param argFromTable Entity table name
	 * @param argWhereKey where condition key 
	 * @param argCondition if some other condition
	 * @param argFromRange string start range
	 * @param argRangeCondition binary condition between range
	 * @param argToRange string end range
	 * @return List of Object
	 */
	public static List GETWHERE(SessionFactory factory, String argFromTable, String argWhereKey, String argFromCondition, String argFromRange, String argRangeCondition, String argToCondition, String argToRange)
	{
		
		Session session = null;
		Transaction tx = null;
		List lObjectList = null;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction(); 
			
			String hqlQuery = "FROM "+argFromTable + " WHERE "+argWhereKey +" "+argFromCondition+" '" + argFromRange + "' " 
										+ argRangeCondition + " " + argWhereKey +" "+argToCondition+" '" + argToRange+ "' ";
			Query query = session.createQuery(hqlQuery);
			
			lObjectList = query.list();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::Excpetion e:: ", e.getMessage());
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}
		
		return lObjectList;
	}

	
	
	/**
	 * Overloaded. List Data Where selected data from table
	 * @param factory session factory
	 * @param argFromTable Entity table name
	 * @param argWhereKey where condition key 
	 * @param argCondition if some other condition
	 * @param argKeyValue string value for key
	 * @return List of Object
	 */
	public static List GETWHERE(SessionFactory factory, String argFromTable, String argWhereKey, String argCondition, String argKeyValue)
	{
		
		Session session = null;
		Transaction tx = null;
		List lObjectList = null;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction(); 
			
			String hqlQuery = "FROM "+argFromTable + " WHERE "+argWhereKey +" "+argCondition+" '"+argKeyValue+"'";
			Query query = session.createQuery(hqlQuery);
			
			lObjectList = query.list();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::Excpetion e:: ", e.getMessage());
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}
		
		return lObjectList;
	}

	public static List GETWHERERAND(SessionFactory factory, String argFromTable, String argWhereKey, String argCondition, String argKeyValue)
	{
		
		Session session = null;
		Transaction tx = null;
		List lObjectList = null;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction(); 
			
			String hqlQuery = "FROM "+argFromTable + " WHERE "+argWhereKey +" "+argCondition+" '"+argKeyValue+"' ORDER BY RAND()";
			Query query = session.createQuery(hqlQuery);
			query.setMaxResults(10);
			lObjectList = query.list();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::Excpetion e:: ", e.getMessage());
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}
		
		return lObjectList;
	}
	
	
	
	/**
	 * Overloaded. List Data Where selected data from table
	 * @param factory session factory
	 * @param argFromTable Entity table name
	 * @param argWhereKey where condition key 
	 * @param argCondition if some other condition
	 * @param argKeyValue string value for key
	 * @return List of Object
	 */
	public static List GETWHERE(SessionFactory factory, String argFromTable, String argWhereKey, String argCondition, long argKeyValue)
	{
	
		Session session = null;
		Transaction tx = null;
		List lObjectList = null;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "FROM "+argFromTable + " WHERE "+argWhereKey +" "+argCondition+" "+argKeyValue;
			Query query = session.createQuery(hqlQuery);
			lObjectList = query.list();
			 
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "GETWHERE", " ::Excpetion e:: ", e.getMessage());
			
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}
		
		return lObjectList;
	}
	
	
	/**
	 * Overloaded. Update table cell with given value
	 * @param factory Session factory
	 * @param argTableName Entity Name to update
	 * @param argSetKey Key for which you want to set value 
	 * @param argSetValue String value which you want to set
	 * @param argWhereKey key for where condition
	 * @param argWhereValue String value where to set
	 * @return true if updated. False if not updated
	 */
	public static String UPDATE(SessionFactory factory, String argTableName, String argSetKey, String argSetValue, String argWhereKey, String argWhereValue) 
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetKey +" = '"+argSetValue+"'"
					 			+ " WHERE " + argWhereKey + " = '"+argWhereValue+"'";
			System.out.println("Query is "+hqlQuery);
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally 
		{
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return "false";
		}
		else
		{
			return "true";
		}
		
	}
	
	/**
	 * Overloaded. Update table with given statements
	 * @param factory
	 * @param argTableName
	 * @param argSetStatement
	 * @param argWhereStatement
	 * @return
	 */
	
	public static String UPDATE(SessionFactory factory, String argTableName, String argSetStatement, String argWhereStatement) 
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetStatement+" WHERE " + argWhereStatement;
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally 
		{
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return "false";
		}
		else
		{
			return "true";
		}
		
	}
	
	
	/**
	 * Overloaded. Update table cell with given value with two where conditions(AND)
	  * @param factory Session factory
	 * @param argTableName Entity Name to update
	 * @param argSetKey Key for which you want to set value 
	 * @param argSetValue String value which you want to set
	 * @param argWhereKey1 key for where condition1 
	 * @param argWhereValue1 String value 1 where to set
	 * @param argWhereKey2 key for where condition2
	 * @param argWhereValue2 String value 2 where to set
	 * @return
	 */
	public static String UPDATETWOWHERECONDITIONSAND(SessionFactory factory, String argTableName, String argSetKey, String argSetValue, String argWhereKey1, String argWhereValue1,String argWhereKey2, String argWhereValue2) 
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetKey +" = '"+argSetValue+"'"
					 			+ " WHERE " + argWhereKey1 + " = '"+argWhereValue1+"' AND " + argWhereKey2 + " = '"+argWhereValue2+"'" ;
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally 
		{
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return "false";
		}
		else
		{
			return "true";
		}
		
	}
	
	/**
	 * Overloaded. Update table cell with given value with two where conditions(AND)
	  * @param factory Session factory
	 * @param argTableName Entity Name to update
	 * @param argSetKey Key for which you want to set value 
	 * @param argSetValue String value which you want to set
	 * @param argWhereKey1 key for where condition1 
	 * @param argWhereValue1 String value 1 where to set
	 * @param argWhereKey2 key for where condition2
	 * @param argWhereValue2 String value 2 where to set
	 * @return
	 */
	public static String UPDATETWOWHERECONDITIONSAND(SessionFactory factory, String argTableName, String argSetKey, int argSetValue, String argWhereKey1, String argWhereValue1,String argWhereKey2, String argWhereValue2) 
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetKey +" = '"+argSetValue+"'"
					 			+ " WHERE " + argWhereKey1 + " = '"+argWhereValue1+"' AND " + argWhereKey2 + " = '"+argWhereValue2+"'" ;
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally 
		{
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return "false";
		}
		else
		{
			return "true";
		}
		
	}
	
	/**
	 * Overloaded. Update table cell with given value with two where conditions(OR)
	  * @param factory Session factory
	 * @param argTableName Entity Name to update
	 * @param argSetKey Key for which you want to set value 
	 * @param argSetValue String value which you want to set
	 * @param argWhereKey1 key for where condition1 
	 * @param argWhereValue1 String value 1 where to set
	 * @param argWhereKey2 key for where condition2
	 * @param argWhereValue2 String value 2 where to set
	 * @return
	 */
	public static String UPDATETWOWHERECONDITIONSOR(SessionFactory factory, String argTableName, String argSetKey, String argSetValue, String argWhereKey1, String argWhereValue1,String argWhereKey2, String argWhereValue2) 
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetKey +" = '"+argSetValue+"'"
					 			+ " WHERE " + argWhereKey1 + " = '"+argWhereValue1+"' OR " + argWhereKey2 + " = '"+argWhereValue2+"'" ;
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally 
		{
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return "false";
		}
		else
		{
			return "true";
		}
		
	}

	/**
	 * Overloaded. Update table cell with given value
	 * @param factory Session factory
	 * @param argTableName Entity Name to update
	 * @param argSetKey Key for which you want to set value 
	 * @param argSetValue String value which you want to set
	 * @param argWhereKey key for where condition
	 * @param argWhereValue int value where to set
	 * @return true if updated. False if not updated
	 */
	public static boolean UPDATE(SessionFactory factory, String argTableName, String argSetKey, String argSetValue, String argWhereKey, int argWhereValue) 
	{
		
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetKey +" = '"+argSetValue+"'"
					 			+ " WHERE " + argWhereKey + " = "+argWhereValue;
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally 
		{
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	
	/**
	 * Overloaded. Update table cell with given value
	 * @param factory Session factory
	 * @param argTableName Entity Name to update
	 * @param argSetKey Key for which you want to set value 
	 * @param argSetValue int value which you want to set
	 * @param argWhereKey key for where condition
	 * @param argWhereValue String value where to set
	 * @return true if updated. False if not updated
	 */
	public static boolean UPDATE(SessionFactory factory, String argTableName, String argSetKey, int argSetValue, String argWhereKey, String argWhereValue) 
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetKey +" = "+argSetValue
					 			+ " WHERE " + argWhereKey + " = '"+argWhereValue+"'";
			
			Query query = session.createQuery(hqlQuery);
			result = query.executeUpdate();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	
	/**
	 * Overloaded. Update table cell with given value
	 * @param factory Session factory
	 * @param argTableName Entity Name to update
	 * @param argSetKey Key for which you want to set value 
	 * @param argSetValue int value which you want to set
	 * @param argWhereKey key for where condition
	 * @param argWhereValue int value where to set
	 * @return true if updated. False if not updated
	 */
	public static boolean UPDATE(SessionFactory factory, String argTableName, String argSetKey, int argSetValue, String argWhereKey, int argWhereValue) 
	{
		Session session = null;
		Transaction tx = null;
		int result=0;
		
		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "UPDATE "+argTableName + " set "+argSetKey +" = "+argSetValue
					 			+ " WHERE " + argWhereKey + " = "+argWhereValue;
			
			Query query = session.createQuery(hqlQuery);
			
			result = query.executeUpdate();
			 
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "UPDATE", " ::Exception e:: ", e.getMessage());
			
		}
		finally {
			session.close(); 
			  
			 System.gc();
		}

		if(result==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Overloaded. SELECT statement with where condition
	 * @param factory Session factory
	 * @param argSelectKeys ArrayList of fields to select
	 * @param argTableName Entity table name
	 * @param argWhereCondition where condition
	 * @return List of Object
	 */
	public static List SELECT (SessionFactory factory, ArrayList argSelectKeys, String argTableName, String argWhereCondition)
	{
		
		StringBuilder sSelectFields = new StringBuilder();
		
		Iterator<String> iterator = argSelectKeys.iterator();
		while (iterator.hasNext()) 
		{
			
			if(sSelectFields==null || sSelectFields.equals("") || sSelectFields.length()==0)
			{
				
				sSelectFields.append(iterator.next());
				
			}
			else
			{
				
				sSelectFields.append(", " + iterator.next());
				
			}
			
		}
		
		
		Session session = null;
		Transaction tx = null;
		List result = null;

		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			String sHqlSelectQuery = "SELECT " + sSelectFields.toString() +
					" FROM " + argTableName + " WHERE " + argWhereCondition;
			
			Query query = session.createQuery(sHqlSelectQuery);
			result = query.list();
			tx.commit();

		}
		catch (HibernateException e) 
		{
			
			fLogger.logp(Level.SEVERE, "Factory", "SELECT", " ::HibernateException e:: ", e.getMessage());
			
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "SELECT", " ::Excpetion e:: ", e.getMessage());
		}
		finally {
			session.close(); 
			 System.gc();
		}
		return result;
		
	}
	
	
	/**
	 * Overloaded. SELECT all.
	 * @param factory Session factory
	 * @param argSelectKeys ArrayList of fields to select
	 * @param argTableName Entity table name
	 * @return List object
	 */
	public static List SELECT (SessionFactory factory, ArrayList argSelectKeys, String argTableName)
	{
		
		return SELECT(factory, argSelectKeys, argTableName, "1=1");		
		
	}
	
	
	/**
	 * Overloaded. SELECT statement with where condition
	 * @param factory Session factory
	 * @param argSelectKey field name to select
	 * @param argTableName Entity table name
	 * @param argWhereCondition where condition
	 * @return String
	 */
	public static String SELECT (SessionFactory factory, String argSelectKey, String argTableName, String argWhereCondition)
	{
		
		Session session = null;
		Transaction tx = null;
		String result = null;

		try
		{
			
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String sHqlSelectQuery = "SELECT " + argSelectKey +
					" FROM " + argTableName + " WHERE " + argWhereCondition;
			Query query = session.createQuery(sHqlSelectQuery);
			result = query.list().toString();
			 
			

		}
		catch (HibernateException e) 
		{
			fLogger.logp(Level.SEVERE, "Factory", "SELECT", " ::HibernateException e:: ", e.getMessage());
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			fLogger.logp(Level.SEVERE, "Factory", "SELECT", " ::Exception e:: ", e.getMessage());
		}
		finally {
			session.close(); 
		}
		return result;
		
	}
		

}

