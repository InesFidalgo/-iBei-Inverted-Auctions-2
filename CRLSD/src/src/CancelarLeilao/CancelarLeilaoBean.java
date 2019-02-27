package src.CancelarLeilao;


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

public class CancelarLeilaoBean
{
	
	private RMI server;
	
	public String type;
	public int id;
	

	public CancelarLeilaoBean()
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

	
	public void setId(int id){
		this.id=id;
	}

	
	public void setType(){
		this.type="cancel_auction";
	}
	
	public boolean cancelarLeilao() throws RemoteException
	{
		try
		{
			System.out.println("ENTROU NO CREATE");
			System.out.println("id:"+this.id);
			Random rn = new Random();
			int id = rn.nextInt(100000000); //verificar nos ficheiros se ja nao existe um com este id
			String[] cancelarleilao = this.server.CancelaLeilao(this.id);
			System.out.println("cancelou leilao");
			if(cancelarleilao[0].equals("true")){
				System.out.println("CANCELOU BEM");
				return true;
			}else{
				return false;
			}
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
