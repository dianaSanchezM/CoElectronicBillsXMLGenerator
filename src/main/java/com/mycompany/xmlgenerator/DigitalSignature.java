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
public class DigitalSignature implements Element{
    private String signature;
    private String certificate;
    private String signatoryParty;
    private String partyId;
    private String partyName;
    private String uri;
    private String digestValue;
    private String signatureValue;

    public DigitalSignature(String signature, String certificate, String signatoryParty, String partyId, String partyName, String uri, String digestValue, String signatureValue) {
        this.signature = signature;
        this.certificate = certificate;
        this.signatoryParty = signatoryParty;
        this.partyId = partyId;
        this.partyName = partyName;
        this.uri = uri;
        this.digestValue = digestValue;
        this.signatureValue = signatureValue;
    }
    
    @Override
    public String generateXML() {
        return "<ext:UBLExtensions>\n" +
"	<ext:UBLExtension>\n" +
"		<ext:ExtensionContent>\n" +
"			<ds:Signature Id="+signature+">\n" +
"				<ds:SignedInfo>\n" +
"					<ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments\"/>\n" +
"					<ds:SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#dsa-sha1\"/>\n" +
"					<ds:Reference URI=\"\">\n" +
"						<ds:Transforms>\n" +
"							<ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>\n" +
"						</ds:Transforms>\n" +
"						<ds:DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>\n" +
"						<ds:DigestValue>"+digestValue+"</ds:DigestValue>\n" +
"					</ds:Reference>\n" +
"				</ds:SignedInfo>\n" +
"				<ds:SignatureValue>"+signatureValue+"</ds:SignatureValue>\n" +
"					<ds:KeyInfo>\n" +
"						<ds:X509Data>\n" +
"							<ds:X509Certificate>"+certificate+"\n" +
"						</ds:X509Certificate>\n" +
"					</ds:X509Data>\n" +
"				</ds:KeyInfo>\n" +
"			</ds:Signature>\n" +
"		</ext:ExtensionContent>\n" +
"	</ext:UBLExtension>\n" +
"</ext:UBLExtensions>\n" +
"<cac:Signature>\n" +
"	<cbc:ID>"+signatoryParty+"</cbc:ID>\n" +
"	<cac:SignatoryParty>\n" +
"		<cac:PartyIdentification>\n" +
"			<cbc:ID>"+partyId+"</cbc:ID>\n" +
"		</cac:PartyIdentification>\n" +
"		<cac:PartyName>\n" +
"			<cbc:Name><![CDATA["+partyName+"]]></cbc:Name>\n" +
"		</cac:PartyName>\n" +
"	</cac:SignatoryParty>\n" +
"	<cac:DigitalSignatureAttachment>\n" +
"		<cac:ExternalReference>\n" +
"			<cbc:URI>"+uri+"</cbc:URI>\n" +
"		</cac:ExternalReference>\n" +
"	</cac:DigitalSignatureAttachment>\n" +
"</cac:Signature>";
    }
    
}
