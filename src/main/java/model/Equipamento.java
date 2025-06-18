package model;

import java.util.Date;

public class Equipamento {
    private int id;
    private String nome;
    private String fabricante;
    private Date dataAquisicao;
    private String localizacao;


    public Equipamento(int id, String nome, String fabricante, Date dataAquisicao, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.dataAquisicao = dataAquisicao;
        this.localizacao = localizacao;
    }
}
