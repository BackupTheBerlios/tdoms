<%
String userMode = request.getParameter("userMode");
if(userMode == null) userMode = "student";
%>
<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="119">
  <tbody>
    <tr>
      <td align="center">
        <table cellpadding="4" cellspacing="1" border="0" width="119">
          <tbody>
            <tr>
   	                          
              <td align="center" valign="middle" bgcolor="#003366" class="title">
   	          <b>Menu</b></td>
            </tr>
            <tr> 
              <td bgcolor="#CCCCCC" align="left" valign="top">

			  <% if( userMode.equals("teacher") ) { %>

                <table cellpadding="0" cellspacing="1" border="0" width="100%" class="al">
		          <tbody>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=teacher&pg=teacher/manageTD.jsp" class="menu">G&eacute;rer ses enseignements</a></td>
                    </tr>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=teacher&pg=TD/search.jsp&mode=td" class="menu">Visualiser un TD</a></td>
                    </tr>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=teacher&pg=TD/createTD.jsp" class="menu">Cr&eacute;er un TD</a></td>
                    </tr>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=teacher&pg=TD/createEx.jsp" class="menu">Cr&eacute;er un exercice</a></td>
                    </tr>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=teacher&pg=teacher/welcome.jsp" class="menu">Option du compte</a></td>
                    </tr>
		          </tbody>
		        </table>

				<% } if( userMode.equals("admin") ) { %>

			    <table cellpadding="0" cellspacing="1" border="0" width="100%" class="al">
		          <tbody>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=admin" class="menu">Gestion de comptes</a></td>
                    </tr>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=admin" class="menu">Gestion enseignement</a></td>
                    </tr>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=admin" class="menu">Param&egrave;tres serveur</a></td>
                    </tr>
		          </tbody>
		        </table>

                <% } if( userMode.equals("student") ) { %>

			    <table cellpadding="0" cellspacing="1" border="0" width="100%" class="al">
		          <tbody>
			        <tr>
			          <td align="left"><a href="index.jsp?userMode=student&pg=TD/search.jsp" class="menu">Rechercher un TD</a></td>
                    </tr>
		          </tbody>
		        </table>

                <% } %>

			   </td>
            </tr>
          </tbody>
        </table>
	  </td>
    </tr>
  </tbody>
</table>
