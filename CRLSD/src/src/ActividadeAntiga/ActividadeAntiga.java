/**
 * Raul Barbosa 2014-11-07
 */
package src.ActividadeAntiga;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import src.CreateLeilao.*;

public class ActividadeAntiga extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	

	
	
	
	public String login ;
	
	public String type;
	
	
	
	@Override
	public String execute() throws Exception
	{
		
		this.login = (String)this.session.get("login");
		this.getActividadeAntigaBean().setLogin(this.login);
		
		
		System.out.println(this.login);
		
		
		
		if((this.getActividadeAntigaBean().actividadeAntiga()))
		{
			
			System.out.println("na action"+this.getActividadeAntigaBean().getComandoresposta());
			return "actividadeAntigaSuccess";
		}
		else{
			return "actividadeAntigaError";
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

	
	

	public ActividadeAntigaBean getActividadeAntigaBean()
	{
		
		if(!session.containsKey("actividadeAntigaBean"))
		{
			this.setActividadeAntigaBean(new ActividadeAntigaBean());
		}
		return (ActividadeAntigaBean) session.get("actividadeAntigaBean");
	}

	public void setActividadeAntigaBean(ActividadeAntigaBean actividadeAntigaBean)
	{
		this.session.put("actividadeAntigaBean",actividadeAntigaBean);
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
