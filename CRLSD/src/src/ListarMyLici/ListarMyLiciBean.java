package src.ListarMyLici;


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

public class ListarMyLiciBean
{
	
	private RMI server;
	public String comandoresposta;
	
	public String login;
	public ListarMyLiciBean()
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
	
	public String getLogin()
	{
		System.out.println("get!!!!!!!!!!!!!"+this.login);
		return this.login;
	}

	public void setLogin(String login)
	{
		System.out.println("logado!!!!!!!!!!!!!"+this.login);
		this.login = login;
	}

	public String getComandoresposta() {
		
		//comandoresposta.replace("\n", "<br />");
		
		System.out.println("o comando da pagina:"+comandoresposta);
		return comandoresposta;
	}

	
	public boolean listarMyLici() throws RemoteException
	{
		try
		{
			System.out.println("ENTROU NO listar minhas licitacoes");
			System.out.println("this.login"+ this.login);
			String[] criarleilao = this.server.ListarLicitacoesUser(this.login);
			comandoresposta = "Número de Licitações: "+criarleilao[0];
			int cnt = Integer.parseInt(criarleilao[0]);
			int aux =0;
			for(int j=1;j<=cnt;j++){
				aux++;
				comandoresposta += "; id: "+criarleilao[aux];
				aux++;
				comandoresposta+=", valor: "+criarleilao[aux];
			}
			System.out.println(comandoresposta);
			return true;
		
		
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
