package FacebookLoginInside;


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
public class LogInsideBean
{
	private String nome;

	private String FID;
	private RMI server;

	public LogInsideBean()
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

	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getFID()
	{
		return this.FID;
	}

	public void setFID(String FID)
	{
		this.FID = FID;
	}

	public boolean tryLoginInside() throws RemoteException
	{
		try
		{
			System.out.println("blah blah " + this.FID);
			//System.setProperty("java.rmi.server.hostname", "localhost");
			//this.server =  (RMI) LocateRegistry.getRegistry("localhost", 12345).lookup("rmi");
			boolean person =  this.server.LoginFacebookInside(this.nome, this.FID);
			
			
			return true;
			
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
