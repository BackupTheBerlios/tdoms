<%
  if (session.getAttribute("loggedIn")==null) {
%>
    <jsp:forward page="login.jsp"/>
<%
  }
  else {
%> 

<html>
<head>
<title>Main Menu</title>
</head>
<body>

<b>Main Menu</b>
<br><a href=logout.do>Log Out</a>
<br><a href=viewSecret.do>View Company Secrets</a>

</body>
</html>

<%
  }
%>
