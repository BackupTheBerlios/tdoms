<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!--
<link href="../resources/L5.css" rel="stylesheet" type="text/css">
-->


<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td align="left" valign="top">&nbsp;</td>
      <td width="100%" align="right" valign="middle"> 
      <span class="pagetitle"><br/>S'inscrire</span>
      </td>
    </tr>
  </tbody>
</table>
<br>

<!------------------------------------- DEBUT NEWS ----------------------------------------->
<!-- News 1 -->
<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="100%">
  <tbody>
    <tr>
      <td align="center">
      <table cellpadding="4" cellspacing="1" border="0" width="100%">
      <tbody>
        <tr bgcolor="#CCCCCC"> 
              <td colspan="2" align="center" valign="top">
		<html:form action="/subscribe" name="subscribe" type="account.SubscribeForm">
			      <table width="350" border="0" cellspacing="2" class="text">
                    <tr>
                      <td width="69">mail:</td>
                      <td width="79">
<html:text property="mail" maxlength="100" size="15" styleClass="userboxinput" />
<html:hidden property="ref" value="%2F" />
					</td>
                      <td width="12">@</td>
                      <td width="172">
<html:select property="domain" styleClass="userboxinput">
	<html:option value="univ-mlv.fr">univ-mlv.fr</html:option>
	<html:option value="igm.univ-mlv.fr">igm.univ-mlv.fr</html:option>
	<html:option value="monge.univ-mlv.fr">monge.univ-mlv.fr</html:option>
</html:select>
				      </td>
                    </tr>
                    <tr>
                      <td>login d&eacute;sir&eacute;</td>
                      <td colspan="3">
<html:text property="login" maxlength="100" size="15" styleClass="userboxinput"/>
					  </td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td colspan="3">
<html:submit property="validate" value="Valider" styleClass="userboxinput" />
					  </td>
                    </tr>
                  </table>
				</html:form>
		  </td>
        </tr>
      </tbody>
      </table>
	  </td>
    </tr>
  </tbody>
</table>
<br/>


<table cellpadding="0" cellspacing="0" border="0" bgcolor="#000000" width="100%">
  <tbody>
    <tr>
      <td align="center">
	  <table cellpadding="4" cellspacing="1" border="0" width="100%">
      <tbody>
        <tr>
              <td align="left" valign="middle" bgcolor="#003366" class="title">
   	      <b>Comment proc&eacute;der ?</b>
		  </td>

        </tr>
        <tr bgcolor="#AAAAAA">
		      <td colspan="2" align="left" valign="top" class="text">
- Entrez votre login ( la premi&egrave;re partie de votre addresse email )<br>
- S&eacute;lectionnez le domaine auquel vous appartenez<br>
- Entrer le login que vous d&eacute;sirez (ce login servira pour entrer dans votre compte)<br>
- Valider vos informations</td>
        </tr>
      </tbody>
      </table>
	  </td>
    </tr>
  </tbody>
</table>
