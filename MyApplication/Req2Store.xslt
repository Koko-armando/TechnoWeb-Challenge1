<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
    <h2>Nombre total de quantité par Produit</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>ID Produit</th>
        <th>Produit Name</th>
		    <th>Quantité</th>
      </tr>
      <xsl:for-each select="//item">
      <tr>
        <td><xsl:value-of select="@item-id" /></td>
		    <td><xsl:value-of select="./name/text()" /></td>
        <td>
          <xsl:variable name="sum" select="0"/>
          <xsl:for-each select=".//stock">
            <xsl:variable name="sum" select="$sum + number(./stocklevel/text())"/>
          </xsl:for-each>
          <xsl:value-of select="$sum" /></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>