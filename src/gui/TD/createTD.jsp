<jsp:include page="../checklogin.jsp" />
<!--
<link href="../resources/L5.css" rel="stylesheet" type="text/css">
-->



<SCRIPT LANGUAGE="JavaScript">
<!--
function showPopUp(url) {
reWin = window.open('popup.jsp?pg=' + url,'_blank',
'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,'
+'width=600,height=700,top=100,left=100');
}

function goTo(url) {
window.location = url;
}
-->
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td width="100%" align="right" valign="middle"> 
      <span class="pagetitle"><br/>
        Cr&eacute;er un nouveau TD</span>
      </td>
    </tr>
  </tbody>
</table>
<br>

<!------------------------------------- DEBUT EDIT ----------------------------------------->

<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="100%">
  <tbody>
    <tr>
      <td align="center">
      <table cellpadding="4" cellspacing="1" border="0" width="100%">
      <tbody>
        <tr bgcolor="#CCCCCC"> 
              <td colspan="2" align="center" valign="top">
			  <form method="post" action="createTD">
                  <table border="0" cellspacing="2">
                    <tr>
                      <td><input name="tdTitle" type="text" class="userbox" value="Titre du TD" size="20" maxlength="40"></td>
                    </tr>
                    <tr>
                      <td><select name="subject" class="userbox">
                          <option selected>Calcul Formel</option>
                          <option>Java</option>
                          <option>C++</option>
                          <option>Optimisation Combinatoire</option>
                        </select>
                        <select name="section" class="userbox">
                          <option selected>Liscence Informatique</option>
                          <option>Ma&icirc;trise Informatique</option>
                          <option>DEA Informatique</option>
                          <option>DESS Informatique</option>
                          <option>Liscence EEA</option>
                          <option>Ma&icirc;trise EEA</option>
                          <option>DEA EEA</option>
                          <option>DESS EEA</option>
                        </select></td>
                    </tr>
                    <tr>
                      <td><input name="data[keywords]" type="text" class="userbox" value="Mots-cl&eacute;s" size="40" maxlength="80"></td>
                    </tr>
                    <tr>
                      <td><textarea name="data[description]" cols="40" rows="2" class="userbox">Description</textarea></td>
                    </tr>
                    <tr>
                      <td>
					       <input name="searchTD" type="button" class="userbox" onClick="showPopUp('TD/search.jsp?mode=ex')" value="Rechercher un exercice">
                      <input name="createTD" type="button" class="userbox" onClick="showPopUp('TD/createEx.jsp')" value="Cr&eacute;er un exercice"></td>
                    </tr>
                    <tr>
                      <td class="text">Synopsis des exercices:<br/><textarea name="data[synopsis]" cols="80" rows="10" readonly="readonly" class="userbox" id="synopsis"></textarea></td>
                    </tr>
                    <tr>
                      <td align="right"><input name="input[validateTD]" type="submit" class="userbox" id="input[validateTD]" value="OK">
                        <input name="input[Cancel]" type="button" class="userbox" id="input[Cancel]" onClick="goTo('<%= response.encodeURL("index.jsp?pg=teacher/welcome.jsp") %>')" value="Annuler"></td>
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