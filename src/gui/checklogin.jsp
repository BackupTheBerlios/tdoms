<%
 //Validate if the user has logged on
 if (session.getAttribute("userName")==null) {
           response.sendRedirect(response.encodeRedirectURL("index.jsp"));
 }
%>
