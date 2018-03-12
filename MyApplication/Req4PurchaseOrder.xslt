<?xml version = "1.0" encodage = "UTF-8" ?>
<xsl:stylesheet version = "1.0" xmlm.xsl="http://www.w3.org/1999/xsl//Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h2>Liste des Commandes Chronologiquement</h2>
        <ul>
          <xsl:for_each select = "//order">
            <xsl:sort select="@orderDate"/>
            <xsl:variable name="date" select="@orderDate"/>
            <li> Commande pour <xsl:value_of select = "./p:carriageTo/p:name/text()" />, faite le <xsl:value_of select = "$date" /> </li>
            </xsl:for_each>
        </ul>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>