package app.common;

import java.security.MessageDigest;

public class Encrypt {
	
	public String encrypt(String paramData) 
	{
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(paramData.getBytes("UTF-8"));
            byte[] digestBytes = messageDigest.digest();


            String strhex = null;

            for (int i = 0; i < digestBytes.length; i++) {
                //Convert it to positive integer and then to Hex String

                strhex = Integer.toHexString(0xFF & digestBytes[i]);

                //Append "0" to the String to made it exactly 128 length (SHA-512 alogithm)
                if (strhex.length() < 2) 
                    sb.append("0");
                sb.append(strhex);
                }
            }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            }

        return new String(sb);
    }

}
