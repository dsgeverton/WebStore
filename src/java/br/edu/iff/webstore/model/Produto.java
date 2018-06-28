package br.edu.iff.webstore.model;

public class Produto {
    private int id, quantidade;
    private double preco;
    private String nome, descricao, tipo;
    private boolean habilitado, disponivel;
    private boolean destaque;
    private boolean promocao;

    
    public Produto(int id, int quantidade, double preco, String nome, String descricao, String tipo, boolean habilitado,
                    boolean disponivel, boolean destaque, boolean promocao){
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.habilitado = habilitado;
        this.disponivel = disponivel;
        this.destaque = destaque;
        this.promocao = promocao;               
                
    }

    public Produto() {
    }
    
    
    
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }
}
