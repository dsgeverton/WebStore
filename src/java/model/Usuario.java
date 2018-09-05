
package model;

import java.io.Serializable;

public class Usuario implements Serializable{
    
   private String login;
   private String senha;
   private String nome;
   private boolean isLogado;
   
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String login) {
        this.nome = nome;
    }

    public boolean isLogado() {
        return isLogado;
    }

    public void setLogado(boolean logado) {
        this.isLogado = logado;
    }
   
   public Usuario(String nome, String login, String senha, Boolean isLogado){
       this.nome = nome;
       this.login = login;
       this.senha = senha;
       this.isLogado = isLogado;     
   }
   
   public Usuario(){}
    
}