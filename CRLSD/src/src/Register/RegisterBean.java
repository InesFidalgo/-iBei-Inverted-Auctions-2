package src.Register;


import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import rmi.Security;
import rmi.RMI;

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

public class RegisterBean
{
	private String login, password;
	private RMI server;

	public RegisterBean()
	{
		try
		{
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

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = Security.SHA1(password);
	}

	public boolean getSuccessfulRegister()throws RemoteException
	{
		try{
			String[] register =  this.server.Registar(this.login, this.password);
		return true;
		}
		catch(IOException e)
		{
			return false;
		}
	}
}
