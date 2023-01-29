package com.br.momento.aprendizado.momento.aprendizado.services;

import com.br.momento.aprendizado.momento.aprendizado.models.Series;

import java.util.List;

public interface SerieService {
    List<Series> getSeries(String initialDate, String finalDate);
}
