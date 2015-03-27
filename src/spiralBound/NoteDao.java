package spiralBound;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

 
@Stateless
public class NoteDao {
	 public List<Note> std;
    // Injected database connection:
    @PersistenceContext private EntityManager em;
   
    // Stores a new notebook:
    public void persist(Note note) {
        em.merge(note);
    }
 
    // Retrieves all the notebooks:
    public List<Note> getAllNotes() {
        TypedQuery<Note> query = em.createQuery(
            "SELECT g FROM Note g", Note.class);
        return query.getResultList();
    }
    
 
    public int deleteNote(String id){
    	Query query = em.createQuery(
    			"DELETE from Note g where g.id = :noteID")
    			.setParameter("noteID",id);
    			int result = query.executeUpdate();
    			return result;
    }
    
    public List<Note> getNoteByID(String id){
    	TypedQuery<Note> query = em.createQuery(
    			"SELECT g from Note g where g.id = :noteID", Note.class)
    			.setParameter("noteID",id);
    	return query.getResultList();
    	
    }
    
    
}
