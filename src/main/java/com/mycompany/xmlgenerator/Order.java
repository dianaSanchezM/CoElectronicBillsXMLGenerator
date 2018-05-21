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
public class Order implements Element{
    private String name;
    private String amount;
    private String num;

    public Order(String name, String amount, String num) {
        this.name = name;
        this.amount = amount;
        this.num = num;
    }
    
    @Override
    public String generateXML() {
        return "<ext:UBLExtensions>\n" +
"	<ext:UBLExtension>\n" +
"		<ext:ExtensionContent>\n" +
"			<sac:AdditionalInformation>\n" +
"				<sac:AdditionalMonetaryTotal>\n" +
"					<cbc:ID>"+num+"</cbc:ID>\n" +
"					<cbc:PayableAmount currencyID=\""+name+"\">"+amount+"</cbc:PayableAmount>\n" +
"				</sac:AdditionalMonetaryTotal>\n" +
"			</sac:AdditionalInformation>\n" +
"		</ext:ExtensionContent>\n" +
"	</ext:UBLExtension>\n" +
"</ext:UBLExtensions>";
    }
    
}
