package br.edu.iff.webstore.bean;


import br.edu.iff.webstore.model.Cliente;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@SessionScoped
public class LoginBean {
     
    private String username;
    private boolean logado;

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
      public void logar(){
          System.out.println("entrouuuuu"); 
        if(username.equals("teste")
                && password.equals("123")){
            logado = true;
        }else{
            logado = false;
        }
    }
      
    public void sair(){
      username = null;
      password = null;
      logado = false;
      try {
          FacesContext.getCurrentInstance().
                  getExternalContext().
                  redirect("index.xhtml");
      } catch (IOException ex) {
          Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
}