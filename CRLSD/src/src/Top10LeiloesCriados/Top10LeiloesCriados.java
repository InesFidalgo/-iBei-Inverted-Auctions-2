/**
 * Raul Barbosa 2014-11-07
 */
package src.Top10LeiloesCriados;

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
import src.SearchLeilao.SearchLeilaoBean;

public class Top10LeiloesCriados extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	
	
	@Override
	public String execute() throws Exception
	{
		
		
		//this.login = (String)this.sess;ion.get("login");
		System.out.println("ENTROUUUUU");
		if(this.getTop10LeiloesCriadosBean().top10LeiloesCriados())
		{
			System.out.println("da return true");
			return "top10LeiloesCriadosSuccess";
		}
		return "top10LeiloesCriadosError";
		
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

	

	

	public Top10LeiloesCriadosBean getTop10LeiloesCriadosBean()
	{
		
		if(!session.containsKey("top10LeiloesCriadosBean"))
		{
			this.setTop10LeiloesCriadosBean(new Top10LeiloesCriadosBean());
		}
		return (Top10LeiloesCriadosBean) session.get("top10LeiloesCriadosBean");
	}

	private void setTop10LeiloesCriadosBean(Top10LeiloesCriadosBean top10LeiloesCriadosBean) {
		// TODO Auto-generated method stub
		this.session.put("top10LeiloesCriadosBean",top10LeiloesCriadosBean);
	}

	

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
