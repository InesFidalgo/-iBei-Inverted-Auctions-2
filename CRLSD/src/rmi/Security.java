package rmi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security
{
	public static String SHA1(String input)
	{
		String result;
		byte[] aux;
		try
		{
			aux = MessageDigest.getInstance("SHA-1").digest(input.getBytes());
		}
		catch(NoSuchAlgorithmException e)
		{
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < aux.length; i+=2)
		{
			sb.append(Integer.toString((aux[i] & 0xff) + 0x100, 16).substring(1));
		}
		result = sb.toString();
		return result;
	}
}
