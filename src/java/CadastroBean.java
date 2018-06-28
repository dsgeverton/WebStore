
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
public class CadastroBean implements Serializable {

    private List<Produto> produtos, produtosDestaques;
    private List<String> images;
    private List<Produto> produtoSelecionado;
    private int id;
    private float valor;
    private String nome, tipo;
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
