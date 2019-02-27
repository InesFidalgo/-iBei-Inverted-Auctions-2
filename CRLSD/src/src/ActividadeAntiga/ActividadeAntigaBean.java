package src.ActividadeAntiga;


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
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;


import rmi.RMI;
import rmi.Users;
import rmi.Leilao;
import src.CreateLeilao.CreateLeilaoBean;



public class ActividadeAntigaBean
{
	
	private RMI server;
	
	public String login;
	public ArrayList<Leilao> auxa = new ArrayList<>();
	public String type;
	public String comandoresposta;
	
	private ArrayList<String> ids;
	
	public ActividadeAntigaBean()
	{
		try
		{
			System.out.println("ligou");
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

	public String getComandoresposta() {
		
		//comandoresposta.replace("\n", "<br />");
		
		System.out.println("o comando da pagina:"+comandoresposta);
		return comandoresposta;
	}

	public String getLogin()
	{
		System.out.println("login get"+this.login);
		return this.login;
	}

	public void setLogin(String login)
	{
		System.out.println("logado!!!!!!!!!!!!!"+this.login);
		this.login = login;
	}
	
	public boolean actividadeAntiga() throws RemoteException
	{
		try
		{
			
			
			System.out.println("actividade antiga");
			System.out.println("username:"+this.login);
			this.comandoresposta = this.server.GetVelhos(this.login);
			System.out.println(this.comandoresposta);
			
			return true;
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
