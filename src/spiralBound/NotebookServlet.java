package spiralBound;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "NotebookServlet", urlPatterns={"/notebook/*"})
public class NotebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB NotebookDao notebookDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public NotebookServlet() {
     //   super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thepath = "/"+request.getPathInfo();
		String[] pathelements = thepath.split("/");
		//if(pathelements[1]=="notebook"){
		if(pathelements.length<=2)
		{
			request.setAttribute("notebooks", notebookDao.getAllNotebooks());
			request.getRequestDispatcher("/notebook.jsp").forward(request, response);
		}else{
			request.setAttribute("notebooks", notebookDao.getNotebookByID(pathelements[2]));
			request.getRequestDispatcher("/notebook2.jsp").forward(request, response);
		}
	//	}
	}

	 @Override
	    protected void doPost(
	        HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	 String thepath = request.getPathInfo();
	    	 String[] pathelements = thepath.split("/");
	    	 
	    	 String title = pathelements[1];
	         String id = pathelements[3];
	         //if(grade.matches("^[ABCDabcd][+-]?|[EFWIefwi]$"))
	         //{
	        
	         if (title != null){
	             notebookDao.persist(new Notebook(title,id));
	         	
	         }
	         
	         //}else{
	         // 	response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	         
	        // }

	     }
	 
	    @Override
	    protected void doPut(
	        HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        String thepath = request.getPathInfo();
	   	 String[] pathelements = thepath.split("/");
	   	 
	   	 	String title = pathelements[1];
	        String id = pathelements[3];
	        
	        if (title != null){
	            notebookDao.persist(new Notebook(title, id));
	        	
	        }

	    }
	    
	    
	    @Override
	    protected void doDelete(
	    		HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	      String thepath = request.getPathInfo();
	  	  String[] pathelements = thepath.split("/");
	  	  if(pathelements.length >1){
	  		String id = pathelements[1];
	  	 
	        if (id != null){
	        	final int myresult;
	        	myresult = notebookDao.deleteNotebook(id);
	        	if(myresult > 0 )
	        	{
	        		//really I want to do nothing and just result in an OK response
	        	}else{
	        		response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        	}
	        }
	  	  }
	    }

	   

}
