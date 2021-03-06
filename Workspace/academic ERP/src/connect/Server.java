/*
 * ********************Server.java******************* 
 * Module             : connect
 * Module Purpose     : All json related calls to the methods are done using "call()" method in this module
 * Throws             : Success Message and Exceptions
 * Return             : 
 * Author             : Sri Harsha Samana
 * Revision           :
 * Created on         : 08/aug/2015
 * ********************************************************
 */

package connect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author Sri Harsha Samana
 *
 */
public class Server {
	public static JsonObject convertFileToJSON(String filePath) {

		JsonObject jsonObject = new JsonObject();

		try {
			
			JsonParser parser = new JsonParser();
			JsonElement jsonElement;
			if(filePath.startsWith("http://")){
				URL url = new URL(filePath);
				Reader reader = new InputStreamReader(url.openStream());
				jsonElement = parser.parse(reader);
			}
			else{
				jsonElement = parser.parse(new FileReader(filePath));
			}

			jsonObject = jsonElement.getAsJsonObject();
		} catch (FileNotFoundException e) {
			System.out.println(Messages.getString("connect.Exception") + e); //$NON-NLS-1$
		} catch (@SuppressWarnings("hiding") IOException ioe) {
			System.out.println(Messages.getString("connect.Exception") + ioe); //$NON-NLS-1$
		}

		return jsonObject;
	}
	


	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		
		System.out.println(server.convertFileToJSON("http://localhost:8080/chhatarpur/json/banner.json"));
	}

	private static String PACKAGE = Messages.getString("connect.exchange"); //$NON-NLS-1$

	/**
	 * 
	 */
	public Server() {
	}

	/**
	 * Calls a method in a package written in the CoreBusinessCode
	 * 
	 * @param paramClassName
	 *            Class Name of the class to be written in "exchange package"
	 * @param paramMethodName
	 *            Method Name present in the class file
	 * @param paramArgs
	 *            Arguments to be passed to the method
	 * @return a String containing the result of calling the method
	 * @throws Exception
	 */
	public String call(String paramClassName, String paramMethodName,
			String paramArgs) throws Exception {
		String strResultArray = null;
		try {
			JsonArray jsonArray = null;
			try {
				if(paramArgs != null){
					if(!(paramArgs.equalsIgnoreCase("null") || (paramArgs.trim()).equalsIgnoreCase("") || (paramArgs.trim()).equalsIgnoreCase("\"\""))){
						jsonArray = new Gson().fromJson(paramArgs, JsonArray.class);
					}
				}
			} catch (Exception ex) {
				strResultArray = Messages.getString("connect.IllegalArgumentsException"); //$NON-NLS-1$
				System.out.println(Messages.getString("connect.ServerCallException") + ex); //$NON-NLS-1$
				return strResultArray;
			}

			ArrayList<String> argsTypeList = new ArrayList<String>();
			ArrayList<Object> argsValueList = new ArrayList<Object>();
			
			if(jsonArray !=  null){
				for (int i = 0; i < jsonArray.size(); i++) {
					JsonElement eachJsonElement = jsonArray.get(i);
					JsonObject jsonObj = eachJsonElement.getAsJsonObject();
					JsonElement jsonStringData = jsonObj.get(Messages.getString("connect.type.String")); //$NON-NLS-1$
					JsonElement jsonListData = jsonObj.get(Messages.getString("connect.type.List")); //$NON-NLS-1$
	
					if (jsonStringData != null) {
						argsTypeList.add(Messages.getString("connect.type.String")); //$NON-NLS-1$
						String strEachValue = jsonStringData.toString();
						strEachValue = strEachValue.substring(1,
								strEachValue.length() - 1);
						argsValueList.add(strEachValue);
					}
					if (jsonListData != null) {
						ArrayList<String> eachArgsValueList = new ArrayList<String>();
						argsTypeList.add(Messages.getString("connect.type.List")); //$NON-NLS-1$
						JsonArray eachJsonArray = jsonListData.getAsJsonArray();
						for (int z = 0; z < eachJsonArray.size(); z++) {
							JsonElement eachJsonElementTemp = eachJsonArray.get(z);
							eachArgsValueList
									.add(eachJsonElementTemp.getAsString());
						}
						argsValueList.add(eachArgsValueList);
					}
				}
			}

			Server server = new Server();
			strResultArray = server.callActualMethod(paramClassName,
					paramMethodName, argsTypeList, argsValueList);
		} catch (Exception ex) {
			strResultArray = Messages.getString("connect.UnknownException"); //$NON-NLS-1$
			System.out.println(Messages.getString("connect.ServerCallException") + ex); //$NON-NLS-1$
			return strResultArray;
		}

		return strResultArray;
	}

	
	/**
	 * Calls the Actual Method 
	 * @param paramClassName
	 * @param paramMethodName
	 * @param paramArgsTypeList
	 * @param paramArgsValueList
	 * @return a String containing the result of calling the method
	 * @throws Exception
	 */
	public String callActualMethod(String paramClassName,
			String paramMethodName, ArrayList<String> paramArgsTypeList,
			ArrayList<Object> paramArgsValueList) throws Exception {
		String strReturnObjectString = null;

		try {
			int size = paramArgsTypeList.size();
			Class<?> cls;
			Class<?>[] param_types = new Class<?>[size];
			Object[] arguments = new Object[size];
			cls = Class.forName(PACKAGE + "." + paramClassName); //$NON-NLS-1$

			for (int i = 0; i < paramArgsTypeList.size(); i++) {
				if (paramArgsTypeList.get(i).equals(Messages.getString("connect.type.String"))) { //$NON-NLS-1$
					param_types[i] = String.class;
					arguments[i] = paramArgsValueList.get(i).toString();
				} else if (paramArgsTypeList.get(i).equals(Messages.getString("connect.type.List"))) { //$NON-NLS-1$
					param_types[i] = ArrayList.class;
					arguments[i] = paramArgsValueList
							.get(i);
				}
			}

			Method method;
			try {
				method = cls.getMethod(paramMethodName, param_types);
			} catch (Exception ex) {
				strReturnObjectString = Messages.getString("connect.MethodNotFoundException"); //$NON-NLS-1$
				System.out.println(Messages.getString("connect.ServerCallException") + ex); //$NON-NLS-1$
				return strReturnObjectString;
			}

			Object returnObject;

			try {
				returnObject = method.invoke(cls.newInstance(), arguments);
			} catch (Exception ex) {
				strReturnObjectString = Messages.getString("connect.MethodInvokeException"); //$NON-NLS-1$
				System.out.println(Messages.getString("connect.ServerCallException") + ex); //$NON-NLS-1$
				return strReturnObjectString;
			}

			Class<?> strReturnType = method.getReturnType();
			Server server = new Server();
			strReturnObjectString = server.packReturnValue(strReturnType,
					returnObject);
		} catch (Exception ex) {
			strReturnObjectString = Messages.getString("connect.UnknownException"); //$NON-NLS-1$
			System.out.println(Messages.getString("connect.ServerCallException") + ex); //$NON-NLS-1$
			return strReturnObjectString;
		}

		return strReturnObjectString;
	}

	/**
	 * Packs the Return Value
	 * 
	 * @param returnTypeClass
	 * @param returnObjectValue
	 * @return a String Containing the packed return values
	 * @throws Exception
	 */
	public String packReturnValue(Class<?> returnTypeClass,
			Object returnObjectValue) throws Exception {
		String strReturnString = null;
		try {
			if (returnObjectValue != null) {
				
				if(returnTypeClass.equals(Integer.class) || returnTypeClass.equals(String.class) || returnTypeClass.equals(Boolean.class) || returnTypeClass.equals(Byte.class) || returnTypeClass.equals(Double.class) || returnTypeClass.equals(Float.class) || returnTypeClass.equals(Long.class) || returnTypeClass.equals(Short.class)){
					strReturnString = returnObjectValue.toString();
					if (strReturnString != null) {
						strReturnString = strReturnString
								.replaceAll("\"", "\\\\\""); //$NON-NLS-1$ //$NON-NLS-2$
					}

					strReturnString = "[{" + Messages.getString("connect.return.value") + "\"" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							+ strReturnString + "\"" + "}]"; //$NON-NLS-1$ //$NON-NLS-2$
				}
				else if (returnTypeClass.equals(List.class)
						|| returnTypeClass.equals(ArrayList.class)) {
					strReturnString = "["; //$NON-NLS-1$
					boolean check = true;
					@SuppressWarnings("unchecked")
					List<Object> listObjects = (List<Object>)returnObjectValue;
					for (Object obj : listObjects) {
						if(!(obj.getClass().equals(String.class) || obj.getClass().equals(Integer.class) || obj.equals(Boolean.class) || obj.equals(Byte.class) || obj.equals(Double.class) || obj.equals(Float.class) || obj.equals(Long.class) || obj.equals(Short.class))){
							check = false;
						}
					}
					if(check){
						@SuppressWarnings("unchecked")
						ArrayList<String> list = (ArrayList<String>) returnObjectValue;
	
						for (int i = 0; i < list.size(); i++) {
							String str = list.get(i);
							if (str != null) {
								str = str.replaceAll("\"", "\\\\\""); //$NON-NLS-1$ //$NON-NLS-2$
							}
							strReturnString += "{" + Messages.getString("connect.return.value") + "\"" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
									+ str + "\"" + "},"; //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
					else{
						for (Object obj : listObjects) {
							
							Class<?> eachObjClass = obj.getClass();
							Method[] methods = eachObjClass.getMethods();
							strReturnString += "{";
							for(Method method:methods){
								if(method.getName().startsWith("get")){
									Object returnObj = method.invoke(obj);
									if(returnObj != null){
									String strValue = returnObj.toString();
									if (strValue != null) {
										strValue = strValue.replaceAll("\"", "\\\\\"");
									}
									
									strReturnString += "\"" + method.getName().trim().substring(3,method.getName().length()) + "\":\"" + strValue + "\"" + ",";
									
									}
									else{
										strReturnString += "\"" + method.getName().trim().substring(3,method.getName().length()) + "\":\"" + "null" + "\"" + ",";
									}
								}
							}
							if (!strReturnString.equals("{")) {
							strReturnString = strReturnString.substring(0,
									strReturnString.length() - 1);
							}
							strReturnString += "},";
						}

					}
					if (!strReturnString.equals("[")) { //$NON-NLS-1$
						strReturnString = strReturnString.substring(0,
								strReturnString.length() - 1);
					}
					strReturnString += "]"; //$NON-NLS-1$
				} else if (returnTypeClass.equals(ResultSet.class)
						|| returnTypeClass.equals(CachedRowSet.class)) {
					strReturnString = "["; //$NON-NLS-1$
					CachedRowSet crs = (CachedRowSet) returnObjectValue;
					ResultSetMetaData crsMeta = null;

					try {
						crsMeta = crs.getMetaData();
					} catch (SQLException e1) {
						strReturnString = Messages.getString("connect.SQLExceptionDisplay"); //$NON-NLS-1$
						System.out
								.println(Messages.getString("connect.SQLException") //$NON-NLS-1$
										+ e1);
						return strReturnString;
					}

					if (crsMeta != null) {
						int size = crsMeta.getColumnCount();

						try {
							while (crs.next()) {

								strReturnString += "{"; //$NON-NLS-1$

								for (int i = 0; i < size; i++) {
									String strColumnName = crsMeta
											.getColumnName(i + 1);
									String strColumnValue = crs
											.getString(strColumnName);
									if (strColumnValue != null) {
										strColumnValue = strColumnValue
												.replaceAll("\"", "\\\\\""); //$NON-NLS-1$ //$NON-NLS-2$
									}
									strReturnString += "\"" + strColumnName //$NON-NLS-1$
											+ "\"" + ":" + "\"" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
											+ strColumnValue + "\","; //$NON-NLS-1$
								}
								if (!strReturnString.equals("{")) {
								strReturnString = strReturnString.substring(0,
										strReturnString.length() - 1);
								}
								strReturnString += "},"; //$NON-NLS-1$

							}
						} catch (SQLException e) {
							strReturnString = Messages.getString("connect.SQLExceptionDisplay"); //$NON-NLS-1$
							System.out
									.println(Messages.getString("connect.SQLException") //$NON-NLS-1$
											+ e);
							return strReturnString;
						}

					}
					if (!strReturnString.equals("[")) { //$NON-NLS-1$
						strReturnString = strReturnString.substring(0,
								strReturnString.length() - 1);
					}

					strReturnString += "]"; //$NON-NLS-1$
				}

			} else {
				strReturnString = "[{" + Messages.getString("connect.return.value") + "\"" + Messages.getString("connect.null") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ "\"" + "}]"; //$NON-NLS-1$ //$NON-NLS-2$
				return strReturnString;
			}
		} catch (Exception ex) {
			strReturnString = Messages.getString("connect.PackingReturnValueException"); //$NON-NLS-1$
			System.out.println(Messages.getString("connect.ServerCallException") + ex); //$NON-NLS-1$
			return strReturnString;
		}

		return strReturnString;
	}
}
