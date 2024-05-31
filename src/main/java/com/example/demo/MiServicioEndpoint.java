package com.example.demo;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.model.dto.EstudianteDTO;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.stereotype.Component;

@Endpoint
public class MiServicioEndpoint {
    public static final String NAMESPACE_URI = "http://example.com/myservice";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MyRequest")
    @ResponsePayload
    public MyResponse handleMyRequest(@RequestPayload MyRequest request) {
        // Implementa la lógica de tu servicio aquí
        MyResponse response = new MyResponse();
        // ...
        return response;
    }
}