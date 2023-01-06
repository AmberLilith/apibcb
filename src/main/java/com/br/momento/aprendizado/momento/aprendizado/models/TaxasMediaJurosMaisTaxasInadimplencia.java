package com.br.momento.aprendizado.momento.aprendizado.models;

public class TaxasMediaJurosMaisTaxasInadimplencia {

    private String data;

    private Double taxaMediaJuros;

    private Double taxaInadimplencia;

    public Double getTaxaMediaJuros() {
        return taxaMediaJuros;
    }

    public void setTaxaMediaJuros(Double taxaMediaJuros) {
        this.taxaMediaJuros = taxaMediaJuros;
    }

    public Double getTaxaInadimplencia() {
        return taxaInadimplencia;
    }

    public void setTaxaInadimplencia(Double taxaInadimplencia) {
        this.taxaInadimplencia = taxaInadimplencia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static TaxasMediaJurosMaisTaxasInadimplencia[] juntaTaxas(TaxaMediaJuros[] taxaMediaJuros, TaxaInadimplencia[] taxaInadimplencias){
        TaxasMediaJurosMaisTaxasInadimplencia[] taxasJurosInadimplencias = new TaxasMediaJurosMaisTaxasInadimplencia[taxaMediaJuros.length];

        int j = 0;
        while (j < taxasJurosInadimplencias.length){
            TaxasMediaJurosMaisTaxasInadimplencia taxasMediaJurosMaisTaxasInadimplencia;
            taxasMediaJurosMaisTaxasInadimplencia = new TaxasMediaJurosMaisTaxasInadimplencia();
            taxasMediaJurosMaisTaxasInadimplencia.setData(taxaInadimplencias[j].getData());
            taxasMediaJurosMaisTaxasInadimplencia.setTaxaMediaJuros(taxaMediaJuros[j].getTaxaMediaJuros());
            taxasMediaJurosMaisTaxasInadimplencia.setTaxaInadimplencia(taxaInadimplencias[j].getTaxaInadimplencia());
            taxasJurosInadimplencias[j] = taxasMediaJurosMaisTaxasInadimplencia;
            j++;
        }

        return taxasJurosInadimplencias;
    }
}

