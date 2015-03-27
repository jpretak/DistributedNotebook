package spiralBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "NoteServlet", urlPatterns={"/notes/*"})
public class NoteServlet extends HttpServlet {
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
		System.out.println(thepath);
		String[] pathelements = thepath.split("/");
		if(pathelements.length<=2)
		{
			request.setAttribute("notebooks", notebookDao.getAllNotebooks());
			request.getRequestDispatcher("/notebook.jsp").forward(request, response);
		}else if(pathelements.length==3){
			request.setAttribute("notebooks", notebookDao.getNotebookByID(pathelements[2]));
			request.getRequestDispatcher("/notebook2.jsp").forward(request, response);
		}else{
			List<Notebook> NB = notebookDao.getNotebookByID(pathelements[2]);
			Note thisnote = NB.get(0).getNoteById(pathelements[3]);
			
			request.setAttribute("notes", thisnote);
			request.getRequestDispatcher("/note.jsp").forward(request, response);
		}
	//	}
	}

	 @Override
	    protected void doPost(
	        HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	 String thepath = request.getPathInfo();
	    	 String[] pathelements = thepath.split("/");
	    	 
	    	 String id = pathelements[2];
	         String nid = pathelements[3];
	         System.out.println("ID is: " +id);
	         System.out.println("nid is: " + nid);
	         //if(grade.matches("^[ABCDabcd][+-]?|[EFWIefwi]$"))
	         //{
	         StringBuilder buffer = new StringBuilder();
	         BufferedReader reader = request.getReader();
	         String line;
	         while ((line = reader.readLine()) != null) {
	             buffer.append(line);
	         }
	         String data = buffer.toString();
	         
	         List<Notebook> N = notebookDao.getNotebookByID(id);
	         Notebook notebook = N.get(0);
	         System.out.println(notebook.toString());
	         notebook.addNote(nid, data);
	         if (id != null){
	             notebookDao.persist(notebook);
	         	
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