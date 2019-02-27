package src.ListarVersoesAntigas;


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


public class ListarVersoesAntigasBean
{
	
	private RMI server;
	
	public int id;
	
	public String type;
	public String comandoresposta;

	
	public ListarVersoesAntigasBean()
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

	
	
	public void setId(int id){
		this.id=id;
	}
	
	
	public void setType(){
		this.type="versoes_antigas";
	}
	
	public String getComandoresposta() {
		
		//comandoresposta.replace("\n", "<br />");
		
		System.out.println("o comando da pagina:"+comandoresposta);
		return comandoresposta;
	}

	
	public boolean listarVersoesAntigas() throws RemoteException
	{
		try
		{	comandoresposta = "";
			System.out.println("ENTROU NO Listar Versões Antigas");
			System.out.println("id:"+this.id);
			
			String[] versoesantigas = this.server.ListarAntigas(this.id);
			
			int size = versoesantigas.length;
			if(size==1){
				return false;
			}
			System.out.println("size"+size);
			System.out.println("prourou leilao");

			
			System.out.println("procurou BEM");
			if(comandoresposta.length()!=1){
				System.out.println("aqui"+comandoresposta);
				comandoresposta += "code: "+versoesantigas[0]+", ";
				comandoresposta+= "title: "+versoesantigas[1]+", ";
				comandoresposta+= "description: "+versoesantigas[2]+", ";
				comandoresposta+= "date: "+versoesantigas[3];
				
			}
			else{
				comandoresposta+="Não existem versões anteriores\n";
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
