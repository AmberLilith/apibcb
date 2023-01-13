package com.br.momento.aprendizado.momento.aprendizado;

import com.br.momento.aprendizado.momento.aprendizado.models.Taxa;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaInadimplencia;
import com.br.momento.aprendizado.momento.aprendizado.models.TaxaMediaJuros;

import java.util.ArrayList;
import java.util.List;

public class TaxaFactory {

    public static List<?> convertToTaxSerieList(List<Taxa> list, String serie){
        List<Object> newList = new ArrayList<>();
        list.forEach(taxa -> {
            Object o = switch (serie) {
                case "20744" -> new TaxaMediaJuros(taxa.getData(), taxa.getValor());
                case "21116" -> new TaxaInadimplencia(taxa.getData(), taxa.getValor());
                default -> new Object();
            };

            newList.add(o);

        });

        return newList;
    }

}
