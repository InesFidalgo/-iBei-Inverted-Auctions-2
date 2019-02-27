package src.SearchLeilaoDetalhe;


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


public class SearchLeilaoDetalheBean
{
	
	private RMI server;
	
	public int id;
	
	public String type;
	public String comandoresposta;

	
	public SearchLeilaoDetalheBean()
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
		this.type="detail_auction";
	}
	
	public String getComandoresposta() {
		
		//comandoresposta.replace("\n", "<br />");
		
		return comandoresposta;
	}

	public boolean searchLeilaoDetalhe() throws RemoteException
	{
		try
		{
			System.out.println("ENTROU NO SEARCH");
			System.out.println("id:"+this.id);
			
			String[] searchleilao = this.server.SearchLeilaoDetalhe("detail_auction",this.id);
			int size = searchleilao.length;
			if(size==1){
				return false;
			}
			System.out.println("procurou leilao");
			
				System.out.println("procurou BEM");
				
				comandoresposta = "Título: "+searchleilao[1]+"\n"+"Descrição: "+searchleilao[2]+"\n"+"Deadline: "+searchleilao[3]+"-"+searchleilao[4]+"-"+searchleilao[5]+" "+searchleilao[6]+"-"+searchleilao[7]+"\n"+"Número de Mensagens: "+searchleilao[8];
				int aux = 8;
				System.out.println("tem estas mensagens"+searchleilao[8]);
				if(Integer.parseInt(searchleilao[8])!=0){
					
					int cnt = Integer.parseInt(searchleilao[8]);
					
					if(cnt>0){
					for(int j=cnt;j>0;j--){
							aux++;
							comandoresposta+="\n Mensagens_"+(Integer.parseInt(searchleilao[8])-j)+"_user:"+searchleilao[aux];
							aux++;
							comandoresposta+="\n Mensagens_"+(Integer.parseInt(searchleilao[8])-j)+"_text:"+searchleilao[aux];
					}
					}}
				
				
					//LICITAÇÕES
					aux++;
					comandoresposta+="\nNúmero de Licitações: "+searchleilao[aux];
					int save = Integer.parseInt(searchleilao[aux]);
					int cnt2 = Integer.parseInt(searchleilao[aux]);
					int varia = cnt2;
					if(cnt2>0){
						for(int j=cnt2;j>0;j--){
							aux++;
							comandoresposta+="\n licitação_"+(save-j)+"_user:"+searchleilao[aux];
							aux++;
							comandoresposta+="\n licitação_"+(save-j)+"_amount:"+searchleilao[aux];
							
						}
						
					}
					
					//System.out.println(comandoresposta);
					System.out.println(comandoresposta);


					


					
				return true;
			
			
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}

	
}
