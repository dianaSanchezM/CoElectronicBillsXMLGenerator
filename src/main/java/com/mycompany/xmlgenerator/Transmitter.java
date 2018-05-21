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
public class Transmitter implements Element{
    private String customerAccount;
    private String aditionalAccount;
    private String  registrationName;

    public Transmitter(String customerAccount, String aditionalAccount, String registrationName) {
        this.customerAccount = customerAccount;
        this.aditionalAccount = aditionalAccount;
        this.registrationName = registrationName;
    }
    
    @Override
    public String generateXML() {
        return "<cac:AccountingSupplierParty>\n" +
"	<cbc:CustomerAssignedAccountID>"+customerAccount+"</cbc:CustomerAssignedAccountID>\n" +
"	<cbc:AdditionalAccountID>"+aditionalAccount+"</cbc:AdditionalAccountID>\n" +
"	<cac:Party>\n" +
"		<cac:PartyLegalEntity>\n" +
"			<cbc:RegistrationName><![CDATA["+registrationName+"]]></cbc:RegistrationName>\n" +
"		</cac:PartyLegalEntity>\n" +
"	</cac:Party>\n" +
"</cac:AccountingSupplierParty>";
    }
    
}
