<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
  <body bgcolor="white">
   
<xsl:apply-templates select="keywords"/>

<table width="500">
<td>
<xsl:apply-templates select="exo"/>
  
<xsl:apply-templates select="text/part"/>
</td> 
   
</table> 
</body>
</html>
</xsl:template>

<xsl:template match="title">
  <H2><font color="orange"><b><xsl:apply-templates/></b></font><br/></H2>
</xsl:template>

<xsl:template match="text/part">
  <li>
  <font size="4"><xsl:apply-templates/></font>
  <br/><br/>
  </li>  
</xsl:template>

<xsl:template match="text">
  <ol>
  <xsl:apply-templates/>
  </ol>
</xsl:template>

<xsl:template match="keywords">
   <!--Ignored tag-->
</xsl:template>

<xsl:template match="correction">
   <!--Ignored tag-->
</xsl:template>

</xsl:stylesheet>