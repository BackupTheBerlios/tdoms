<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>template example</title>

<!--<link rel="icon" href="favicon.ico">-->

<link href="resources/L5.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>

<!-- bgcolor="#336699" -->
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td align="left" valign="top" width="128"> 
      <table width="128" border="0" cellspacing="0" cellpadding="0">
        <tbody><tr>
              <td width="128" height="55" align="left" valign="top">mettre petit logo</td>
        </tr>
        <tr>
              <td align="left" valign="top">&nbsp;</td>
        </tr>
        <tr>
              <td align="right" valign="top"> 

<!----------------------------- DEBUT LOGIN/LOGOUT  ---------------------------->
<jsp:include page="login.html" flush="true" />
<!----------------------------- FIN LOGIN/LOGOUT ------------------------------->

<br>

<!----------------------------------  MENU  ------------------------------------>
<jsp:include page="stdmenu.html" flush="true" />
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
<jsp:include page="news.html" flush="true"/>
<!---------------------------- FIN ZONE PAGE ---------------------------------------->

<br>

                  </td>
                <td width="15"><img src="resources/spacer.gif" width="15" height="1"></td>
              </tr>
            </tbody></table>
          </td>

        </tr>
        <tr><td><center><b>L5 Management</b></center>


<br>
<br>
<center>
<small> blah blah blah<br>
</small>
</center></td></tr>
      </tbody></table>
    </td>
  </tr>
</tbody></table>



</body></html>