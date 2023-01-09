package com.br.momento.aprendizado.momento.aprendizado;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class Um{
    private String nome;
    private String sobrenome;



     public Um(String nome, String sobrenome) {
         this.nome = nome;
         this.sobrenome = sobrenome;


     }

     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public String getSobrenome() {
         return sobrenome;
     }

     public void setSobrenome(String sobrenome) {
         this.sobrenome = sobrenome;
     }
 }

class Dois{
    private String nome;
    private String cidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    @Override
    public String toString() {
        return "Dois{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}

class Tres{
     private String nome;
    private String cidade;
    private String estado;

    public Tres(String nome, String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

@SpringBootApplication
public class Test {

    @org.junit.jupiter.api.Test
    public void teste() {
        Um um = new Um("Amber", "Lilith");
        Tres tres = new Tres("Maria", "Ubelandia", "Minas gerais");
        Dois dois = new Dois();
        BeanUtils.copyProperties(um, dois);
        BeanUtils.copyProperties(tres, dois);
        System.out.println(dois);
    }
}
