package spiralBound;

import java.io.Serializable;

public class Note implements Serializable{
	private static final long serialVersionUID = 24L;
	
	private String id;
	private String contents;
	
	
	public Note(String id, String content)
	{
		this.id = id;
		this.contents = content;
	}
	public String getID()
	{
		return id;
	}
	
	public String getContents()
	{
		return contents;
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public void setContents(String contents)
	{
		this.contents = contents;
	}
	
}
