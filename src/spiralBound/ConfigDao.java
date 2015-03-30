package spiralBound;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


 
@Stateless
public class ConfigDao {
	 public Backpack std;
    // Injected database connection:
    @PersistenceContext private EntityManager em;
   
    // Stores a new notebook:
    public void persist(Backpack backpack) {
        em.merge(backpack);
    }
 
    // Retrieves all the notebooks:
    public List<Backpack> getBackpack() {
        TypedQuery<Backpack> query = em.createQuery(
            "SELECT g FROM Backpack g", Backpack.class);
        return query.getResultList();
    }
       
}

