package src.Licitacoes;


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
import java.util.Set;

import rmi.RMI;
import webSocket.WebSocketAnnotation;

public class LicitacoesBean
{
	
	private RMI server;
	public String login;
	public int id ;
	public float montante;
	public WebSocketAnnotation Socket;
	
	public LicitacoesBean()
	{
		try
		{
			System.out.println("ligou no licitaçoes");
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
		return this.login;
	}

	public void setLogin(String login)
	{
		System.out.println("login:"+this.login);
		this.login = login;
	}

	
	
	public void setId(int id){
		this.id=id;
	}
	public void setMontante(float montante){
		this.montante=montante;
	}

	public boolean licitacoes() throws IOException, InterruptedException
	{
		try
		{
			System.out.println("ENTROU NO LICITAR");
			System.out.println("ID:"+this.id);
			String dono = this.server.Dono(this.id);
			System.out.println("dono"+dono);
			ArrayList <String> licitadores = this.server.licitadores(this.id);
			System.out.println("ola ola");
			//System.out.println("ultimo"+ultimo);
			System.out.println("LEILAO LICITADO"+this.id);
			String[] searchleilao = this.server.MakeLicitacao(this.id, this.login, this.montante);
			//String[] mensagem = this.server.WriteMensagem(this.id, "licitou:"+ this.montante, this.login);
			
			System.out.println("Fez ");
			if(searchleilao[0].equals("true")){
				int enviouDono;
				System.out.println("ola ola");
				enviouDono = Socket.sendUser(dono, "notificacao: O seu leilao com id: "+this.id+"foi licitado por: "+this.login+"amout: "+this.montante);
				if (enviouDono==0){
					String[] mensagem = this.server.WriteMensagem(this.id, "licitou:"+ this.montante, this.login);
				}
				if (licitadores.size()!=0){
					for (String a: licitadores){
						int enviou;
						enviou = Socket.sendUser(a,"notificacao: O leilao que licitou com id: "+this.id+"foi licitado por: "+this.login+"amout: "+this.montante);
						if (enviou == 0){
							String[] mensagem = this.server.WriteMensagem(this.id, "licitou:"+ this.montante, this.login);
						}
					}
				}
				System.out.println("Licitou");
				return true;
			}
			else{
				return false;
				}
		
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
