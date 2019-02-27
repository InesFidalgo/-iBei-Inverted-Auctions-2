package src.SearchLeilaoUser;


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
import rmi.Users;
import rmi.Leilao;
import src.CreateLeilao.CreateLeilaoBean;



public class SearchLeilaoUserBean
{
	
	private RMI server;
	
	public String login;
	public ArrayList<Leilao> auxa = new ArrayList<>();
	public String type;
	public String comandoresposta;
	
	private ArrayList<String> ids;
	
	public SearchLeilaoUserBean()
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
	

	
	public ArrayList<Leilao> getAuxa() {
		
		//comandoresposta.replace("\n", "<br />");
		
		return auxa;
	}

	public ArrayList<Leilao> searchLeilaoUser() throws RemoteException
	{
		try
		{
			auxa=new ArrayList<>();
			/*
			System.out.println("ENTROU NO SEARCH por user");
			System.out.println("username:"+this.username);
			String[] resposta = this.server.SearchLeilaoPorUser(this.username);
			String comandoresposta = "Número de Leilões: "+resposta[0];
			int cnt = Integer.parseInt(resposta[0]);
			int aux = 0;
			for(int j=cnt;j>0;j--){
				aux++;
				comandoresposta+=", Item nº"+(Integer.parseInt(resposta[0])-j)+" id: "+resposta[aux];
				aux++;
				comandoresposta+=", Item nº"+(Integer.parseInt(resposta[0])-j)+" código: "+resposta[aux];
				aux++;
				comandoresposta+=", Item nº"+(Integer.parseInt(resposta[0])-j)+" título: "+resposta[aux];
				
			}
			System.out.println(comandoresposta);*/
			
			
			System.out.println("ENTROU NO SEARCH por user");
			System.out.println("username:"+this.login);
			String[] resposta = this.server.SearchLeilaoPorUser(this.login);
			comandoresposta = "Número de Leilões: "+resposta[0];
			int cnt = Integer.parseInt(resposta[0]);
			System.out.println("Número de Leilões que ele tem:"+resposta[0]);
			int aux = 0;
			for(int j=cnt;j>0;j--){
				
				aux++;
				
				System.out.println("??"+resposta[aux]);
				
				String[] detalhes = this.server.SearchLeilaoDetalhe("cenas",Integer.parseInt(resposta[aux]));
				System.out.println("procurou BEM!!!	");
				Users user = new Users(this.login, "", false, true);
				System.out.println(user.getNome());
				for(int i =0;i< detalhes.length;i++){
					System.out.println(detalhes[i]);
				}
				Leilao novo = new Leilao(Integer.parseInt(resposta[aux]),"", detalhes[1],   detalhes[2] , Integer.parseInt(detalhes[3]) , Integer.parseInt(detalhes[4]) , Integer.parseInt(detalhes[5]), Integer.parseInt(detalhes[6]) ,Integer.parseInt(detalhes[7]), user,0f );
				System.out.println("criou o leilao aux");
				//comandoresposta = "Título: "+detalhes[1]+"\n"+"Descrição: "+detalhes[2]+"\n"+"Deadline: "+detalhes[3]+"-"+detalhes[4]+"-"+detalhes[5]+" "+detalhes[6]+"-"+detalhes[7]+"\n"+"Número de Mensagens: "+detalhes[8];
				int aux2 = 8;
				//System.out.println("tem estas mensagens"+detalhes[8]);
				if(Integer.parseInt(detalhes[8])!=0){
					
					System.out.println("esta a ir buscar os detalhes");
					int cnt4 = Integer.parseInt(detalhes[8]);
					
					if(cnt4>0){
					for(int j1=cnt4;j1>0;j1--){
							aux2++;
							//comandoresposta+="\n Mensagens_"+(Integer.parseInt(detalhes[8])-j)+"_user:"+detalhes[aux2];
							aux2++;
							//comandoresposta+="\n Mensagens_"+(Integer.parseInt(detalhes[8])-j)+"_text:"+detalhes[aux2];
					}
					}}
				
				
					//LICITAÇÕES
					aux2++;
					comandoresposta+="\nNúmero de Licitações: "+detalhes[aux2];
					int save = Integer.parseInt(detalhes[aux2]);
					int cnt2 = Integer.parseInt(detalhes[aux2]);
					int varia = cnt2;
					
					if(cnt2>0){
						System.out.println("nao entrou aqui e nao devia");
						for(int j1=cnt2;j1>0;j1--){
							aux2++;
							//comandoresposta+="\n licitação_"+(save-j)+"_user:"+detalhes[aux2];
							aux2++;
							//comandoresposta+="\n licitação_"+(save-j)+"_amount:"+detalhes[aux2];
							System.out.println("detalhes"+detalhes[aux2]);
							novo.amount=Float.parseFloat((detalhes[aux2]));
							System.out.println("novo.amount"+novo.amount);
							
						}
						System.out.println("dfghj"+novo);
						System.out.println("dfguiop"+comandoresposta);
						
					}
					
					//System.out.println(comandoresposta);
					
					System.out.println("dfguiop"+comandoresposta);
					System.out.println("adicionou ao auxa");
					auxa.add(novo);
					System.out.println("ola1"+auxa.size());
					aux+=2;
				}
			
			
			
			
			System.out.println("ola2"+auxa.size());		
			for(int i=0;i< auxa.size();i++){
				
				System.out.println(auxa.get(i).id+"  here\n");
			}

					
				return auxa;
			
			
		}
		catch(IllegalArgumentException e)
		{
			return null;
		}
		
	}

	
}
