<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:umlv="http://www.univ-mlv.fr/"
	version="1.0">

<!--Gobal Document template application-->
<xsl:template match="/">
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="1cm" margin-right="8cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body">
          <fo:block>
	    <xsl:apply-templates/>
          </fo:block>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
</xsl:template>


<!--One by One template description-->





<xsl:template match="title">

<fo:block   color="orange" 
	    font-size="22pt" 
            font-family="any " 
            line-height="22pt"
            white-space-collapse="false"
            text-align="left">
    <xsl:apply-templates/>
</fo:block >  
  
  <fo:block color="white" >
  separator
  </fo:block>
  
</xsl:template>

<xsl:template match="text/part">

  <fo:list-item>
    <fo:list-item-label end-indent="label-end()">
    
        <fo:block>
	  <xsl:number from="text" count="part"/>	   
        </fo:block>
        
    </fo:list-item-label>
    <fo:list-item-body start-indent="body-start()">
      <fo:block font-size="11pt" 
            font-family="any " 
            line-height="11pt"
            text-align="justify">
        <xsl:apply-templates/>	
      </fo:block>
      <fo:block color="white">
	  separator
      </fo:block> 
    </fo:list-item-body>
  </fo:list-item>
  

</xsl:template>

<xsl:template match="text">  

<fo:list-block >
       <xsl:apply-templates/>  
</fo:list-block>
</xsl:template>


<xsl:template match="keywords">
   <!--Ignored tag-->
</xsl:template>

<xsl:template match="correction">
   <!--Ignored tag-->
</xsl:template>


<!--End of StyleSheet-->
</xsl:stylesheet>