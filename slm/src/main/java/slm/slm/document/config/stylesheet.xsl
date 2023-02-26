<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21.0cm"
                                       margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body margin="2cm"/>
                    <fo:region-after extent="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
            <fo:static-content flow-name="xsl-region-after">
                <fo:block text-align="center">
                    <fo:inline font-size="12pt">Altin Kelmendi © 2023</fo:inline>
                </fo:block>
            </fo:static-content>

                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-size="32pt" font-weight="bold" >
                        <xsl:text>Country Data:</xsl:text>
                    </fo:block>
                    <fo:table>
                        <fo:table-column column-width="50%"/>
                        <fo:table-column column-width="50%"/>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block font-weight="bold">Application:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block><xsl:value-of select="countryData/application"/></fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block font-weight="bold">Data:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block><xsl:value-of select="countryData/data"/></fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block font-weight="bold">Date:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block><xsl:value-of select="countryData/date"/></fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block font-weight="bold">Country:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block><xsl:value-of select="countryData/country"/></fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block font-weight="bold">Capital City:</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="solid black 1px" font-size="20pt" padding="10pt">
                                    <fo:block><xsl:value-of select="countryData/capitalCity"/></fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
