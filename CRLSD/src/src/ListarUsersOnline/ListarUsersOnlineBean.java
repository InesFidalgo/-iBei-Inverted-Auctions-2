package src.ListarUsersOnline;


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


public class ListarUsersOnlineBean
{
	
	private RMI server;
	
	
	public String type;
	public String comandoresposta;

	
	public ListarUsersOnlineBean()
	{
		System.out.println("enteou bean");
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


	public void setType(){
		this.type="users_online";
	}
	
	public String getComandoresposta() {
		
		System.out.println("deu return do comando\n"+comandoresposta);
		return comandoresposta;
	}

	public boolean listarUsersOnline() throws RemoteException
	{
		try
		{
			System.out.println("ENTROU NO users online");
			
			
			String[] usersonline = this.server.ListarUsersOnline();
			int size = usersonline.length;
			System.out.println("users online");
			
				System.out.println("procurou BEM");
				
				String comandoresposta = "Número de Utilizadores Online: "+usersonline[0];
				
				System.out.println("n users online:"+usersonline[0]);
				
				int cnt = Integer.parseInt(usersonline[0]);
				int aux = 0;
				for(int j=cnt;j>0;j--){
					aux++;
					comandoresposta+=", users_"+(Integer.parseInt(usersonline[0])-j)+"_username: "+usersonline[aux];
				}
				System.out.println("COMANDO RESPOSTA: "+comandoresposta);
				this.comandoresposta=comandoresposta;
					


					
				return true;
			
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
