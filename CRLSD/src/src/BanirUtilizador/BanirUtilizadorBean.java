package src.BanirUtilizador;


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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Random;

import rmi.RMI;
import src.CreateLeilao.CreateLeilaoBean;

public class BanirUtilizadorBean
{
	
	private RMI server;
	public String username;
	

	
	public BanirUtilizadorBean()
	{
		try
		{
			
			System.setProperty("java.rmi.server.hostname", "localhost");
			this.server =  (RMI) LocateRegistry.getRegistry("localhost", 12345).lookup("rmi");
			//this.server = (RMI) Naming.lookup("rmi://localhost:12345");
		}
		catch(IOException |NotBoundException e)
		{
			e.printStackTrace();
		}
	}
	/*
	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}*/
	public String getUsername(){
		System.out.println("fez get "+username);
		return this.username;
	}
	
	
	public void setUsername(String username){
		System.out.println("fez set"+this.username);
		this.username=username;
	}
	
	
	
	public boolean banirUtilizador() throws RemoteException
	{
		try
		{
			System.out.println("ENTROU NO ban");
			System.out.println("ban:"+this.username);
			String[] criarleilao = this.server.BanUser(this.username);
			System.out.println("baniu");
			if(criarleilao[0].equals("true")){
				System.out.println("CRIOU BEM");
				return true;
			}
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		return false;
	}

	
}
