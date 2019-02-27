/**
 * Raul Barbosa 2014-11-07
 */
package src.mensagemLeiloes;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
import java.util.Random;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import webSocket.WebSocketAnnotation;


public class mensagemLeilao extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	
	
	
	public int id;
	public String mensagem, login;
	public WebSocketAnnotation Socket;
	
	
	@Override
	public String execute() throws Exception
	{
		System.out.println(this.id);
		this.login = (String)this.session.get("login");
		this.getmensagemLeilaoBean().setLogin(this.login);
		this.getmensagemLeilaoBean().setId(this.id);
		this.getmensagemLeilaoBean().setMensagem(this.mensagem);
		System.out.println("login:"+this.login);
		this.Socket= (WebSocketAnnotation)this.session.get("Socket");
		//this.login = (String)this.session.get("login");
		
		if(this.getmensagemLeilaoBean().mensagemLeilao())
		{
			return "enviaSuccess";
		}
		return "enviaError";
		
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
	
	public void setId(int id){
		this.id=id;
	}
	public void setMensagem (String mensagem){
		this.mensagem = mensagem;
	}
	
	public mensagemLeilaoBean getmensagemLeilaoBean()
	{
		if(!session.containsKey("mensagemLeilaoBean"))
		{
			this.setLicitarBean(new mensagemLeilaoBean());
		}
		return (mensagemLeilaoBean) session.get("mensagemLeilaoBean");
	}

	public void setLicitarBean(mensagemLeilaoBean mensagemLeilaoBean)
	{
		this.session.put("mensagemLeilaoBean",mensagemLeilaoBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}

