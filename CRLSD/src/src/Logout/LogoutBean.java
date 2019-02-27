package src.Logout;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;
import java.util.Properties;

import rmi.RMI;

public class LogoutBean
{
	private String login;
	private RMI server;

	public LogoutBean()
	{
		try
		{
			System.out.println("ligou no logout ao rmi");
			System.setProperty("java.rmi.server.hostname", "localhost");
			this.server =  (RMI) LocateRegistry.getRegistry("localhost", 12345).lookup("rmi");
		}
		catch(IOException |NotBoundException e)
		{
			e.printStackTrace();
		}
	}

	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public boolean logout() throws RemoteException
	{
		System.out.println("mano que vai sair"+this.login);
		this.server.sair(this.login);
		System.out.println("saiu no rmi");
		return true;
		
	}
}
