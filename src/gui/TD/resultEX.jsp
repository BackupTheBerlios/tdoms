<!--
<link href="../resources/L5.css" rel="stylesheet" type="text/css">
-->

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td width="100%" align="right" valign="middle"> 
      <span class="pagetitle"><br/>Résultat de la recherche</span>
      </td>
    </tr>
  </tbody>
</table>
<br>

<!------------------------------------- DEBUT RESULTAT ----------------------------------------->
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
			  [<a href="TD/display.jsp?mode=HTML">Voir</a>] [<a href="#">Ajouter</a>]
			  </td>
            </tr>
          </tbody>
      </table>
	  </td>
    </tr>
  </tbody>
</table>
<br>
<% } %>

<!---------------------------------------- FIN RESULTAT ----------------------------------------->
