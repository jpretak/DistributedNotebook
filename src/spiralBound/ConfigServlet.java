package spiralBound;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ConfigServlet", urlPatterns={"/config/*"})
public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB ConfigDao backpack;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigServlet() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String thepath = request.getPathInfo();
	   	 String[] pathelements = thepath.split("/");
	   	 
	   	 	String type = pathelements[1];
	   	 	//System.out.println(type);
	        //String port = pathelements[2];
	   	 	ArrayList<Backpack> backpacklist = (ArrayList<Backpack>) backpack.getBackpack();
	        Backpack b;
	        if(backpacklist.size()==0){
	        	b = new Backpack();
	        	backpacklist.add(b);
	        }
	        	request.setAttribute("config", backpacklist);
	        	request.setAttribute("type", type);
				request.getRequestDispatcher("/config.jsp").forward(request, response);
	        	//do the self port assignment here
	       
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String thepath = request.getPathInfo();
		   	 String[] pathelements = thepath.split("/");
		   	 
		   	 	String type = pathelements[1];
		   	 	System.out.println(type);
		        String port = pathelements[2];
		        ArrayList<Backpack> backpacklist = (ArrayList<Backpack>) backpack.getBackpack();
		        Backpack b;
		        if(backpacklist.size()==0){
		        	b = new Backpack();
		        }else{
		        	b = backpack.getBackpack().get(0);
		        }
		        if(type=="self")
		        {
		        	b.setSelfPort(port);
		        }else if(type=="jndi")
		        {
		        	b.setJndiPort(port);
		        }
		        backpack.persist(b);
		       
	}
}


