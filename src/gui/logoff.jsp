<%

session.invalidate();
    response.sendRedirect(response.encodeRedirectURL("index.jsp"));

%>