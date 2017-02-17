<%@ include file="header.jsp" %>

<%@ page import="java.util.List"%>
<% List<String> eList = (List)session.getAttribute("users");%>

	
		<h1>Hello Hack!</h1>
		${message}
		<h3>Users:</h3>
		
		<ul>
		<% for(int i=0; i< eList.size(); i++) { %>
			<li><%=eList.get(i)%></li>
		<% } %>
		</ul>
<%@ include file="footer.jsp" %>
