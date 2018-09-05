
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Produto;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@Named
@SessionScoped
public class ProdutoBean implements Serializable {

    private List<Produto> produtos, produtosDestaques, produtosFiltrados;
    private List<String> images;
    private List<Produto> produtoSelecionado;
    private int id;
    private float valor;
    private String nome, tipo, pesquisa;
    private boolean promocao, destaque, itemSelecionado;

    @PostConstruct
    public void inicializar() {
        produtos = new ArrayList<>();
    }

    public void limpar() {
        nome = "";
        tipo = "";
        valor = 0;
        id = 0;
        promocao = false;
        destaque = false;
    }
    
    public boolean isItemSelecionado() {
        if(getProdutoSelecionado() == null)
            return false;
        return true;
    }

    public void setItemSelecionado(boolean itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public void salvar() {
        Produto p = new Produto();
        p.setId(id);
        p.setNome(nome);
        p.setTipo(tipo);
        p.setPromocao(promocao);
        p.setDestaque(destaque);
        p.setValor(valor);
        setImages();
        p.setImages(images);
        produtos.add(p);
        limpar();
    }
    
    public void excluir(){
        if(produtoSelecionado != null){
            for(Produto p: produtoSelecionado){
                produtos.remove(p);
            }
            if(produtoSelecionado.size() > 1)
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão de Produtos", "Produtos excluídos com sucesso!"));
            else
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão de Produtos", "Produto excluído com sucesso!"));
        }
    }
    
    public void filterList() {
        produtosFiltrados = new ArrayList<>();

}

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public List<Produto> getProdutosFiltrados() {
        return produtosFiltrados;
    }

    public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
        this.produtosFiltrados = produtosFiltrados;
    }

    public List<Produto> getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(List<Produto> produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
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

    public void setImages() {
        images = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            images.add(getNome() + "-" + getTipo() + "-" + i + ".jpg");
        }
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public List<Produto> getProdutosDestaques() {
        produtosDestaques = new ArrayList<>();
        for (Produto p : getProdutos()) {
            if (p.isDestaque()) {
                produtosDestaques.add(p);
            }
        }
        return produtosDestaques;
    }

    public void setProdutosDestaques(List<Produto> produtosDestaques) {
        this.produtosDestaques = produtosDestaques;
    }

    public void onRowEdit(RowEditEvent event) {
        Produto r = (Produto) event.getObject();

        setNome(r.getNome());
        setImages();
        r.setImages(getImages());
        r.setPromocao(isPromocao());
        r.setDestaque(isDestaque());
        r.setTipo(getTipo());
        FacesMessage msg = new FacesMessage("Produto atualizado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada", String.valueOf(((Produto) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
