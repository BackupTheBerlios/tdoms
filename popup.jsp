<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%
String pg = request.getParameter("pg");
if(pg == null) pg = "news.html";

%>

<html>
<head>
<title>TD Online Management Sytem &copy;</title>

<!--<link rel="icon" href="favicon.ico">-->

<link href="resources/L5.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>


<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
<tbody>
 <tr>
  <td width="15" height="100%" align="left" valign="top"><img src="resources/spacer.gif" width="15" height="1"></td>
  <td width="100%" height="100%" align="left" valign="top" class="text">

  <jsp:include page="<%= pg %>" />

  </td>
  <td width="15"><img src="resources/spacer.gif" width="15" height="1"></td>
 </tr>
</tbody></table>

</body></html>
