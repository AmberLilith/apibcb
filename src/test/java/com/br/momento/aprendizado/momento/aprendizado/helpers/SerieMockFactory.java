package com.br.momento.aprendizado.momento.aprendizado.helpers;

import com.br.momento.aprendizado.momento.aprendizado.models.Serie;
import com.br.momento.aprendizado.momento.aprendizado.models.Series;

import java.util.ArrayList;
import java.util.List;

public class SerieMockFactory {

    public static List<Serie> createListOfSerie() {
        List<Serie> series = new ArrayList<>();
        var serie1 = new Serie("01/01/2022", 4.5);
        var serie2 = new Serie("01/02/2022", 5.5);
        var serie3 = new Serie("01/03/2022", 6.5);
        series.add(serie1);
        series.add(serie2);
        series.add(serie3);
        return series;
    }


    public static List<Series> createListOfSeries() {
        List<Series> series = new ArrayList<>();
        Series series1 = new Series("01/01/2022", 4.5, 5.5);
        Series series2 = new Series("01/02/2022", 6.5, 7.5);
        Series series3 = new Series("01/03/2022", 8.5, 9.5);
        series.add(series1);
        series.add(series2);
        series.add(series3);
        return series;
    }
}
