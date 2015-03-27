<%@ page language="java" contentType="text/xml;charset=utf-8"%>
<%@page import="java.util.*,spiralBound.Notebook"%>
<xml>
	<notebook-list>
	<%
@SuppressWarnings("unchecked") 
            List<Notebook> notebooks = (List<Notebook>)request.getAttribute("notebooks");
            if (notebooks != null) {
                for (Notebook notebook : notebooks) { %>
                    <notebook> 
                    	<id><%= notebook.getID() %></id>
                    	<title><%= notebook.getTitle() %></title>
                    </notebook> <%
                }
            }
                %>
	</notebook-list>   
</xml>