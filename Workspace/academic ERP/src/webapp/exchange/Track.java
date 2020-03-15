package webapp.exchange;

import java.util.ArrayList;

import app.custodian.ManageCustodian;
import app.idcard.ManageIDCard;

public class Track {

	public ArrayList<String> getStatus (ArrayList<String> fieldNames, ArrayList<String> fieldValues)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for(int i=0;i<fieldNames.size();i++)
		{
			if(fieldNames.get(i).equalsIgnoreCase("track-type"))
			{
				if(fieldValues.get(i).equalsIgnoreCase("id-card"))
				{
				  app.idcard.ManageIDCard objManage = new ManageIDCard();
				  
				  String track_status = objManage.getStatusofRequest(fieldValues.get(i+1));
				  if(track_status!="false")
				  {
					  result.add("true");
					  result.add(track_status);
				  }
				  else 
				  {
					  result.add("wrong-reference-number");
				  }
				}
				else if(fieldValues.get(i).equalsIgnoreCase("custodian"))
				{
					app.custodian.ManageCustodian objManage = new ManageCustodian();
					String track_status = objManage.getStatusofRequest(fieldValues.get(i+1));
					  if(track_status!="false")
					  {
						  result.add("true");
						  result.add(track_status);
					  }
					  else 
					  {
						  result.add("wrong-reference-number");
					  }
				}
			}
		}
		
		
		return result;
	}
	
}
