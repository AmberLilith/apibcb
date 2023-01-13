package com.br.momento.aprendizado.momento.aprendizado.models;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Taxas {

    private String data;

    private Double taxaMediaJuros;

    private Double taxaInadimplencia;

    public static List<Taxas> juntaTaxas(List<?> taxaMediaJuros, List<?> taxaInadimplencias) {
        List<Taxas> taxasList = new ArrayList<>();
        Iterator<?> taxaMediaJurosIterator = taxaMediaJuros.iterator();
        Iterator<?> taxaInadimplenciaIterator = taxaInadimplencias.iterator();

        while (taxaMediaJurosIterator.hasNext() && taxaInadimplenciaIterator.hasNext()) {
            Taxas taxas = new Taxas();
            BeanUtils.copyProperties(taxaMediaJurosIterator.next(), taxas);
            BeanUtils.copyProperties(taxaInadimplenciaIterator.next(), taxas);
            taxasList.add(taxas);
        }

        return taxasList;
    }

}

