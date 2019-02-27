/**
 * Raul Barbosa 2014-11-07
 */
package src.LeiloesDezDias;

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

public class LeiloesDezDias extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	
	
	@Override
	public String execute() throws Exception
	{
		
		
		//this.login = (String)this.sess;ion.get("login");
		System.out.println("ENTROUUUUU");
		if(this.getLeiloesDezDiasBean().leiloesDezDias())
		{
			System.out.println("da return true");
			return "leiloesDezDiasSuccess";
		}
		return "leiloesDezDiasError";
		
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

	

	

	public LeiloesDezDiasBean getLeiloesDezDiasBean()
	{
		
		if(!session.containsKey("leiloesDezDiasBean"))
		{
			this.setLeiloesDezDiasBean(new LeiloesDezDiasBean());
		}
		return (LeiloesDezDiasBean) session.get("leiloesDezDiasBean");
	}

	private void setLeiloesDezDiasBean(LeiloesDezDiasBean leiloesDezDiasBean) {
		// TODO Auto-generated method stub
		this.session.put("leiloesDezDiasBean",leiloesDezDiasBean);
	}

	

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
