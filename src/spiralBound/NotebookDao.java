package spiralBound;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

 
@Stateless
public class NotebookDao {
	 public List<Notebook> std;
    // Injected database connection:
    @PersistenceContext private EntityManager em;
   
    // Stores a new notebook:
    public void persist(Notebook notebook) {
        em.merge(notebook);
    }
 
    // Retrieves all the notebooks:
    public List<Notebook> getAllNotebooks() {
        TypedQuery<Notebook> query = em.createQuery(
            "SELECT g FROM Notebook g", Notebook.class);
        return query.getResultList();
    }
    
 
    public int deleteNotebook(String id){
    	Query query = em.createQuery(
    			"DELETE from Notebook g where g.id = :notebookID")
    			.setParameter("notebookID",id);
    			int result = query.executeUpdate();
    			return result;
    }
    
    public List<Notebook> getNotebookByID(String id){
    	TypedQuery<Notebook> query = em.createQuery(
    			"SELECT g from Notebook g where g.id = :notebookID", Notebook.class)
    			.setParameter("notebookID",id);
    	return query.getResultList();
    	
    }
    
    
}

