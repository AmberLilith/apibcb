package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.SerieFeign;
import com.br.momento.aprendizado.momento.aprendizado.SerieRate;
import com.br.momento.aprendizado.momento.aprendizado.models.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeriesService {

    @Autowired
    private SerieFeign serieFeign;

    public Map<String, List<Map<String, Double>>> getSeries(List<SerieRate> series,
                                                            String initialDate,
                                                            String finalDate) {

        Map<String, List<Map<String, Double>>> mapWithSeries = new HashMap<>();

        for (int i = 0; i < series.size(); i++) {
            if (i == 0) {
                List<Serie> firstSerie = serieFeign.getSerie(series.get(0).getSerie(), initialDate, finalDate);
                for (Serie rate : firstSerie) {
                    List<Map<String, Double>> listWithMapsOfSeries = new ArrayList<>();
                    mapWithSeries.put(rate.getData(), listWithMapsOfSeries);
                }
            }

            List<Serie> rates = serieFeign.getSerie(series.get(i).getSerie(), initialDate, finalDate);

            for (Serie rate : rates) {
                Map<String, Double> mapSerie = new HashMap<>();
                mapSerie.put(series.get(i).getName(), rate.getValor());
                mapWithSeries.get(rate.getData()).add(mapSerie);
            }

        }

        return mapWithSeries;
    }

}
