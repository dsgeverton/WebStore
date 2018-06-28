package model;

import java.util.List;

public class Produto {
    
    private int id;
    private float valor;
    private String nome, tipo;
    private boolean promocao, destaque;
    private List<String> images;
    
    public Produto(){}
    
    public Produto(int id, float valor, String nome, boolean promocao, boolean destaque, List<String> images){
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.promocao = promocao;
        this.destaque = destaque;
        this.images = images;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }
}
