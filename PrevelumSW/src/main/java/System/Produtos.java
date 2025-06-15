package System;

public class Produtos {
    private int id;
    private String nome;
    private String utilidade;
    private double valor;
    private String status;

    public Produtos(int id, String nome, String utilidade, double valor, String status) {
        this.id = id;
        this.nome = nome;
        this.utilidade = utilidade;
        this.valor = valor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUtilidade() {
        return utilidade;
    }

    public void setUtilidade(String utilidade) {
        this.utilidade = utilidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double preco) {
        this.valor = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
