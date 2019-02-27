/**
 * Raul Barbosa 2014-11-07
 */
package src.BanirUtilizador;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
import java.util.Random;

import rmi.Leilao;
import rmi.RMI;
import rmi.RMIServer;
import rmi.Registar;
import rmi.Response;
import src.CreateLeilao.*;

public class BanirUtilizador extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;
	
	
	public String username;
	
	
	@Override
	public String execute() throws Exception
	{
		System.out.println("execute"+this.username);
		this.getBanirUtilizadorBean().setUsername(this.username);
		
		//this.login = (String)this.session.get("login");
		
		if(this.getBanirUtilizadorBean().banirUtilizador())
		{
			System.out.println("vai dar true no banir");
			return "banirUtilizadorSuccess";
		}
		return "banirUtilizadorError";
		
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


	public void setUsername(String username){
		System.out.println("set"+username);
		this.username=username;
	}
	public String getUsername(){
		System.out.println("gwet"+username);
		return this.username;
	}
	
	

	public BanirUtilizadorBean getBanirUtilizadorBean()
	{
		if(!session.containsKey("banirUtilizadorBean"))
		{
			this.setBanirUtilizadorBean(new BanirUtilizadorBean());
		}
		return (BanirUtilizadorBean) session.get("banirUtilizadorBean");
	}

	public void setBanirUtilizadorBean(BanirUtilizadorBean banirUtilizadorBean)
	{
		this.session.put("banirUtilizadorBean",banirUtilizadorBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
