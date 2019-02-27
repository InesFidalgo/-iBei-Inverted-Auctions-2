package src.SearchLeilao;


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


public class SearchLeilaoBean
{
	
	private RMI server;
	
	public String codigo;
	
	public String type;

	public ArrayList<rmi.Leilao> leiloes = new ArrayList<>();
	public SearchLeilaoBean()
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

	
	
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public void setType(){
		this.type="search_auction";
	}
	
	public ArrayList<Leilao> getLeiloes() {
		
		return leiloes;
	}

	public boolean searchLeilao() throws RemoteException
	{
		try
		{
			leiloes = new ArrayList<>();
			System.out.println("ENTROU NO SEARCH");
			System.out.println("codigo:"+this.codigo);
			
			String[] searchleilao = this.server.SearchLeilao(this.codigo);
			int size = searchleilao.length;
			System.out.println("procurou leilao"+size);
			
				System.out.println("procurou BEM");
				int cnt =0;
				Leilao novo = new Leilao(0, "", "", "", 0, 0, 0, 0, 0, null, 0);
				while((size-1)>0){
					System.out.println("size"+size);
					System.out.println("o que ficou dentro: "+searchleilao[cnt]);
					int i=0;
					if(cnt==1+i){
						
						System.out.println("entrou na iteração 1");
						System.out.println("o que la esta antes de crashar"+Integer.parseInt(searchleilao[cnt]));
						
						novo.id = Integer.parseInt(searchleilao[cnt]);
						System.out.println("id guardado:"+novo.id);
						cnt++;
						size--;
					}
					if(cnt==2+i){
						System.out.println("entrou na iteração 2");
						novo.codigo = searchleilao[cnt];
						System.out.println("codigo guardado:"+novo.codigo);
						cnt++;
						size--;
					}
					if(cnt==3+i){
						System.out.println("entrou na iteração 3");
						novo.titulo = searchleilao[cnt];
						System.out.println("titulo guardado:"+novo.titulo);
						cnt++;
						size--;
						leiloes.add(novo);
					}
					
					else{
						System.out.println("hela"+searchleilao[cnt]+"cnt"+cnt);
						if(searchleilao[cnt]==null){
							System.out.println("vai sair");
							break;
						}
						
						
						
						i+=3;
						cnt=0;
						novo= new Leilao(0, "", "", "", 0, 0, 0, 0, 0, null, 0);;
						System.out.println("continua");
					
					}
					cnt++;
					size--;
				}
				
				System.out.println("vai dar return true");
				System.out.println("size:"+leiloes.size());
				for(int i=0;i<leiloes.size();i++){
					
					System.out.println(leiloes.get(i).getCodigo()+"\n"+leiloes.get(i).titulo+"\n"+ leiloes.get(i).getId());
				}
				return true;
			
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
