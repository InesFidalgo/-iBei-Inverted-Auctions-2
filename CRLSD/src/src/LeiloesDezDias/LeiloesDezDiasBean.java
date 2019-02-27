package src.LeiloesDezDias;


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
import rmi.Leilao;
import src.CreateLeilao.CreateLeilaoBean;


public class LeiloesDezDiasBean
{
	
	private RMI server;
	
	public int id;
	
	public String type;
	public String comandoresposta;

	
	public LeiloesDezDiasBean()
	{
		try
		{
			System.out.println("ligou!!!!!!!!!!!!1");
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

	
	public boolean leiloesDezDias() throws RemoteException
	{
		try
		{	comandoresposta = "";
			System.out.println("ENTROU NO Listar dez dias estatisticas");
			
			
			String[] estatisticas = this.server.LeiloesDezDias();
			
			comandoresposta = "Dos últimos 10 dias: ";
			
			for (int j = 0; j < estatisticas.length; j++)
			{
				comandoresposta = comandoresposta + estatisticas[j];
				
			}
			
			System.out.println("foi para qui!!");
			return true;
			
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
