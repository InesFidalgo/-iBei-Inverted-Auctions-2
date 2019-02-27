/**
 * Raul Barbosa 2014-11-07
 */
package src.CreateLeilao;

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

public class CriarLeilao extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5590830L;
	private Map<String, Object> session;
	Leilao novo = null;
	
	public String login;
	
	public String descricao, titulo, codigo;
	public int dia, mes, ano, hora, minuto, amount;
	public String type;
	public int idpedido;
	public String detalhe;
	
	@Override
	public String execute() throws Exception
	{
		this.login = (String)this.session.get("login");
		this.getCreateLeilaoBean().setLogin(this.login);
		
		this.getCreateLeilaoBean().setDescricao(this.descricao);
		this.getCreateLeilaoBean().setTitulo(this.titulo);
		this.getCreateLeilaoBean().setCodigo(this.codigo);
		this.getCreateLeilaoBean().setDia(this.dia);
		this.getCreateLeilaoBean().setMes(this.mes);
		this.getCreateLeilaoBean().setAno(this.ano);
		this.getCreateLeilaoBean().setHora(this.hora);
		this.getCreateLeilaoBean().setMinuto(this.minuto);
		this.getCreateLeilaoBean().setAmount(this.amount);
		this.getCreateLeilaoBean().setDetalhe(this.detalhe);
		
		System.out.println("login:"+this.login);
		
		//this.login = (String)this.session.get("login");
		
		if(this.getCreateLeilaoBean().createLeilao())
		{
			return "createLeilaoSuccess";
		}
		return "createLeilaoError";
		
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

	
	public void setType(){
		this.type="create_auction";
	}
	
	

	

	public CreateLeilaoBean getCreateLeilaoBean()
	{
		if(!session.containsKey("createLeilaoBean"))
		{
			this.setCreateLeilaoBean(new CreateLeilaoBean());
		}
		return (CreateLeilaoBean) session.get("createLeilaoBean");
	}

	public void setCreateLeilaoBean(CreateLeilaoBean createLeilaoBean)
	{
		this.session.put("createLeilaoBean",createLeilaoBean);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
