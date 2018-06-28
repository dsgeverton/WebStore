package br.edu.iff.webstore.bean;

import br.edu.iff.webstore.model.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class CadastroBean implements Serializable{

    private List<Produto> produtos;
    private int id, quantidade;
    private double preco;
    private String nome, descricao, tipo;
    private boolean habilitado, disponivel;
    private boolean destaque;
    private boolean promocao;
    
    public void init(){
        produtos = new ArrayList<>();
    }
    
    public void limpar(){
        quantidade = 0;
        preco = 0;
        nome = "";
        descricao = "";
        tipo = "";        
    }

    public void cadastrar(){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setTipo(tipo);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);
        produto.setDestaque(destaque);
        produto.setDisponivel(disponivel);
        produto.setHabilitado(habilitado);
        
        produtos.add(produto);
        
        System.out.println("entrou");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro de Clientes", "Cliente cadastrado com sucesso!"));

    }
    
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public List<Produto> getProdutos() {
        return produtos;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }
}