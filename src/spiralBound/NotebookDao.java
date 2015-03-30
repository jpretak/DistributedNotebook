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
    
 
    public void deleteNotebook(String id){
    	Query query = em.createQuery(
    			"DELETE from Notebook g where g.id = :notebookID")
    			.setParameter("notebookID",id);
    			query.executeUpdate();
    			
    }
    
    public Notebook getNotebook(String id){
    	List<Notebook> notebook;
    	TypedQuery<Notebook> query = em.createQuery(
    			"SELECT g from Notebook g where g.id = :notebookID", Notebook.class)
    			.setParameter("notebookID",id);
    	notebook = query.getResultList();
    	return notebook.get(0);
    	
    }
    
    
}

