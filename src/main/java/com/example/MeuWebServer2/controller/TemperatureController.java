package com.example.MeuWebServer2.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.example.MeuWebServer2.model.Temperature;


@Path("/controller")
public class TemperatureController {

    private final static String TEMPERATURE = "value";

    // tenta criar o objeto do modelo - o singleton
    Temperature temperature = Temperature.getInstance();

    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    // através da anotação o Java entende que o cód abaixo quer extrair o get request
    @GET // teste para checar se o servico está ok
    // produz um texto
    @Produces(MediaType.TEXT_PLAIN)
    // método retorna numa página se o servidor está funcionando ou não
    public String statusService() {
        return "O servico esta em operacao";
    }

    // no recebimento de um GET request nessa rota
    @GET
    @Path("convert_temperature")
    // produz um JSON
    @Produces (MediaType.APPLICATION_JSON)
    public Temperature getTemperature() {

        System.out.println("Pedido de conversão pelo app cliente: " + temperature.getValue());

        temperature.convertToFahrenheit();

        return temperature;
    }

    @POST
    // esse post consome um form
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    // produz um JSON
    @Produces(MediaType.APPLICATION_JSON)
    public Temperature postTemperature(MultivaluedMap<String, String> parameters) {

        // transforma temperatura recebida para float
        float temperatureInternal = Float.parseFloat(parameters.getFirst(TEMPERATURE));

        //seta valor da temperatura recebida
        temperature.setValue(temperatureInternal);

        System.out.println("Dados recebidos!");

        return temperature;
    }
}