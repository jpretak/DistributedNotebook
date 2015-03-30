package spiralBound;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ManagedBean
@Remote
@ApplicationScoped
public class Backpack implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private List<Notebook> notebooks;
	private String selfPort;
	private String jndiPort;
	
	//default constructor
	public Backpack()
	{
		id = "1";
		notebooks = new ArrayList<Notebook>();
		
	}
	public List<Notebook> getNotebooks(){
		return notebooks;
	}
	
	public void addNotebook(Notebook n)
	{
		notebooks.add(n);
	}
	
	public String getSelfPort()
	{
		return selfPort;
	}
	
	public String getJndiPort()
	{
		return jndiPort;
	}
	
	public void setSelfPort(String port)
	{
		selfPort = port;
	}
	
	public void setJndiPort(String port)
	{
		jndiPort = port;
	}
	
	
}
