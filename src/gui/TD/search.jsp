<!--
<link href="../resources/L5.css" rel="stylesheet" type="text/css">
-->
<%
String mode = request.getParameter("mode");

String result = request.getParameter("hidden[result]");
if(result == null) result = new String("false");

String title = "";
if(mode.equals("ex")) title = "Rechercher un exercice";
if(mode.equals("td")) title = "Rechercher un TD";

%>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td width="100%" align="right" valign="middle"> 
      <span class="pagetitle"><br/><%= title %></span>
      </td>
    </tr>
  </tbody>
</table>
<br>

<!------------------------------------- SEARCH FORM ----------------------------------------->

<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="100%">
  <tbody>
    <tr>
      <td align="center">
      <table cellpadding="4" cellspacing="1" border="0" width="100%">
      <tbody>
        <tr bgcolor="#CCCCCC"> 
              <td colspan="2" align="center" valign="top">
			  <form method="post" action="<%= response.encodeURL("popup.jsp?pg=TD/search.jsp&mode=" + mode ) %>">
           <input type="hidden" name="hidden[result]" value="true">
                  <table width="450" border="0" cellspacing="2">
                  <tr>
                    <td align="left">
					    <select name="[subject]" class="userbox">
                          <option selected>Calcul Formel</option>
                          <option>Java</option>
                          <option>C++</option>
                          <option>Optimisation Combinatoire</option>
                        </select>
                        <select name="[section]" class="userbox">
                          <option selected>Licence Informatique</option>
                          <option>Ma&icirc;trise Informatique</option>
                          <option>DEA Informatique</option>
                          <option>DESS Informatique</option>
                          <option>Licence EEA</option>
                          <option>Ma&icirc;trise EEA</option>
                          <option>DEA EEA</option>
                          <option>DESS EEA</option>
                        </select>
						<select name="[year]" class="userbox">
                          <option selected>2003</option>
                          <option>2002</option>
                          <option>2001</option>
                          <option>2000</option>
                        </select>
					  </td>
					  <td align="right">
                          <input name="input[list]" type="submit" class="userbox" value="Lister">
					  </td>
                  </tr>
				</table>
				</form>
                <form method="post" action="<%= response.encodeURL("popup.jsp?pg=TD/search.jsp&mode="+ mode ) %>" >
                <input type="hidden" name="hidden[result]" value="true">
				  <table width="450">
                     
                  <tr>
                    <td align="left" ><input name="data[keywords]" type="text" class="userbox" value="Mots-cl&eacute;s" size="60" maxlength="80"></td>
                    <td align="right">
                          <input name="input[find]" type="submit" class="userbox" value="Rechercher">
                    </td>
                  </tr>
                </table>
			    </form>
				
		  </td>
        </tr>
      </tbody>
      </table>
	  </td>
    </tr>
  </tbody>
</table>
<br/>
<br/>


<%-- incude code for results --%>
<%
if( mode != null  && result.equals("true") ) {
  if( mode.equals("td") )
  {
%>

<jsp:include page="resultTD.jsp" />

<%
  }
  if( mode.equals("ex") )
  {
%>

<jsp:include page="resultEX.jsp" />

<%
  }
}
%>
