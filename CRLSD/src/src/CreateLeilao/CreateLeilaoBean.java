package src.CreateLeilao;


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
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import rmi.RMI;
import src.CreateLeilao.CreateLeilaoBean;

public class CreateLeilaoBean
{
	
	private RMI server;
	
	public String descricao, titulo, codigo;
	public int dia, mes, ano, hora, minuto, amount;
	public String type;
	public int id;
	public String detalhe;
	public String login;

	public CreateLeilaoBean()
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
		System.out.println("login get"+this.login);
		return this.login;
	}

	public void setLogin(String login)
	{
		System.out.println("logado!!!!!!!!!!!!!"+this.login);
		this.login = login;
	}

	public void setDescricao(String descricao){
		this.descricao=descricao;
	}
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public void setDia(int dia){
		this.dia=dia;
	}
	public void setMes(int mes){
		this.mes=mes;
	}
	public void setAno(int ano){
		this.ano=ano;
	}
	
	public void setType(){
		this.type="create_auction";
	}
	public void setHora(int hora){
		this.hora=hora;
	}
	public void setMinuto(int minuto){
		this.minuto=minuto;
	}
	public void setAmount(int amount){
		this.amount=amount;
		
	}
	
	public void setDetalhe(String detalhe){
		this.detalhe=detalhe;
	}
	public boolean createLeilao() throws RemoteException
	{
		try
		{
			System.out.println("ENTROU NO CREATE");
			System.out.println("tituolo:"+this.titulo);
			Random rn = new Random();
			
			int id = rn.nextInt(100000000); //verificar nos ficheiros se ja nao existe um com este id
			System.out.println("this.login"+ this.login);
			String[] criarleilao = this.server.CreateLeilao(this.type, this.login, id, this.codigo, this.titulo, this.descricao,
					 this.ano, this.mes, this.dia, this.hora, this.minuto, this.amount);
			System.out.println("criou leilao");
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
