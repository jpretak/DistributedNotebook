<%@ page language="java" contentType="text/xml;charset=utf-8"%>
<%@page import="java.util.*,spiralBound.Note"%>
<xml>
	<%
@SuppressWarnings("unchecked") 
           Note note = (Note)request.getAttribute("notes");
            if (note != null) {
     %>
                    		<note>
                    			<id><%= note.getID() %></id>
                    			<content><%= note.getContents() %></content>
                    		</note>
                    		<%}
                    	%>
  
</xml>