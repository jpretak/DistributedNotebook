package spiralBound;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
 
	@Entity
	public class Notebook implements Serializable{
	private static final long serialVersionUID = 12L;
		 
	    // Persistent Fields:
	    @Id
	    private String title;
	    //private Date signingDate;
	    private String id;
	    //private Notes as a list of notes
	    private List<Note> notes;
	 
	    // Constructors:
	    public Notebook(String title) {
	        this.title = title;
	        notes = new ArrayList<Note>();
	    }
	    
	    public Notebook(String title, String id){
	    	this.title=title;
	    	this.id=id;
	    	notes = new ArrayList<Note>();
	    	//this.addNote("1", "this is the content of this note");

	    }
	    
	    public void setID(String id) {
	    	this.id = id;
	    }
	    
	    public String getID() {
	    	return id;
	    }
	    
	    public String getTitle(){
	    	return title;
	    }
	    
	    public List<Note> getNotes(){
	    	return notes;
	    }
	    
	    public Note getNoteById(String id){
	    	for(Note n:notes)
			{
				if (n.getID().equals(id))
					{
						return n;
					}
			}
			return null;
	    }
	    
	    public void addNote(String id, String content)
	    {
	    	System.out.println(notes.toString());
	    	System.out.println(id);
	    	System.out.println(content);
	    	notes.add(new Note("1","content"));
	    }
	    
	 
	    // String Representation:
	    @Override
	    public String toString() {
	        return title + " (" + id + ")";
	    }
	    
	
}