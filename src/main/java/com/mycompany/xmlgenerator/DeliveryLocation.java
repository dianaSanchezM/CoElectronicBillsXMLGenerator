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
public class DeliveryLocation implements Element{
    private String address;
    private String postalCode;
    private String city;

    public DeliveryLocation(String address, String postalCode, String city) {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }
    
    @Override
    public String generateXML() {
        return "<cac:DeliveryTerms>\n" +
"	<cac:DeliveryLocation >\n" +
"		<cac: Address>\n" +
"			<cbc:StreetName>"+address+"</cbc:StreetName>\n" +
"			<cbc:CitySubdivisionName/>\n" +
"			<cbc:CityName>"+city+"</cbc:CityName>\n" +
"			<cbc:PostalZone>"+postalCode+"</ cbc:PostalZone>\n" +
"		</cac:Address>\n" +
"	</cac:DeliveryLocation >\n" +
"</cac:DeliveryTerms>";
    }
    
}
