package com.example.MeuWebServer2.model;

import javax.xml.bind.annotation.XmlRootElement;

// notação XmlRootElement define que este é o objeto raiz de qualquer representação (xml ou json)
// dessa classe
@XmlRootElement
public class Temperature {

    // elaborando design pattern para existir apenas uma instancia de Temperature
    private static Temperature INSTANCE = null;

    public static Temperature getInstance() {
        // se não houver instância de Temperature, cria-se uma
        if (INSTANCE == null) {
            INSTANCE = new Temperature();
            //Singleton é o nome dado ao objeto único de uma classe
            System.out.println("Criou Singleton!");
        }
        return INSTANCE;
    }

    // variavel para receber temperatura do aplicativo
    private float temperature = (float) 0.0;

    // construtor
    private Temperature() {
        this.temperature = (float) 0.0;
    }

    // construtor
    private Temperature(float temperature) {

        this.temperature=temperature;
    }

    public void setValue(float temperature) {
        this.temperature=temperature;
    }

    public float getValue() {
        return temperature;
    }

    public void convertToFahrenheit() {
        temperature = (float)1.8*temperature+32;
    }
}
