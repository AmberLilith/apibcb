package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.SerieFeign;
import com.br.momento.aprendizado.momento.aprendizado.exceptions.EmptyListException;
import com.br.momento.aprendizado.momento.aprendizado.models.Serie;
import com.br.momento.aprendizado.momento.aprendizado.models.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieServiceImpl implements SerieService{

    @Autowired
    private SerieFeign taxaFeign;

    public List<Series> getSeries(String initialDate, String finalDate) {

       List<Serie> averageInterestSeries = taxaFeign.getSerie("20744", initialDate, finalDate);
           List<Serie> defaultSeries = taxaFeign.getSerie("21116", initialDate, finalDate);
           return convertToListOfSeries(averageInterestSeries, defaultSeries);

    }

    public static List<Series> convertToListOfSeries(List<Serie> averageInterestSeries, List<Serie> defaultSerie) {
        if(averageInterestSeries.isEmpty() || defaultSerie.isEmpty()){
            throw new EmptyListException("Uma das listas de série está vazia!");
        }
        List<Series> seriesList = new ArrayList<>();
        int biggestSizeList = Math.max(averageInterestSeries.size(), defaultSerie.size());

        for (int i = 0; i < biggestSizeList; i++) {
            String data = (averageInterestSeries.size() < biggestSizeList) ? defaultSerie.get(i).getData() : averageInterestSeries.get(i).getData();
            Double averageInterestSeriesValor = (averageInterestSeries.size() < biggestSizeList) ? null : averageInterestSeries.get(i).getValor();
            Double defaultSerieValor = (defaultSerie.size() < biggestSizeList) ? null : defaultSerie.get(i).getValor();
            Series series = new Series(data,
                    averageInterestSeriesValor,
                    defaultSerieValor);
            seriesList.add(series);
        }

        return seriesList;
    }
}
