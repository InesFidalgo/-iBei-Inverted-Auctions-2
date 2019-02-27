/**
 * Raul Barbosa 2014-11-07
 */
package src.Top10LeiloesGanhos;

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

public class Top10LeiloesGanhos extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	
	
	@Override
	public String execute() throws Exception
	{
		
		
		//this.login = (String)this.sess;ion.get("login");
		System.out.println("ENTROUUUUU");
		if(this.getTop10LeiloesGanhosBean().top10Top10LeiloesGanhos())
		{
			System.out.println("da return true");
			return "top10LeiloesGanhosSuccess";
		}
		return "top10LeiloesGanhosError";
		
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

	

	

	public Top10LeiloesGanhosBean getTop10LeiloesGanhosBean()
	{
		
		if(!session.containsKey("top10LeiloesGanhosBean"))
		{
			this.setTop10LeiloesGanhosBean(new Top10LeiloesGanhosBean());
		}
		return (Top10LeiloesGanhosBean) session.get("top10LeiloesGanhosBean");
	}

	private void setTop10LeiloesGanhosBean(Top10LeiloesGanhosBean top10LeiloesGanhosBean) {
		// TODO Auto-generated method stub
		this.session.put("top10LeiloesGanhosBean",top10LeiloesGanhosBean);
	}

	

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
