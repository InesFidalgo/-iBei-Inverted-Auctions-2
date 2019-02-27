/**
 * Raul Barbosa 2014-11-07
 */
package src.Licitacoes;

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


public class Licitacoes extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	
	public String login;
	public int id;
	public float montante;
	public WebSocketAnnotation Socket;
	@Override
	public String execute() throws Exception
	{
		System.out.println(this.id);
		System.out.println(this.montante);
		this.getLicitacoesBean().setId(this.id);
		this.getLicitacoesBean().setMontante(this.montante);
		this.login = (String)this.session.get("login");
		this.getLicitacoesBean().setLogin(this.login);
		//this.login = (String)this.session.get("login");
		this.Socket = (WebSocketAnnotation)this.session.get("Socket");
		if(this.getLicitacoesBean().licitacoes())
		{
			System.out.println("success");
			return "licitacoesSuccess";
		}
		return "licitacoesError";
		
	}
	
	
	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	
	public void setId(int id){
		this.id=id;
	}
	public void setMontante (float montante){
		this.montante = montante;
	}
	
	public LicitacoesBean getLicitacoesBean()
	{
		if(!session.containsKey("licitacoesBean"))
		{
			this.setLicitacoesBean(new LicitacoesBean());
		}
		return (LicitacoesBean) session.get("licitacoesBean");
	}

	public void setLicitacoesBean(LicitacoesBean licitacoesBean)
	{
		this.session.put("licitacoesBean",licitacoesBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}

