<%
String logMode = request.getParameter("logMode");
if(logMode == null) logMode = "unlogged";

/*
String sign = request.getParameter("input[sign]");
if( sign != null ) sign = "Signout";
if( sign.equals("Signout") )
{
  session.removeAttribute("userMode");
  session.removeAttribute("name");
}
if( sign.equals("Signin") )
{
  session.setAttribute("userMode", "teacher");
  session.setAttribute("name", request.getParameter("data[name]") );
}
*/
%>

<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="119"><tbody><tr><td align="center">
<table cellpadding="4" cellspacing="1" border="0" width="119">
   <tbody>
     <tr> 
       <td align="center" valign="top" bgcolor="#CCCCCC">
	   
	   <% if( logMode.equals("logged") ) { %>
      <%-- if( sign.equals("Signin") ) { --%>
	   
		<form method="post" action="index.jsp?logMode=unlogged">
		  <table width="100%" border="0" cellspacing="0" cellpadding="2" class="smalltext">
			<tbody>
			  <tr>
				<td>Bienvenue <%= session.getAttribute("name") %></td>
			  </tr>
				
			  <tr> 
				<td>
				<input type="submit" name="input[sign]" value="Signout" class="userboxinput">
			</td>
			  </tr>
		  </table>
		</form>
		
       <%-- if not logged --%>
       <% } else { %>
       <%--
       }
       if( sign.equals("Signout") )
       {
       --%>

		<form method="post" action="index.jsp?logMode=logged&userMode=teacher&pg=teacher/welcome.jsp">
		  <table width="100%" border="0" cellspacing="0" cellpadding="2" class="smalltext">
			<tbody><tr>
			  <td>Login:</td>
			  <td>
				<input type="text" name="data[name]" maxlength="100" size="10" class="userboxinput">
			  </td>
			</tr>
		
			<tr> 
			  <td>Pass:</td>
			  <td>
				<input type="password" name="data[password]" maxlength="30" size="10" class="userboxinput">
			  </td>
			</tr>
			<tr> 
			  <td>&nbsp;</td>
			  <td>
				<input name="input[sign]" type="submit" value="Signin" class="userboxinput">
			  </td>
			</tr>
		
			<tr>
			  <td>&nbsp;</td>
			  <td>
			  [<a href="index.jsp?pg=teacher/subscribe.jsp">S'enregistrer</a>]</td>
			</tr>
		  </tbody></table>
		</form>
		<% } %>

     </td>
   </tr>
</tbody></table>
</td></tr></tbody></table>