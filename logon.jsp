<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
  <html>
    <head>
      <title>Login JSP</title>
    </head>
    <body>
      
      
      <jsp:useBean id="myLogon" scope="session" class="account.LogSession"/>
	
	<jsp:setProperty name="myLogon" property="*"/>
	  
	  <% if( myLogon.getAuthorisation()){
	  String userMode = (String) session.getAttribute("userMode");
	  if(userMode == null){
	  userMode = "teacher";
	  if(userMode !=null ) session.setAttribute("userMode",userMode);
	  }
	  session.setAttribute("userName",myLogon.getLogin());
	  response.sendRedirect(response.encodeRedirectURL("index.jsp?pg=teacher/manageSubject.jsp"));
	  }
	  else{
	  %>
	  <p> Vous n'etes pas enregistré!!!</p>
	  <%}
	  %>