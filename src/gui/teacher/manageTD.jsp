<!--
<link rel="stylesheet" href="../resources/L5.css">
-->


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td width="100%" align="right" valign="middle"> 
      <span class="pagetitle"><br/>
        GERER VOS ENSEIGNEMENTS</span>  
      </td>
    </tr>
  </tbody>
</table>
<br>




<!---  Section  --->
<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="100%">
  <tbody>
    <tr>
      <td align="center">
      <table cellpadding="4" cellspacing="1" border="0" width="100%">
      <tbody>
        <tr>
          <td width="33%" align="middle" valign="middle" bgcolor="#CC9966" class="titleActive">
          <b>Mes TDs</b>
		    </td>
          <td width="33%" align="middle" valign="middle" bgcolor="#003366" class="title">
		    <a href="<%= response.encodeURL("index.jsp?pg=teacher/manageEx.jsp") %>" class="menumgr"><b>Mes Exercices</b></a>
          </td>
		    <td width="33%" align="middle" valign="middle" bgcolor="#003366" class="title">
		    <a href="<%= response.encodeURL("index.jsp?pg=teacher/manageSubject.jsp") %>" class="menumgr"><b>Mes enseignements</b></a>
          </td>
        </tr>
      </tbody>
      </table>
	  </td>
    </tr>
  </tbody>
</table>
<br>

<!------------------------------------- DEBUT LISTING TD ----------------------------------------->
<%

/*Enumeration listing = une enumeration;

while(listing.hasMoreElements())
{  
  String listing = (String)listing.nextElement();
}
*/

boolean light = true;
String color = "#DDDDDD";
for( int i=0; i<10; i++)
{
  if( light )
  {
    color = "#DDDDDD";
	light = !light;
  }
  else
  {
    color = "#AAAAAA";
	light = ! light;
  }
%>

<!-- Result <%= i %> -->
<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="100%">
  <tbody>
    <tr>
      <td align="center">
      <table cellpadding="4" cellspacing="1" border="0" width="100%">
          <tbody>
            <tr bgcolor="<%= color %>" > 
              <td width="80%" align="left" valign="top" class="text">
			  TD <%= i %> - Titre<br/>
			  <span class="description">Description</span></td>
              <td width="20%" align="center" valign="top" class="text">
			  [<a href="<%= response.encodeURL("index.jsp?pg=TD/display.jsp?mode=PDF") %>" >PDF</a>]<br>
              [<a href="<%= response.encodeURL("index.jsp?pg=TD/display.jsp?mode=HTML") %>">HTML</a>]<br>
              [Modifier]<br>
              [Supprimer]</td>
            </tr>
          </tbody>
      </table>
	  </td>
    </tr>
  </tbody>
</table>
<br>
<% } %>


<!---------------------------------------- FIN LISTING TD ----------------------------------------->
