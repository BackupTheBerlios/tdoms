<!---
<link rel="stylesheet" href="../resources/L5.css">
-->

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td width="100%" align="right" valign="middle"> 
      <span class="pagetitle"><br/>
        GERER VOTRE COMPTE</span>  
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
          <td width="33%" align="middle" valign="middle" bgcolor="#003366" class="title">
          <a href="<%= response.encodeURL("index.jsp?pg=teacher/manageTD.jsp") %>" class="menumgr"><b>Mes TDs</b></a>
		  </td>
          <td width="33%" align="middle" valign="middle" bgcolor="#CC9966" class="titleActive">
		  <b>Mes Exercices</b>
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


<!------------------------------------- DEBUT LISTING EX ----------------------------------------->
<%

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
            <tr bgcolor="<%= color %>"> 
              <td width="80%" align="left" valign="top" class="text">
			  Exercice <%= i %> - Titre<br/>
			  <span class="description">Mots-clés</span>
		  </td>
              <td width="20%" align="center" valign="top" class="text">
			  [<a href="#">Modifier</a>]</td>
            </tr>
          </tbody>
      </table>
	  </td>
    </tr>
  </tbody>
</table>
<br>
<% } %>


<!---------------------------------------- FIN LISTING EX ----------------------------------------->
