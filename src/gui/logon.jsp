<%

String userMode = (String) session.getAttribute("userMode");
if(userMode == null){
  userMode = "teacher";
  if(userMode !=null ) session.setAttribute("userMode",userMode);
}

String userName = (String) session.getAttribute("userName");
if(userName == null){
  userName = request.getParameter("login");
  if(userName !=null ) session.setAttribute("userName",userName);
}

response.sendRedirect(response.encodeRedirectURL("index.jsp?pg=teacher/manageSubject.jsp"));

%>