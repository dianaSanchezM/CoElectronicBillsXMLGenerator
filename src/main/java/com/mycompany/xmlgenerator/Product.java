/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xmlgenerator;

/**
 *
 * @author diana
 */
public class Product implements Element{
    private String numitem;
    private String quantity;
    private String amount;
    private String description;
    private String priceAmount;
    private String alternativePrice;
    private String taxExemption;
    private String name;

    public Product(String numitem, String quantity, String amount, String description, String priceAmount, String alternativePrice, String taxExemption, String name) {
        this.numitem = numitem;
        this.quantity = quantity;
        this.amount = amount;
        this.description = description;
        this.priceAmount = priceAmount;
        this.alternativePrice = alternativePrice;
        this.taxExemption = taxExemption;
        this.name = name;
    }
    
    @Override
    public String generateXML() {
        return "<cac:InvoiceLine>\n" +
"	<cbc:ID>"+numitem+"</cbc:ID>\n" +
"	<cbc:InvoicedQuantity unitCode=\"CS\">"+quantity+"</cbc:InvoicedQuantity>\n" +
"	<cbc:LineExtensionAmount currencyID=\""+name+"\">"+amount+"</cbc:LineExtensionAmount>\n" +
"	<cac:PricingReference>\n" +
"		<cac:AlternativeConditionPrice>\n" +
"			<cbc:PriceAmount currencyID=\""+name+"\">"+alternativePrice+"</cbc:PriceAmount>\n" +
"			<cbc:PriceTypeCode>01</cbc:PriceTypeCode>\n" +
"		</cac:AlternativeConditionPrice>\n" +
"	</cac:PricingReference>\n" +
"	<cac:TaxTotal>\n" +
"		<cac:TaxSubtotal>\n" +
"			<cac:TaxCategory>\n" +
"				<cbc:TaxExemptionReasonCode>"+taxExemption+"</cbc:TaxExemptionReasonCode>\n" +
"			</cac:TaxCategory>\n" +
"		</cac:TaxSubtotal>\n" +
"	</cac:TaxTotal>\n" +
"	<cac:Item>\n" +
"		<cbc:Description><![CDATA["+description+"]]></cbc:Description>\n" +
"	</cac:Item>\n" +
"	<cac:Price>\n" +
"		<cbc:PriceAmount currencyID=\""+name+"\">"+priceAmount+"</cbc:PriceAmount>\n" +
"	</cac:Price>\n" +
"</cac:InvoiceLine>";
    }
    
}
