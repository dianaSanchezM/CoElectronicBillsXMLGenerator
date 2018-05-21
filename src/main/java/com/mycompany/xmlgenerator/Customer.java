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
public class Customer implements Element{
    private String customerAccount;
    private String customerAdditional;
    private String customerRegistration;

    public Customer(String customerAccount, String customerAdditional, String customerRegistration) {
        this.customerAccount = customerAccount;
        this.customerAdditional = customerAdditional;
        this.customerRegistration = customerRegistration;
    }
    
    @Override
    public String generateXML() {
        return "<cac:AccountingCustomerParty>\n" +
"	<cbc:CustomerAssignedAccountID>"+customerAccount+"</cbc:CustomerAssignedAccountID>\n" +
"	<cbc:AdditionalAccountID>"+customerAdditional+"</cbc:AdditionalAccountID>\n" +
"	<cac:Party>\n" +
"           <cac:PartyLegalEntity>\n" +
"               <cbc:RegistrationName><![CDATA["+customerRegistration+"]]></cbc:RegistrationName>\n" +
"           </cac:PartyLegalEntity>\n" +
"	</cac:Party>\n" +
"</cac:AccountingCustomerParty>";
    }
    
}
