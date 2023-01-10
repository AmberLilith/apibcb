package com.br.momento.aprendizado.momento.aprendizado;

public enum Series {
    TAXA_MEDIA_JUROS("20744"),
    TAXA_INADIMPLENCIA("21116");

    private final String serie;

    Series(String serie) {
        this.serie = serie;
    }

    public String getSerie() {
        return serie;
    }
}
