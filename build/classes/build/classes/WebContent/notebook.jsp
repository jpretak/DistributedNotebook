<%@ page language="java" contentType="text/xml;charset=utf-8"%>
<%@page import="java.util.*,spiralBound.NotebookA"%>
<xml>
	<notebook-list>
	<%
		@SuppressWarnings("unchecked") 
	            List<NotebookA> notebooks = (List<NotebookA>)request.getAttribute("notebooks");
	            if (notebooks != null) {
	                for (NotebookA notebook : notebooks) {
	%>
                    <notebook> 
                    	<id><%= notebook.getID() %></id>
                    	<title><%= notebook.getTitle() %></title>
                    </notebook> <%
                }
            }
                %>
	</notebook-list>   
</xml>