package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.SerieFeign;
import com.br.momento.aprendizado.momento.aprendizado.models.Serie;
import com.br.momento.aprendizado.momento.aprendizado.models.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieFeign taxaFeign;

    public List<Series> getSeries(String initialDate, String finalDate) {
        List<Serie> averageInterestSeries = taxaFeign.getSerie("20744", initialDate, finalDate);
        List<Serie> defaultSeries = taxaFeign.getSerie("21116", initialDate, finalDate);
        return convertToAllRates(averageInterestSeries, defaultSeries);
    }

    public static List<Series> convertToAllRates(List<Serie> averageInterestSeries, List<Serie> defaultSerie) {
        List<Series> seriesList = new ArrayList<>();

        for (int i = 0; i < averageInterestSeries.size(); i++) {
            Series series = new Series(averageInterestSeries.get(i).getData(),
                    averageInterestSeries.get(i).getValor(),
                    defaultSerie.get(i).getValor());
            seriesList.add(series);
        }

        return seriesList;
    }
}
