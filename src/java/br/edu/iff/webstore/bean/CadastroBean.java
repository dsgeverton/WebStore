package br.edu.iff.webstore.bean;

import br.edu.iff.webstore.model.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CadastroBean implements Serializable{

    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrar(){
        produtos.add(produto);
        produto = new Produto();
    }
    
    public void limpar(){
      
    }
    
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}