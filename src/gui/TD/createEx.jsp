<!--
<link href="../resources/L5.css" rel="stylesheet" type="text/css">
-->


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td width="100%" align="right" valign="middle"> 
      <span class="pagetitle"><br/>
        Cr&eacute;er un nouvel exercice</span>
      </td>
    </tr>
  </tbody>
</table>
<br>

<!------------------------------------- EDIT EX ----------------------------------------->
<!-- News 1 -->
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
                      <td><textarea name="data[sujet]" cols="80" rows="10" class="userbox" id="synopsis"></textarea></td>
                    </tr>
                    <tr>
                      <td>
					  <input type="file" class="userbox" size="40">
                      <input name="upload[sujetPic]" type="submit" class="userbox" id="upload[subject]" value="T&eacute;l&eacute;charger">
					  </td>
                    </tr>
                    <tr>
                      <td><textarea name="data[correction]" cols="80" rows="10" class="userbox" id="synopsis"></textarea></td>
                    </tr>
                    <tr>
                      <td>
					  <input type="file" class="userbox" size="40">
                      <input name="upload[correctionPic]" type="submit" class="userbox" id="upload[coorection]" value="T&eacute;l&eacute;charger"></td>
                    </tr>
                    <tr>
                      <td align="right"><input name="input[validateTD]" type="submit" class="userbox" id="input[validateTD]" value="OK">
                        <input name="input[Cancel]" type="button" class="userbox" id="input[Cancel]" onClick="window.close();" value="Annuler"></td>
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