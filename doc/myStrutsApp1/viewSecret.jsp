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
<title>Secret Page</title>
</head>
<body>

The password for our company's bank account is "12345698"

</body>
</html>

<%
  }
%>
