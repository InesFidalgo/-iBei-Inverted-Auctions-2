/**
 * Raul Barbosa 2014-11-07
 */
package src.ListarUsersOnline;

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

public class ListarUsersOnline extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;

	public String type;
	
	
	@Override
	public String execute() throws Exception
	{
		
		
		//this.login = (String)this.session.get("login");
		
		if(this.getListarUsersOnlineBean().listarUsersOnline())
		{
			System.out.println("entrou aqui3");
			return "listarUsersOnlineSuccess";
		}
		return "listarUsersOnlineError";
		
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

	
	public void setType(){
		this.type="online_users";
	}
	
	

	public ListarUsersOnlineBean getListarUsersOnlineBean()
	{
		
		if(!session.containsKey("listarUsersOnlineBean"))
		{
			System.out.println("entrou aqui2");
			this.setListarUsersOnlineBean(new ListarUsersOnlineBean());
		}
		return (ListarUsersOnlineBean) session.get("listarUsersOnlineBean");
	}

	public void setListarUsersOnlineBean(ListarUsersOnlineBean listarUsersOnlineBean)
	{
		System.out.println("entrou aqui");
		this.session.put("listarUsersOnlineBean",listarUsersOnlineBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
