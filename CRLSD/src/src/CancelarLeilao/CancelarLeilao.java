/**
 * Raul Barbosa 2014-11-07
 */
package src.CancelarLeilao;

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

public class CancelarLeilao extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;
	
	
	
	public int id;
	public String type;
	
	
	@Override
	public String execute() throws Exception
	{
		
		this.getCancelarLeilaoBean().setId(this.id);
		//this.login = (String)this.session.get("login");
		
		if(this.getCancelarLeilaoBean().cancelarLeilao())
		{
			return "cancelarLeilaoSuccess";
		}
		return "cancelarLeilaoError";
		
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

	
	
	public void setId(int id){
		this.id=id;
	}

	
	public void setType(){
		this.type="cancel_auction";
	}
	
	

	

	public CancelarLeilaoBean getCancelarLeilaoBean()
	{
		if(!session.containsKey("cancelarLeilaoBean"))
		{
			this.setCancelarLeilaoBean(new CancelarLeilaoBean());
		}
		return (CancelarLeilaoBean) session.get("cancelarLeilaoBean");
	}

	public void setCancelarLeilaoBean(CancelarLeilaoBean cancelarLeilaoBean)
	{
		this.session.put("cancelarLeilaoBean",cancelarLeilaoBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
