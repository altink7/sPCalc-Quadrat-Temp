<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4">
                    <fo:region-body margin="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:table table-layout="fixed" width="100%" border-collapse="collapse">
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-column column-width="20%"/>
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-weight="bold">Application</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-weight="bold">Data</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-weight="bold">Date</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-weight="bold">Country</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-weight="bold">Capital City</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:apply-templates select="countryData"/>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="countryData">
        <fo:table-row>
            <fo:table-cell>
                <fo:block><xsl:value-of select="/application"/></fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block><xsl:value-of select="/data"/></fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block><xsl:value-of select="/date"/></fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block><xsl:value-of select="/country"/></fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block><xsl:value-of select="/capitalCity"/></fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

</xsl:stylesheet>
