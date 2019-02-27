package FacebookLogin;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import rmi.Users;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;

//FACEBOOK!!!!!!!!!!!!!!!!!
public class LoginBean
{
	private String FID;
	private RMI server;

	public LoginBean()
	{
		try
		{
			System.out.println("entrou no try");
			System.setProperty("java.rmi.server.hostname", "localhost");
			this.server =  (RMI) LocateRegistry.getRegistry("localhost", 12345).lookup("rmi");
		}
		catch(IOException |NotBoundException e)
		{
			System.out.println("entra no catch!!!");
			e.printStackTrace();
		}
	}



	public String getFID()
	{
		return this.FID;
	}

	public void setFID(String FID)
	{
		this.FID = FID;
	}

	public int tryLogin() throws RemoteException
	{
		try
		{
			System.out.println("blah blah " + this.FID);
			//System.setProperty("java.rmi.server.hostname", "localhost");
			//this.server =  (RMI) LocateRegistry.getRegistry("localhost", 12345).lookup("rmi");
			int person =  this.server.LoginFacebook(this.FID);
			if (person == 0)
			{
				System.out.println("imprime no login bean null");
				return 1;
				/*either client doesn't exist, or not associated with an account*/
				
			}
			
			if(person == 1){
				System.out.println("imprime no login bean admin");
				return 2;
				/*associated and it is an admin*/
			}
			else{
				System.out.println("imprime no login bean normal");
				return 3;
				/*associated and it is NOT an admin*/
			}
			
			
		}
		catch(IllegalArgumentException e)
		{
			return 0;
		}
		
	}
}
