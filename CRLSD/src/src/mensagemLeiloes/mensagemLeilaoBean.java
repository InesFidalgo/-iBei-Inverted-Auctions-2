package src.mensagemLeiloes;


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
import webSocket.WebSocketAnnotation;



public class mensagemLeilaoBean
{
	
	private RMI server;
	public String username;
	public int id ;
	public String mensagem;
	public String login;
	public WebSocketAnnotation Socket;
	public mensagemLeilaoBean()
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
	public void setMensagem(String mensagem){
		this.mensagem=mensagem;
	}

	public boolean mensagemLeilao() throws IOException, InterruptedException
	{
		try
		{
			System.out.println("ENTROU NA MENSAGEM");
			System.out.println("ID:"+this.id);
			String dono = this.server.Dono(this.id);
			System.out.println("dono"+dono);
			ArrayList <String> licitadores = this.server.licitadores(this.id);
			String[] searchleilao = this.server.WriteMensagem(this.id, this.mensagem, this.login);
			System.out.println("Fez ");
			if(searchleilao[0].equals("true")){
				System.out.println("ola ola");
				Socket.sendUser(dono, "Mensagem: O seu leilao com id: "+this.id+"Recebeu uma mensagem de: "+this.login+"Mensagem:"+this.mensagem);
				if (licitadores.size()!=0){
					for (String a: licitadores){
						Socket.sendUser(a, "Mensagem: O leilao que licitou com id: "+this.id+"Recebeu uma mensagem de: "+this.login+"Mensagem:"+this.mensagem);
					}
				System.out.println("Enviou mensagem para o leilão");
				return true;
				}
			
			}
			else{
				return false;
			}
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		return false;
		
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

	
}
