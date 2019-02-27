/**
 * Raul Barbosa 2014-11-07
 */
package src.SearchLeilao;

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

public class SearchLeilao extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;
	
	
	
	public String codigo;
	
	public String type;
	
	
	@Override
	public String execute() throws Exception
	{
		
		this.getSearchLeilaoBean().setCodigo(this.codigo);
		
		//this.login = (String)this.session.get("login");
		
		if(this.getSearchLeilaoBean().searchLeilao())
		{
			
			return "searchLeilaoSuccess";
		}
		return "searchLeilaoError";
		
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

	
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	
	public void setType(){
		this.type="search_auction";
	}
	
	

	public SearchLeilaoBean getSearchLeilaoBean()
	{
		
		if(!session.containsKey("searchLeilaoBean"))
		{
			this.setSearchLeilaoBean(new SearchLeilaoBean());
		}
		return (SearchLeilaoBean) session.get("searchLeilaoBean");
	}

	public void setSearchLeilaoBean(SearchLeilaoBean searchLeilaoBean)
	{
		this.session.put("searchLeilaoBean",searchLeilaoBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
