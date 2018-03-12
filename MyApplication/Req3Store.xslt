<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
    <h2>Nombre total de Quantité par Produit</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>ID Produit</th>
        <th>Produit Name</th>
        <th>Entrepot</th>
		    <th>Quantité</th>
      </tr>
      <xsl:for-each select="//item">
        <xsl:variable name="id" select="@item-id">
        <xsl:variable name="name" select="./name/text()">
        <xsl:for-each select="./stock">  
          <tr>
            <td><xsl:value-of select="$id" /></td>
    		    <td><xsl:value-of select="$name" /></td>
            <td><xsl:value-of select="$sum" /></td>
            <td><xsl:value-of select="./stocklevel/text()" /></td> 
          </tr>
        </xsl:for-each>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>