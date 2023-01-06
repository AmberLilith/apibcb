package com.br.momento.aprendizado.momento.aprendizado.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxaMediaJuros {

    private String data;

    @JsonAlias({ "valor" })
    private Double taxaMediaJuros;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getTaxaMediaJuros() {
        return taxaMediaJuros;
    }

    public void setTaxaMediaJuros(Double taxaMediaJuros) {
        this.taxaMediaJuros = taxaMediaJuros;
    }
}
