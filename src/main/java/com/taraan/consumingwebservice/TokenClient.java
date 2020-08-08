package com.taraan.consumingwebservice;

import com.taraan.consumingwebservice.wsdl.MakeSpecialToken;
import com.taraan.consumingwebservice.wsdl.MakeSpecialTokenResponse;
import com.taraan.consumingwebservice.wsdl.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;

public class TokenClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TokenClient.class);

    public MakeSpecialTokenResponse getCountry(String country) {

        MakeSpecialToken request = new MakeSpecialToken();
        ObjectFactory objectFactory = new ObjectFactory();
        MakeSpecialToken makeSpecialToken = objectFactory.createMakeSpecialToken();
        makeSpecialToken.setAmount(objectFactory.createMakeSpecialTokenAmount("1000"));

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;
    }

}