<%@ page language="java" contentType="text/x; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,spiralBound.Backpack"%>   
<% 
@SuppressWarnings("unchecked") 
ArrayList<Backpack> configuration = (ArrayList<Backpack>) request.getAttribute("config");
	Backpack bp = configuration.get(0);
	for(Backpack backpack : configuration){
	String typeof = request.getAttribute("type").toString();%>
<%=backpack.getSelfPort() %> 
<%=typeof %>
<%} %>
Testing to make sure this displays