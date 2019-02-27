/**
 * Raul Barbosa 2014-11-07
 */
package src.ListarMyLici;

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

public class ListarMyLici extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	
	public String login;

	
	@Override
	public String execute() throws Exception
	{
		this.login = (String)this.session.get("login");
		this.getListarMyLiciBean().setLogin(this.login);
		
	
		
		System.out.println("login:"+this.login);
		
		//this.login = (String)this.session.get("login");
		
		if(this.getListarMyLiciBean().listarMyLici())
		{
			return "listarMyLiciSuccess";
		}
		return "listarMyLiciError";
		
	}
	
	
	public String getLogin()
	{
		System.out.println("login get"+this.login);
		return this.login;
	}

	public void setLogin(String login)
	{
		System.out.println("logado!!"+this.login);
		this.login = login;
	}

	

	

	public ListarMyLiciBean getListarMyLiciBean()
	{
		if(!session.containsKey("listarMyLiciBean"))
		{
			this.setListarMyLiciBean(new ListarMyLiciBean());
		}
		return (ListarMyLiciBean) session.get("listarMyLiciBean");
	}

	public void setListarMyLiciBean(ListarMyLiciBean listarMyLiciBean)
	{
		this.session.put("listarMyLiciBean",listarMyLiciBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
