<%@ page language="java" contentType="text/xml;charset=utf-8"%>
<%@page import="java.util.*,spiralBound.Notebook, spiralBound.Note"%>
<xml>
	<%
@SuppressWarnings("unchecked") 
            List<Notebook> notebooks = (List<Notebook>)request.getAttribute("notebooks");
            if (notebooks != null) {
                for (Notebook notebook : notebooks) { %>
                    <notebook> 
                    	<id><%= notebook.getID() %></id>
                    	<title><%= notebook.getTitle() %></title>
                    	<%
                    	//if(notebook.getNotes()!=null){
                    	for(Note note : notebook.getNotes()){ 
                    	%>
                    		<note>
                    			<id><%= note.getID() %></id>
                    			<content><%= note.getContents() %></content>
                    		</note>
                    		<%}
                    	//}%>
                    </notebook> <%
                }
            }
                %> 
</xml>