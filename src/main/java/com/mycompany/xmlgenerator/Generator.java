/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xmlgenerator;

import spark.*;
import spark.Spark;

/**
 *
 * @author diana
 */
public class Generator {
    private static String factura;
    public static void main(String[] args){
        Spark.get("/coElectronicBills", new Route(){
            @Override
            public Object handle(Request request, Response response) throws Exception {
                factura ="<cbc:UBLVersionID>2.0<cbc:UBLVersionID>\n" +
                        "<cbc:CustomizationID>2.0</cbc:CustomizationID>\n"+
                        "<cbc:ID>"+request.queryParams("signatureId")+"</cbc:ID>\n"+
                        "<cbc:IssueDate>"+request.queryParams("issueDate")+"</cbc:IssueDate>\n"+
                        "<cbc:IssueTime>"+request.queryParams("issueTime")+"</cbc:IssueTime>\n"+
                        "<cbc:InvoiceTypeCode>01</cbc:InvoiceTypeCode>\n"+
                        "<cbc:DocumentCurrencyCode>"+request.queryParams("currency")+"</cbc:DocumentCurrencyCode>\n"+
                        new ExpireDate(request.queryParams("expireDate")).generateXML()+"\n"+
                        new DigitalSignature(request.queryParams("signature"), request.queryParams("certificate"), 
                                request.queryParams("signatoryParty"), request.queryParams("partyId"), 
                                request.queryParams("partyName"), request.queryParams("uri"), request.queryParams("digestValue"),
                                request.queryParams("signatureValue")).generateXML()+"\n"+
                        new Transmitter(request.queryParams("trasmitterAccount"), request.queryParams("trasmiterAditional"),
                                request.queryParams("registrationName")).generateXML()+"\n"+
                        new DeliveryLocation(request.queryParams("address"), request.queryParams("postalCode"), 
                                request.queryParams("city")).generateXML()+"\n"+
                        new Customer(request.queryParams("customerAccount"), request.queryParams("aditionalAccount"), 
                                request.queryParams("customerRegistration")).generateXML()+"\n"+
                        new Reference(request.queryParams("referenceId"), request.queryParams("documentCode")).generateXML()+"\n"+
                        new Product(request.queryParams("numItem"), request.queryParams("quantity"),
                                request.queryParams("amount"), request.queryParams("description"), request.queryParams("priceAmount"),
                                request.queryParams("alternativePrice"), request.queryParams("taxExemption"), 
                                request.queryParams("name")).generateXML()+"\n"+
                        new Order(request.queryParams("name"), request.queryParams("priceAmount"), request.queryParams("numItem")).generateXML()
                    
            ;
                System.out.println(factura);
            return factura;}  
        });
    }
   
}
