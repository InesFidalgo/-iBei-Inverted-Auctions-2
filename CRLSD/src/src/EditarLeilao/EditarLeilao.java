/**
 * Raul Barbosa 2014-11-07
 */
package src.EditarLeilao;

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

public class EditarLeilao extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;
	
	public String login;
	
	public String descricao, titulo, codigo;
	public int dia, mes, ano, hora, minuto, amount, id;
	public String type;
	public String detalhe;
	
	@Override
	public String execute() throws Exception
	{
		this.login = (String)this.session.get("login");
		this.getEditarLeilaoBean().setLogin(this.login);
		
		this.getEditarLeilaoBean().setDescricao(this.descricao);
		this.getEditarLeilaoBean().setTitulo(this.titulo);
		this.getEditarLeilaoBean().setCodigo(this.codigo);
		this.getEditarLeilaoBean().setDia(this.dia);
		this.getEditarLeilaoBean().setId(this.id);
		this.getEditarLeilaoBean().setMes(this.mes);
		this.getEditarLeilaoBean().setAno(this.ano);
		this.getEditarLeilaoBean().setHora(this.hora);
		this.getEditarLeilaoBean().setMinuto(this.minuto);
		this.getEditarLeilaoBean().setAmount(this.amount);
		this.getEditarLeilaoBean().setDetalhe(this.detalhe);
		
		System.out.println("login:"+this.login);
		
		//this.login = (String)this.session.get("login");
		
		if(this.getEditarLeilaoBean().editarLeilao())
		{
			return "editarLeilaoSuccess";
		}
		return "editarLeilaoError";
		
	}
	
	public void setId(int id){
		this.id=id;
	}
	public String getLogin()
	{
		System.out.println("login get"+this.login);
		return this.login;
	}

	public void setLogin(String login)
	{
		System.out.println("logado!!!!!!!!!!!!!"+this.login);
		this.login = login;
	}

	public void setDescricao(String descricao){
		this.descricao=descricao;
	}
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public void setDetalhe(String detalhe){
		this.detalhe=detalhe;
	}
	
	public void setHora(int hora){
		this.hora=hora;
	}
	public void setMinuto(int minuto){
		this.minuto=minuto;
	}
	public void setAmount(int amount){
		this.amount=amount;
	}
	public void setDia(int dia){
		this.dia=dia;
	}
	public void setMes(int mes){
		this.mes=mes;
	}
	public void setAno(int ano){
		this.ano=ano;
	}

	
	

	

	public EditarLeilaoBean getEditarLeilaoBean()
	{
		if(!session.containsKey("editarLeilaoBean"))
		{
			this.setEditarLeilaoBean(new EditarLeilaoBean());
		}
		return (EditarLeilaoBean) session.get("editarLeilaoBean");
	}

	public void setEditarLeilaoBean(EditarLeilaoBean editarLeilaoBean)
	{
		this.session.put("editarLeilaoBean",editarLeilaoBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
