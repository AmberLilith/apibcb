package com.br.momento.aprendizado.momento.aprendizado.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Series {

    private String date;

    private Double averageInterestRate;

    private Double defaultRate;

}

