package com.br.momento.aprendizado.momento.aprendizado;

public enum Series {
    AVERAGE_INTEREST_RATE("20744"),
    DEFAULT_RATE("21116");

    private final String serie;

    Series(String serie) {
        this.serie = serie;
    }

    public String getSerie() {
        return serie;
    }
}
