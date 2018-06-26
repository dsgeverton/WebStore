
package br.edu.iff.webstore.bean;

import br.edu.iff.webstore.model.Produto;
import java.util.List;
import javax.annotation.PostConstruct;

public class DestaqueViewBean {

    private List<Produto> produtos;
    private Produto produtoSelecionado;
    private CadastroBean produtosCadastrados;
    
    @PostConstruct
    public void init() {
        produtos = produtosCadastrados.getProdutos();
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }
    
}
