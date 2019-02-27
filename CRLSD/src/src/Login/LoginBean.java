package src.Login;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import webSocket.WebSocketAnnotation;

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
import java.util.Map;
import java.util.Properties;

public class LoginBean
{
	private String login, password;
	private RMI server;
	public WebSocketAnnotation Socket;
	public String []notificacoes;
	public LoginBean()
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
		this.password = password;
	}
	public String[] getNotificacoes (){
		return this.notificacoes;
	}
	public void setNotificacoes (String []notificacoes){
		this.notificacoes = notificacoes;
	}
	public boolean tryLogin() throws IOException, InterruptedException
	{
		try
		{
			String[] login =  this.server.Login(this.login, this.password);
			this.notificacoes = login;
			int size = login.length;
			System.out.println("size"+size);
			System.out.println("fez login!!");
			if(login[0].equals("false")){
				return false;
			}
			else{
				return true;
			}
			
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
