<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%--@ include file = "checklogin.jsp" --%>
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


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td align="left" valign="top" width="128"> 
      <table width="128" border="0" cellspacing="0" cellpadding="0">
        <tbody><tr>
              <td width="128" height="55" align="center" valign="middle"><img src="resources/logo.gif" width="100" height="100" /></td>
        </tr>
        <tr>
              <td align="left" valign="top">&nbsp;</td>
        </tr>
        <tr>
              <td align="right" valign="top"> 

<!----------------------------- DEBUT LOGIN/LOGOUT  ---------------------------->
<jsp:include page="log.jsp" />
<!----------------------------- FIN LOGIN/LOGOUT ------------------------------->

<br>

<!----------------------------------  MENU  ------------------------------------>
<jsp:include page="menu.jsp" />
<!-------------------------------- FIN MENU ------------------------------------>

                <br>


          </td>
        </tr>
      </tbody></table>
    </td>
    <td align="left" valign="top">

      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
          <td height="100%" width="100%" align="left" valign="top"> 
            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
              <tbody>
			  <tr>
                <td width="15" height="100%" align="left" valign="top"><img src="resources/spacer.gif" width="15" height="1"></td>
                <td width="100%" height="100%" align="left" valign="top" class="text">
				
<!---------------------------- DEBUT ZONE PAGE -------------------------------------->
<jsp:include page="<%=pg %>" />
<!---------------------------- FIN ZONE PAGE ---------------------------------------->

<br>


                  </td>
                <td width="15"><img src="resources/spacer.gif" width="15" height="1"></td>
              </tr>
            </tbody></table>
          </td>

        </tr>
        <tr><td><br/><br/><center><b>TD Online Management System &copy;</b></center>


<br>
<br>
<center>
<small>One to rule them all...<br>
</small>
</center></td></tr>
      </tbody></table>
    </td>
  </tr>
</tbody></table>



</body></html>