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
public class Reference  implements Element{ 
    private String referenceId;
    private String documentCode;

    public Reference(String referenceId, String documentCode) {
        this.referenceId = referenceId;
        this.documentCode = documentCode;
    }
    
    @Override
    public String generateXML() {
        return "<cac:DespatchDocumentReference>\n" +
"	<cbc:ID>"+referenceId+"</cbc:ID>\n" +
"	<cbc:DocumentTypeCode>"+documentCode+"</cbc:DocumentTypeCode>\n" +
"</cac:DespatchDocumentReference>";
    }
    
}
