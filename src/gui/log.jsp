<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="119"><tbody><tr><td align="center">
<table cellpadding="4" cellspacing="1" border="0" width="119">
   <tbody>
     <tr> 
       <td align="center" valign="top" bgcolor="#CCCCCC">
	   
	   <% if( session.getAttribute("userName") != null ) { %>
	   
		<form method="post" action="logoff.jsp">
		  <table width="100%" border="0" cellspacing="0" cellpadding="2" class="smalltext">
			<tbody>
			  <tr>
				<td>Bienvenue <%= session.getAttribute("userName") %></td>
			  </tr>
				
			  <tr> 
				<td>
				<input type="submit" name="signout" value="Signout" class="userboxinput">
			</td>
			  </tr>
		  </table>
		</form>
		
       <% } else {
       %>

		<form method="post" action="logon.jsp">
		  <table width="100%" border="0" cellspacing="0" cellpadding="2" class="smalltext">
			<tbody><tr>
			  <td>Login:</td>
			  <td>
				<input type="text" name="login" maxlength="100" size="10" class="userboxinput">
			  </td>
			</tr>
		
			<tr> 
			  <td>Pass:</td>
			  <td>
				<input type="password" name="password" maxlength="30" size="10" class="userboxinput">
			  </td>
			</tr>
			<tr> 
			  <td>&nbsp;</td>
			  <td>
				<input name="signin" type="submit" value="Signin" class="userboxinput">
			  </td>
			</tr>
		
			<tr>
			  <td>&nbsp;</td>
			  <td>
			  [<a href="<%= response.encodeURL("index.jsp?pg=teacher/subscribe.jsp") %>" >S'enregistrer</a>]</td>
			</tr>
		  </tbody></table>
		</form>
		<% } %>

     </td>
   </tr>
</tbody></table>
</td></tr></tbody></table>